package exm.stc.ic.opt.valuenumber;

import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;

import exm.stc.common.Logging;
import exm.stc.common.exceptions.STCRuntimeError;
import exm.stc.common.lang.Arg;
import exm.stc.common.lang.ForeignFunctions;
import exm.stc.common.lang.Var;
import exm.stc.common.lang.Var.Alloc;
import exm.stc.common.util.HierarchicalSet;
import exm.stc.common.util.Pair;
import exm.stc.common.util.TernaryLogic.Ternary;
import exm.stc.ic.aliases.Alias;
import exm.stc.ic.aliases.AliasKey;
import exm.stc.ic.aliases.AliasTracker;
import exm.stc.ic.opt.InitVariables.InitState;
import exm.stc.ic.opt.valuenumber.ClosedVarTracker.AliasFinder;
import exm.stc.ic.opt.valuenumber.ClosedVarTracker.ClosedEntry;
import exm.stc.ic.opt.valuenumber.ComputedValue.ArgCV;
import exm.stc.ic.opt.valuenumber.ComputedValue.ArgOrCV;
import exm.stc.ic.opt.valuenumber.ComputedValue.CongruenceType;
import exm.stc.ic.opt.valuenumber.ValLoc.Closed;
import exm.stc.ic.opt.valuenumber.ValLoc.IsAssign;
import exm.stc.ic.tree.ICTree.GlobalConstants;
import exm.stc.ic.tree.ICTree.RenameMode;
import exm.stc.ic.tree.Opcode;

/**
 * Track which variables/values are congruent with each other
 * In particular, track which is the "canonical" version to use.
 * Looking up a variable in the map will give you back the canonical
 * congruent variable.
 *
 * We have two notions of congruence: by-value (reading results in same thing),
 * and by-alias (reading & writing results in same effect).
 *
 * This module uses a notion of "Congruence Set", which contains
 * all values known to be congruent to each other, to allow
 * accurate tracking of congruence relationship.  We retain
 * enough info to answer these kinds of questions:
 *
 * - Given a ComputedValue or Arg, what congruence set is it in?
 *                                          (by value/by alias)?
 * - Given a (by alias or by value) congruence set, what is
 *                                            the canonical Arg?
 * - Given a Var in a REFERENCE/VALUE context, what should we
 *    replace it with, if anything?
 *
 * The notion of by-value congruence can't totally disregard whether a
 * variable is mapped: we can only have one mapped variable in each
 * congruence set, and it must be the canonical member
 *
 * TODO: get algebra logic to rerun upon change
 */
public class Congruences implements AliasFinder {

  private final Logger logger;
  private final GlobalConstants consts;
  @SuppressWarnings("unused")
  private final Congruences parent;
  private final ClosedVarTracker track;
  private final CongruentSets byValue;
  private final CongruentSets byAlias;
  private final AliasTracker aliasTracker;
  private final HierarchicalSet<List<Arg>> maybeAssigned;
  private final boolean reorderingAllowed;

  private Congruences(Logger logger,
                        GlobalConstants consts,
                        Congruences parent,
                        ClosedVarTracker track,
                        CongruentSets byValue,
                        CongruentSets byAlias,
                        AliasTracker aliasTracker,
                        HierarchicalSet<List<Arg>> maybeAssigned,
                        boolean reorderingAllowed) {
    this.logger = logger;
    this.consts = consts;
    this.parent = parent;
    this.track = track;
    this.byValue = byValue;
    this.byAlias = byAlias;
    this.aliasTracker = aliasTracker;
    this.maybeAssigned = maybeAssigned;
    this.reorderingAllowed = reorderingAllowed;
  }

  public Congruences(Logger logger, ForeignFunctions foreignFuncs,
      GlobalConstants consts, boolean reorderingAllowed) {
    this(logger, consts, null,
        ClosedVarTracker.makeRoot(logger, reorderingAllowed),
        CongruentSets.makeRoot(foreignFuncs, CongruenceType.VALUE),
         CongruentSets.makeRoot(foreignFuncs, CongruenceType.ALIAS),
         new AliasTracker(),
         new HierarchicalSet<List<Arg>>(),
         reorderingAllowed);
  }

  public Congruences enterContBlock(boolean varsFromParent,
                                    int parentStmtIndex) {
    Congruences child = new Congruences(logger, consts, this,
             track.enterContinuation(parentStmtIndex),
             byValue.makeChild(varsFromParent),
             byAlias.makeChild(varsFromParent),
             aliasTracker.makeChild(),
             maybeAssigned.makeChild(), reorderingAllowed);

    /*
     * TODO: how to handle difference between information that is shared
     * between inner/outer scopes.  E.g.
     * - Congruences are valid inside and outside of wait
     * - Except considering obstructions to variable passing:
     *    ->> consider handling this in replacement walk, by
     *        iterating over alternatives
     * - Closed info is sensitive to execution order: need to create new
     *    one per state
     */
    return child;
  }

  /**
   * Note that variables were declared in this scope
   * @param vars
   */
  public void varDeclarations(Collection<Var> vars) {
    byAlias.varDeclarations(vars);
    byValue.varDeclarations(vars);
  }

  /**
   * Update state with values and alias info
   * @param consts
   * @param errContext
   * @param resVals values for program point, may be null
   * @param aliases aliases for program point, may be null
   * @param stmtIndex
   * @throws OptUnsafeError
   */
  public void update(GlobalConstants consts, String errContext,
      List<ValLoc> resVals, List<Alias> aliases, int stmtIndex)
          throws OptUnsafeError {
    if (aliases != null) {
      // Get aliases up to date first since they don't depend on others here
      aliasTracker.update(aliases);
    }

    if (resVals != null) {
      for (ValLoc resVal: resVals) {
        update(consts, errContext, resVal, stmtIndex);
      }
    }
  }

  /**
   * Update the state with a ValLoc for a given program point
   * @param consts
   * @param errContext
   * @param resVal
   * @param stmtIndex
   * @throws OptUnsafeError
   */
  public void update(GlobalConstants consts, String errContext,
           ValLoc resVal, int stmtIndex) throws OptUnsafeError {
    if (logger.isTraceEnabled()) {
      logger.trace("update: " + resVal + " " + resVal.congType());
    }

    if (resVal.congType() == CongruenceType.ALIAS) {
      // Update aliases only if congType matches
      update(consts, errContext, resVal.location(), resVal.value(),
                      resVal.isAssign(), byAlias, true, stmtIndex);
    } else {
      assert(resVal.congType() == CongruenceType.VALUE);
    }

    /*
     * After alias updates, mark arg as closed, so that closedness
     * is propagated to all in set.  Do this before updating value
     * congruence so that we can pick a closed variable to represent
     * the value if possible.
     */
    markClosed(resVal.location(), stmtIndex, resVal.locClosed());

    // Both alias and value links result in updates to value
    update(consts, errContext, resVal.location(), resVal.value(),
           resVal.isAssign(), byValue, true, stmtIndex);

    // Check assignment after all other updates, so that any
    // contradictions get propagated correctly
    markAssigned(errContext, consts, resVal);
  }

  /**
   * Update a congruentSet with the information that value is stored
   * in location
   * @param consts Global constants to add canonical vals if needed
   * @param errContext
   * @param location
   * @param value
   * @param isAssign YES if value represents a single-assignment location
   *                and location is the thing stored to that location
   * @param congruent
   * @param addConsequential
   * @throws OptUnsafeError
   */
  private void update(GlobalConstants consts, String errContext,
            Arg location, ArgCV value, IsAssign isAssign,
            CongruentSets congruent, boolean addConsequential, int stmtIndex)
                throws OptUnsafeError {
    // Canonicalize both values
    ArgOrCV canonLoc = congruent.findCanonical(location);
    assert(canonLoc.isArg()); // Arg shouldn't canonicalize to non-arg
    ArgOrCV canonVal = congruent.findCanonical(consts, value);
      // Need to merge together two existing sets
    mergeSets(errContext, canonVal, consts, congruent,
              canonVal, canonLoc, isAssign, stmtIndex);

    if (addConsequential) {
      addInverses(consts, errContext, canonLoc.arg(), canonVal, stmtIndex);
      addInferred(consts, errContext, congruent, stmtIndex, canonLoc.arg(),
                  canonVal);
    }
  }

  private CongruentSets getCongruentSet(CongruenceType congType) {
    if (congType == CongruenceType.VALUE) {
      return byValue;
    } else {
      assert(congType == CongruenceType.ALIAS);
      return byAlias;
    }
  }

  /**
   * Make two abstract locations equivalent.
   *
   * @param errContext
   * @param congruent
   * @param stmtIndex
   * @param val1
   * @param val2
   * @throws OptUnsafeError
   */
  private void equateValues(String errContext,
          CongruentSets congruent, int stmtIndex,
          ArgCV val1, ArgCV val2) throws OptUnsafeError {
    /*
     * Merge the two sets
     */
    ArgOrCV canon1 = congruent.findCanonical(consts, val1);
    ArgOrCV canon2 = congruent.findCanonical(consts, val2);
    mergeSets(errContext, "Equating " + val1 + " == " + val2, consts,
              congruent, canon1, canon2, IsAssign.NO, stmtIndex);
  }

  private void updateInv(GlobalConstants consts, String errContext,
      Arg invOutput, ArgCV invVal, int stmtIndex)
          throws OptUnsafeError {
    CongruentSets valCong = getCongruentSet(CongruenceType.VALUE);
    update(consts, errContext, invOutput, invVal, IsAssign.NO,
           valCong, false, stmtIndex);
  }
  /**
   * Merge two congruence sets that are newly connected via value
   * @param errContext
   * @param mergeCause object where toString() gets explanation of merge cause
   * @param congruent
   * @param newLoc representative of set with location just maybeAssigned
   * @param oldLoc representative of existing set
   * @throws OptUnsafeError
   */
  private void mergeSets(String errContext, Object mergeCause,
      GlobalConstants consts, CongruentSets congruent,
      ArgOrCV oldLoc, ArgOrCV newLoc, IsAssign newIsAssign, int stmtIndex)
          throws OptUnsafeError {
    if (newLoc.equals(oldLoc)) {
      // Already merged
      return;
    }

    checkNoContradiction(errContext, congruent.congType,
                          mergeCause, newLoc, oldLoc);

    // Must merge.  Select which is the preferred value
    // (for replacement purposes, etc.)
    ArgOrCV winner = preferred(congruent, oldLoc, newLoc, newIsAssign, stmtIndex);
    ArgOrCV loser = (winner.equals(oldLoc) ? newLoc : oldLoc);
    if (logger.isTraceEnabled()) {
      logger.trace("old: " + oldLoc + " vs. new: " + newLoc +
                   " winner: " + winner);
    }
    changeCanonical(consts, congruent, loser, winner);
  }

  /**
   * Helper function to update CongruentSets plus any other info
   * @param congruent
   * @param locCV
   * @param canonicalFromVal
   */
  private void changeCanonical(GlobalConstants consts,
          CongruentSets congruent, ArgOrCV oldVal, ArgOrCV newVal) {
    assert(!oldVal.equals(newVal));

    if (congruent.congType == CongruenceType.VALUE) {
      // Two mapped variables with same value aren't interchangeable: abort!
      if (oldVal.isArg() && oldVal.arg().isMapped() != Ternary.FALSE) {
        return;
      }
    }

    congruent.changeCanonical(consts, oldVal, newVal);
  }

  /**
   * Check if vals contradict each other.
   * @param errContext
   * @param congType
   * @param mergeCause
   * @param val1
   * @param val2
   * @throw {@link OptUnsafeError} if problem found
   */
  private void checkNoContradiction(String errContext,
    CongruenceType congType, Object mergeCause, ArgOrCV val1, ArgOrCV val2)
    throws OptUnsafeError {
    boolean contradiction = false;

    if (val1.isArg() && val2.isArg()) {
      Arg arg1 = val1.arg();
      Arg arg2 = val2.arg();
      if (congType == CongruenceType.VALUE) {
        if (arg1.isConst() && arg2.isConst() && !arg1.equals(arg2)) {
          contradiction = true;
        }
      } else {
        assert(congType == CongruenceType.ALIAS);
        assert(arg1.isVar() && arg2.isVar());
        if (arg1.getVar().storage() != Alloc.ALIAS &&
            arg2.getVar().storage() != Alloc.ALIAS &&
            !arg1.getVar().equals(arg2.getVar())) {
          contradiction = true;
        }
      }
    }

    if (contradiction) {
      Logging.uniqueWarn("Invalid code detected during optimization. "
          + "Conflicting values congruence type " + congType + " "
          + mergeCause + ": " + val1 +
          " != " + val2 + " in " + errContext + ".\n"
          + "This may have been caused by a double-write to a variable. "
          + "Please look at any previous warnings emitted by compiler. "
          + "Otherwise this could indicate a stc bug");
      throw new OptUnsafeError();
    }
  }

  /**
   * Check which arg is preferred as the replacement.
   *
   * Note that this ordering is important for correctness.  If we replace
   * a closed var with a non-closed var, we may produce incorrect results.
   * @param track
   * @param congType
   * @param oldVal current one
   * @param newVal oldOne
   * @return the preferred of the two args
   */
  private ArgOrCV preferred(CongruentSets congruent,
            ArgOrCV oldVal, ArgOrCV newVal, IsAssign newIsAssign,
            int stmtIndex) {
    if (oldVal.isArg() && newVal.isArg()) {
      return preferredArg(congruent, oldVal, newVal, newIsAssign, stmtIndex);
    } else if (oldVal.isArg()) {
      return oldVal;
    } else if (newVal.isArg()) {
      return newVal;
    } else {
      // Default to old val
      return oldVal;
    }
  }

  private ArgOrCV preferredArg(CongruentSets congruent,
              ArgOrCV oldVal, ArgOrCV newVal, IsAssign newIsAssign, int stmtIndex) {
    Arg oldArg = oldVal.arg();
    Arg newArg = newVal.arg();
    if (congruent.congType == CongruenceType.VALUE) {
      // Constants trump all
      if (isConst(oldArg)) {
        return oldVal;
      } else if (isConst(newArg)) {
        return newVal;
      }
      /*
       * If newArg was stored directly to the location, doesn't make
       * sense to substitute.  In some cases this could result in a
       * bad substitution creating a circular dependency.  We handle
       * the situation where double-assignment occurs separately: a
       * double-assignment tends to be an error and we disable optimization
       * more aggressively in those cases.
       */
      if (newIsAssign == IsAssign.TO_VALUE) {
        return newVal;
      }

    } else {
      assert(congruent.congType == CongruenceType.ALIAS);
      assert(oldArg.isVar() && newArg.isVar());
      // Shouldn't have alias equivalence on values
      // Prefer non-alias (i.e. direct handle)
      if (oldArg.getVar().storage() != Alloc.ALIAS) {
        return oldVal;
      } else if (newArg.getVar().storage() != Alloc.ALIAS){
        return newVal;
      }
    }

    // Check if accessible (based on passability).
    // Assume new one is accessible
    if (!congruent.isAccessible(oldArg.getVar())) {
       return newVal;
    }

    // Prefer closed
    if (congruent.congType == CongruenceType.VALUE) {
      // Check if this gives us a reason to prefer newArg
      if (isRecClosed(newArg.getVar(), stmtIndex) &&
          !isRecClosed(oldArg.getVar(), stmtIndex)) {
        return newVal;
      } else if (isClosed(newArg.getVar(), stmtIndex)
              && !isClosed(oldArg.getVar(), stmtIndex)) {
        return newVal;
      }
    }

    // otherwise keep old arg
    return oldVal;
  }

  /**
   * Check if argument is a value or future constant
   * @param arg
   * @return
   */
  private static boolean isConst(Arg arg) {
    return arg.isConst() ||
        (arg.isVar() && arg.getVar().storage().isConst());
  }

  private Var getCanonicalAlias(Arg varArg) {
    assert(varArg.isVar()) : varArg;
    ArgOrCV canonical = byAlias.findCanonical(varArg);
    assert(canonical.isArg());
    assert(canonical.arg().isVar()) : "Should only have a variable as" +
    		    " canonical member in ALIAS congruence relationship";
    return canonical.arg().getVar();
  }

  /**
   *
   * @param vall
   * @return Canonical alias, or null
   */
  private Var getCanonicalAlias(ArgCV val) {
    ArgOrCV canonical = byAlias.findCanonical(consts, val);
    if (canonical == null || !canonical.isArg()) {
      return null;
    }
    assert(canonical.arg().isVar()) : "Should only have a variable as" +
            " canonical member in ALIAS congruence relationship";
    return canonical.arg().getVar();
  }

  /**
   *
   * @param canonLoc CV representing a single assignment location
   * @param assign
   * @throws OptUnsafeError
   */
  private void markAssigned(String errContext, GlobalConstants consts,
                  ValLoc vl) throws OptUnsafeError {
    List<Arg> assigned;
    if (vl.isAssign() == IsAssign.NO) {
      return;
    } else if (vl.isAssign() == IsAssign.TO_LOCATION) {
      Arg location = vl.location();
      assert(location.isVar()) : "Can't assign constant: " + location;
      assigned = Collections.singletonList(location);
    } else {
      assert(vl.isAssign() == IsAssign.TO_VALUE);
      assigned = canonicalizeAssignValue(consts, vl.value());
    }

    if (maybeAssigned.contains(assigned)) {
      // Potential double assignment: avoid doing any optimizations on
      // the contents of this location.
      logger.debug("Potential double assignment to " + assigned + " from " + vl);

      Logging.uniqueWarn("Invalid code detected during optimization. "
          + "Double assignment to " + printableAssignValue(assigned) + " in " + errContext + ".\n"
          + "This may have been caused by a double-write to a variable. "
          + "Please look at any previous warnings emitted by compiler. "
          + "Otherwise this could indicate a stc bug");
      throw new OptUnsafeError();
    }
    if (logger.isTraceEnabled()) {
      logger.trace("First assignment to " + assigned);
    }
    maybeAssigned.add(assigned);

    // TODO: will need to unify stored state from branches
    // TODO: will need to merge maybeAssigned info upon congruence merges.
    //          E.g. if A[x], A[y] are stored and we find out that x == y
  }

  /**
   * User friendly string for location.
   * @param assigned
   * @return
   */
  private String printableAssignValue(List<Arg> assigned) {
    assert(assigned.size() > 0);
    StringBuilder sb = new StringBuilder();
    sb.append(assigned.get(0).toString());
    for (Arg arg: assigned.subList(1, assigned.size())) {
      sb.append("[" + arg + "]");
    }
    return sb.toString();
  }

  private List<Arg> canonicalizeAssignValue(GlobalConstants consts,
                                            ArgCV val) {
    // Canonicalize location as appropriate
    //  (e.g. root var by alias and subscripts by value)

    if (val.isArrayMemberVal() || val.isArrayMember()) {
      Arg arr = byAlias.findCanonical(val.getInput(0)).arg();
      Arg ix = byValue.findCanonical(val.getInput(1)).arg();
      return Arrays.asList(arr, ix);
    } else if (val.isStructFieldVal() || val.isStructFieldAlias() ||
        val.isStructFieldCopy() || val.isStructFieldValRef()) {
      List<Arg> inputs = val.getInputs();
      List<Arg> result = new ArrayList<Arg>(inputs.size());
      assert(inputs.size() >= 2);

      Arg struct = inputs.get(0);
      result.add(byAlias.findCanonical(struct).arg());

      for (int i = 1; i < inputs.size(); i++) {
        Arg field = inputs.get(i);

        result.add(byValue.findCanonical(field).arg());
      }
      return result;
    } else if (val.isFilenameValCV() ||
               val.isFilenameAliasCV() ||
               val.isLocalFilenameCV()) {
      return Arrays.asList(Arg.newString("filename"),
                           byAlias.findCanonical(val.getInput(0)).arg());
    } else {
      throw new STCRuntimeError("Don't know how to canonicalize " +
                            val + " for assignment value tracking");
    }
  }

  public void markClosed(Var var, int stmtIndex, boolean recursive) {
    markClosed(var, false, stmtIndex, recursive);
  }

  public void markClosedBlockStart(Var var, boolean recursive) {
    markClosed(var, true, -1, recursive);
  }

  private void markClosed(Var var, boolean blockStart, int stmtIndex, boolean recursive) {
    if (!trackClosed(var)) {
      // Don't bother tracking this info: not actually closed
      return;
    }

    Var canonical = getCanonicalAlias(var.asArg());
    markClosedInTracker(blockStart, stmtIndex, recursive, canonical);

    // use alias tracker to mark elems of alias closed
    for (Var component: aliasTracker.getDatumComponents(canonical, recursive)) {
      markClosedInTracker(blockStart, stmtIndex, recursive,
                          getCanonicalAlias(component.asArg()));
    }
  }

  private void markClosedInTracker(boolean blockStart, int stmtIndex,
      boolean recursive, Var canonical) {
    if (blockStart) {
      track.closeBlockStart(canonical, recursive);
    } else {
      track.close(canonical, stmtIndex, recursive);
    }
  }

  /**
   * Update data structures to reflect that location is closed
   * @param track
   * @param closed
   * @param resVal
   */
  private void markClosed(Arg location, int stmtIndex, Closed closed) {
    if (closed != Closed.MAYBE_NOT && location.isVar()) {
      // Mark the canonical version of the variable closed
      boolean recursive;
      if (closed == Closed.YES_NOT_RECURSIVE) {
        recursive = false;
      } else {
        assert(closed == Closed.YES_RECURSIVE);
        recursive = true;
      }
      Var closedVar = location.getVar();
      markClosed(closedVar, stmtIndex, recursive);
    }
  }

  public boolean isClosed(Var var, int stmtIndex) {
    return isClosed(var.asArg(), stmtIndex);
  }

  public boolean isClosed(Arg varArg, int stmtIndex) {
    return isClosed(varArg, stmtIndex, false);
  }

  public boolean isClosed(ArgCV val, int stmtIndex) {
    return isClosed(val, stmtIndex, false);
  }

  public boolean isRecClosed(Var var, int stmtIndex) {
    return isRecClosed(var.asArg(), stmtIndex);
  }

  public boolean isRecClosed(Arg varArg, int stmtIndex) {
    return isClosed(varArg, stmtIndex, true);
  }

  public boolean isRecClosed(ArgCV val, int stmtIndex) {
    return isClosed(val, stmtIndex, true);
  }

  /**
   * Check if variable is closed before a given statement starts executing
   * @param varArg
   * @param stmtIndex
   * @param recursive
   * @return
   */
  private boolean isClosed(Arg varArg, int stmtIndex, boolean recursive) {
    if (logger.isTraceEnabled()) {
      logger.trace("Checking closed: " + varArg + "@" + stmtIndex + " rec: "
                  + recursive);
    }

    // Find canonical var for alias, and check if that is closed.
    if (varArg.isConst() || !trackClosed(varArg.getVar())) {
      // No write refcount - always closed
      logger.trace(varArg + " has no refcount");
      return true;
    }


    Var canonicalAlias = getCanonicalAlias(varArg);
    ClosedEntry ce = getClosedEntry(canonicalAlias, stmtIndex, recursive);
    if (ce != null && ce.matches(recursive, stmtIndex)) {
      logger.trace(varArg + "/" + canonicalAlias + " closed @ "
                 + ce.stmtIndex);
      return true;
    }


    for (Pair<AliasKey, Boolean> ancestor:
              aliasTracker.getAncestors(canonicalAlias)) {
      AliasKey ancestorKey = ancestor.val1;
      boolean traversedRef = ancestor.val2;
      Var ancestorVar = aliasTracker.findVar(ancestorKey);

      if (logger.isTraceEnabled()) {
        logger.trace("Checking ancestor close: " + ancestorVar +
                     " ancestor of " + canonicalAlias +
                     " traversed ref: " + traversedRef);
      }

      if (ancestorVar != null) {
        boolean ancestorRecursive = recursive || traversedRef;
        Var ancestorCanonical = getCanonicalAlias(ancestorVar.asArg());
        ce = getClosedEntry(ancestorCanonical, stmtIndex, ancestorRecursive);
        if (ce != null) {
          // Mark whether this is closed
          markClosed(canonicalAlias, ce.stmtIndex, recursive);
          if (ce.matches(ancestorRecursive, stmtIndex)) {
            logger.trace(varArg + "/" + canonicalAlias + " closed @ "
                         + stmtIndex);
            return true;
          }
        }
      }
    }
    return false;
  }

  /**
   * Lookup closed entry, updating info for subsequent lookups
   * @param canonicalAlias
   * @param stmtIndex
   * @param recursive
   * @return
   */
  private ClosedEntry getClosedEntry(Var canonicalAlias, int stmtIndex,
                                      boolean recursive) {

    ClosedEntry ce;
    ce = track.getClosedEntry(canonicalAlias, recursive, stmtIndex, this);
    if (logger.isTraceEnabled()) {
      logger.trace("Closed " + canonicalAlias +": " + ce);
    }
    if (ce != null) {
      // Mark as closed to avoid having to trace back again like this.
      track.close(canonicalAlias, ce);
    }
    return ce;
  }


  private boolean isClosed(ArgCV val, int stmtIndex, boolean recursive) {
    // See if we can resolve alias to variable
    Var canon = getCanonicalAlias(val);
    if (canon == null) {
      // No info - assume not closed
      return false;
    }
    return isClosed(canon.asArg(), stmtIndex, recursive);
  }

  /**
   * Whether we should track closed status for this var
   * @param var
   * @return
   */
  private boolean trackClosed(Var var) {
    return var.storage() != Alloc.LOCAL &&
           var.storage() != Alloc.GLOBAL_CONST;
  }

  public Set<Var> getClosed(int stmtIndex) {
    return new ClosedSet(stmtIndex, false);
  }

  public Set<Var> getRecursivelyClosed(int stmtIndex) {
    return new ClosedSet(stmtIndex, true);
  }

  public Set<ArgCV> getClosedLocs(int stmtIndex) {
    return new ClosedCVSet(stmtIndex, false);
  }

  public Set<ArgCV> getRecursivelyClosedLocs(int stmtIndex) {
    return new ClosedCVSet(stmtIndex, true);
  }

  /**
   * Return set of vars that were closed in this scope but
   * not in parent scopes
   * @param recursiveOnly
   * @return
   */
  public Set<Var> getScopeClosed(boolean recursiveOnly) {
    // Get variables that can be inferred to be closed
    Set<Var> nonAlias = track.getScopeClosed(recursiveOnly);

    // In parent scope, some alias sets that might be merged.  Add in
    // a representative that was merged into the closed set.  We know
    // that each var returned by getScopeClosed was at some point in this
    // block.  By backtrakcing through merges that happened in this block,
    // we can find the canonical representatives of all set in the parent
    // block.
    // As optimization, only create new set on demand
    Set<Var> expanded = null;

    for (Var closed: nonAlias) {
      Iterable<ArgOrCV> scopeMerged =
          byAlias.mergedCanonicalsThisScope(new ArgOrCV(closed.asArg()));
      for (ArgOrCV merged: scopeMerged) {
        if (merged.isArg() && merged.arg().isVar()) {
          if (expanded == null) {
            // Copy to new set
            expanded = new HashSet<Var>();
            expanded.addAll(nonAlias);
          }
          expanded.add(merged.arg().getVar());
        }
      }
    }
    if (expanded != null) {
      return expanded;
    } else {
      return nonAlias;
    }
  }

  /**
   * @param mode
   * @param init
   * @return replacements in effect for given rename mode
   */
  public Map<Var, Arg> replacements(RenameMode mode, InitState init) {
    if (mode == RenameMode.VALUE) {
      return byValue.getReplacementMap(init);
    } else {
      assert(mode == RenameMode.REFERENCE);
      return byAlias.getReplacementMap(init);
    }
  }

  public void printTraceInfo(Logger logger, GlobalConstants consts) {
    logger.trace("State dump for " + System.identityHashCode(this));
    byAlias.printTraceInfo(logger, consts);
    byValue.printTraceInfo(logger, consts);
    track.printTraceInfo(logger);
  }

  /**
   * Do any internal validations
   */
  public void validate(GlobalConstants consts) {
    byAlias.validate(consts);
    byValue.validate(consts);
  }

  /**
   * See if the result of a value retrieval is already in scope
   * Returns nothing if contradiction found!
   * @param v
   * @return
   */
  public Arg findRetrieveResult(Var v, boolean recursive) {
    ArgOrCV val = byValue.findRetrieveResult(v.asArg(), recursive);

    return maybeArg(val);
  }

  private Arg maybeArg(ArgOrCV val) {
    if (val != null) {
      return val.maybeArg();
    }
    return null;
  }

  public Set<Var> retrieveResultAvail() {
    return new RetrieveAvailSet();
  }

  public Arg findValue(Var var) {
    assert(var != null);
    ArgOrCV val = byValue.findCanonical(var.asArg());

    return maybeArg(val);
  }

  /**
   * @return canonical location for given value, null if not stored anywhere
   */
  public Arg findCanonical(ArgCV val, CongruenceType congType) {
    ArgOrCV canon = getCongruentSet(congType).findCanonical(consts, val);

    return maybeArg(canon);
  }

  public boolean isAvailable(ArgCV val, CongruenceType congType) {
    return findCanonical(val, congType) != null;
  }

  public Set<ArgOrCV> findCongruent(ArgOrCV arg, CongruenceType congType) {
    return getCongruentSet(congType).findCongruentValues(arg);
  }


  @Override
  public List<Var> getAliasesOf(Var var) {
    List<Var> result = new ArrayList<Var>();

    for (ArgOrCV alias: byAlias.findCongruentValues(var.asArg())) {
      if (alias.isArg() && alias.arg().isVar()) {
        result.add(alias.arg().getVar());
      }
    }

    return result;
  }

  public void addUnifiedValues(GlobalConstants consts, String errContext,
           int stmtIndex, UnifiedValues unified)
               throws OptUnsafeError {
    // TODO: need to refine this merge to compensate for sets being
    //      named differently in child
    for (Var closed: unified.closed) {
      markClosed(closed, stmtIndex, false);
    }
    for (Var closed: unified.recursivelyClosed) {
      markClosed(closed, stmtIndex, true);
    }

    update(consts, errContext, unified.availableVals, null, stmtIndex);
  }

  /**
   * Return iterator over values that are defined only in the
   * current scope (ignore outer scopes)
   * @param congType
   * @return
   */
  public Iterable<ArgOrCV> availableThisScope(CongruenceType congType) {
    return getCongruentSet(congType).availableThisScope();
  }

  /**
   * Convert from ArgOrCV into ArgCV implementation
   * @param val
   * @param congType
   * @return
   */
  public ArgCV convertToArgs(ArgOrCV val, CongruenceType congType) {
    if (val.isArg()) {
      if (congType == CongruenceType.VALUE) {
        return ComputedValue.makeCopy(val.arg());
      } else {
        assert(congType == CongruenceType.ALIAS);
        return ComputedValue.makeAlias(val.arg());
      }
    } else {
      assert(val.isCV());
      return val.cv();
    }
  }

  /**
   * Add in closedness dependency: if to is closed, implies
   * from is closed
   * @param to
   * @param fromVars
   * TODO: this information can be propagated up the IR tree, since if
   *      A -> B in a wait statement, this implies that in any parent
   *      blocks, that if B is set, then A is set (assuming no
   *      contradictions)
   */
  public void setDependencies(Var to, List<Var> fromVars) {
    Var toCanon = getCanonicalAlias(to.asArg());
    for (Var fromVar: fromVars) {
      Var fromCanon = getCanonicalAlias(fromVar.asArg());
      track.setDependency(toCanon, fromCanon);
    }
  }

  public boolean isAccessible(Var var) {
    return byValue.isAccessible(var);
  }

  /**
   * Add any inverse operations that can be directly inferred from
   * a value that was just added
   * @param errContext
   * @param canonLoc
   * @param canonVal
   * @throws OptUnsafeError
   */
  private void addInverses(GlobalConstants consts, String errContext,
                          Arg canonLoc, ArgOrCV canonVal, int stmtIndex)
                              throws OptUnsafeError {
    Pair<Arg, ArgCV> result = inverseVal(consts, canonLoc, canonVal);

    if (result != null) {
      updateInv(consts, errContext, result.val1, result.val2, stmtIndex);
    }
  }

  private Pair<Arg, ArgCV> inverseVal(GlobalConstants consts, Arg canonLoc,
      ArgOrCV canonVal) {
    ArgCV invVal = null;
    Arg invLoc = null;
    if (canonVal.isCV() && canonVal.cv().inputs.size() == 1) {
      ComputedValue<Arg> cv = canonVal.cv();
      invLoc = cv.getInput(0);

      // Only add value congruences to be safe
      // It might be possible to handle ALIAS congruences, e.g. for
      // STORE_REF/LOAD_REF pair here later on (TODO)
      if (cv.op().isAssign(false)) {
        invVal = ComputedValue.retrieveCompVal(canonLoc.getVar(), false);
        assert(invVal != null): canonLoc.getVar();
      } else if (cv.op().isRecursiveAssign()) {
        invVal = ComputedValue.retrieveCompVal(canonLoc.getVar(), true);
      } else if (cv.op().isRetrieve(false)) {
        if (cv.op() == Opcode.LOAD_FILE) {
          // Extra arg required
          invVal = ComputedValue.assignFileCompVal(canonLoc, Arg.FALSE);
        } else {
          invVal = ComputedValue.assignCompVal(invLoc, canonLoc, false);
        }
      } else if (cv.op().isRecursiveRetrieve()) {
        invVal = ComputedValue.assignCompVal(invLoc, canonLoc, true);
      }
    } else if (canonVal.isArg() && canonVal.arg().isVar() &&
               canonVal.arg().getVar().storage() == Alloc.GLOBAL_CONST) {
      // Add value for retrieval of global
      Var globalConst = canonVal.arg().getVar();
      invLoc = consts.lookupByVar(globalConst);
      assert(invLoc != null);
      invVal = ComputedValue.retrieveCompVal(globalConst, false);
    }

    if (invVal == null) {
      return null;
    } else {
      return  Pair.create(invLoc, invVal);
    }
  }

  private void addInferred(GlobalConstants consts, String errContext,
      CongruentSets congruent, int stmtIndex, Arg canonLoc, ArgOrCV canonVal)
      throws OptUnsafeError {
    if (canonVal.isCV()) {
      ArgCV cv = canonVal.cv();
      for (ArgCV extra: Algebra.tryAlgebra(this, cv)) {
        update(consts, errContext, canonLoc, extra, IsAssign.NO,
               congruent, false, stmtIndex);
      }
      if (cv.isArrayMemberVal() || cv.isArrayMember()) {
        Var arr = cv.getInput(0).getVar();
        Arg ix = cv.getInput(1);
        update(consts, errContext, Arg.TRUE,
                  ComputedValue.arrayContainsCV(arr, ix), IsAssign.NO,
                  congruent, false, stmtIndex);
      }
      addInferredFilename(errContext, congruent, canonLoc, cv, stmtIndex);
    }
  }

  /**
   * Attempt to infer filenames when stores/retrieves occur
   * @param errContext
   * @param congruent
   * @param canonLoc
   * @param cv
   * @throws OptUnsafeError
   */
  private void addInferredFilename(String errContext,
          CongruentSets congruent, Arg canonLoc, ArgCV cv, int stmtIndex)
                  throws OptUnsafeError {
    if (cv.op() == Opcode.STORE_FILE) {
      addInferredStoreFile(errContext, congruent, canonLoc, cv, stmtIndex);
    } else if (cv.op() == Opcode.LOAD_FILE) {
      addInferredLoadFile(errContext, congruent, canonLoc, cv, stmtIndex);
    } else if (cv.isFilenameAliasCV()) {
      addInferredFilenameAlias(errContext, congruent, canonLoc, cv, stmtIndex);
    } else if (cv.op().isRetrieveContainer(true)) {
      addInferredRetrieveContainer(errContext, congruent, canonLoc, cv,
                                   stmtIndex);
    } else if (cv.op().isStoreContainer(true)) {
      addInferredStoreContainer(errContext, congruent, canonLoc, cv,
          stmtIndex);
    }
  }

  private void addInferredFilenameAlias(String errContext,
          CongruentSets congruent, Arg canonLoc, ArgCV cv, int stmtIndex)
                  throws OptUnsafeError {
    Var file = cv.getInput(0).getVar();
    // Retrieving alias == filename
    equateValues(errContext, congruent, stmtIndex,
            ComputedValue.filenameValCV(file),
            ComputedValue.retrieveCompVal(canonLoc.getVar(), false));
  }

  private void addInferredLoadFile(String errContext, CongruentSets congruent,
          Arg canonLoc, ArgCV cv, int stmtIndex) throws OptUnsafeError {
    Var file = cv.getInput(0).getVar();
    equateValues(errContext, congruent, stmtIndex,
            ComputedValue.filenameValCV(file),
            ComputedValue.localFilenameCV(canonLoc.getVar()));
  }

  private void addInferredStoreFile(String errContext, CongruentSets congruent,
          Arg canonLoc, ArgCV cv, int stmtIndex) throws OptUnsafeError {
    Var localFile = cv.getInput(0).getVar();
    Arg setFilename = cv.getInput(1);
    if (setFilename.isBool() && setFilename.getBool()) {
      // Only if the filename was definitely set by store
      ArgCV srcFilename = ComputedValue.localFilenameCV(localFile);
      ArgCV dstFilename = ComputedValue.filenameValCV(canonLoc.getVar());
      equateValues(errContext, congruent, stmtIndex,
                          srcFilename, dstFilename);
    }
  }

  private void addInferredRetrieveContainer(String errContext,
      CongruentSets congruent, Arg canonLoc, ArgCV cv, int stmtIndex)
          throws OptUnsafeError {
    // TODO: also transfer across element info, etc
    Var src = cv.getInput(0).getVar();
    equateValues(errContext, congruent, stmtIndex,
            ComputedValue.containerSizeCV(src, false),
            ComputedValue.containerSizeCV(canonLoc.getVar(), false));
  }

  private void addInferredStoreContainer(String errContext,
      CongruentSets congruent, Arg canonLoc, ArgCV cv, int stmtIndex)
          throws OptUnsafeError {
    // TODO: also transfer across element info, etc
    Var src = cv.getInput(0).getVar();
    equateValues(errContext, congruent, stmtIndex,
            ComputedValue.containerSizeCV(src, false),
            ComputedValue.containerSizeCV(canonLoc.getVar(), false));
  }

  /**
   * Implement set interface for checking if var is closed
   */
  private class ClosedSet extends AbstractSet<Var> {
    ClosedSet(int stmtIndex, boolean recursive) {
      this.stmtIndex = stmtIndex;
      this.recursive = recursive;
    }

    private final int stmtIndex;
    private final boolean recursive;

    @Override
    public boolean contains(Object o) {
      assert(o instanceof Var);
      Var v = (Var)o;
      if (recursive) {
        return isRecClosed(v, stmtIndex);
      } else {
        return isClosed(v, stmtIndex);
      }
    }

    @Override
    public Iterator<Var> iterator() {
      throw new STCRuntimeError("iterator() not supported");
    }

    @Override
    public int size() {
      throw new STCRuntimeError("size() not supported");
    }
  }

  /**
   * Implement set interface for checking if abstract location is closed
   */
  private class ClosedCVSet extends AbstractSet<ArgCV> {
    ClosedCVSet(int stmtIndex, boolean recursive) {
      this.stmtIndex = stmtIndex;
      this.recursive = recursive;
    }

    private final int stmtIndex;
    private final boolean recursive;

    @Override
    public boolean contains(Object o) {
      assert(o instanceof ArgCV);
      ArgCV v = (ArgCV)o;
      if (recursive) {
        return isRecClosed(v, stmtIndex);
      } else {
        return isClosed(v, stmtIndex);
      }
    }

    @Override
    public Iterator<ArgCV> iterator() {
      throw new STCRuntimeError("iterator() not supported");
    }

    @Override
    public int size() {
      throw new STCRuntimeError("size() not supported");
    }
  }

  private class RetrieveAvailSet extends AbstractSet<Var> {
    private RetrieveAvailSet() {
    }

    @Override
    public boolean contains(Object o) {
      assert(o instanceof Var);
      Var v = (Var)o;
      return findRetrieveResult(v, false) != null;
    }

    @Override
    public Iterator<Var> iterator() {
      throw new STCRuntimeError("iterator() not supported");
    }

    @Override
    public int size() {
      throw new STCRuntimeError("size() not supported");
    }
  }

  static class OptUnsafeError extends Exception {

    private static final long serialVersionUID = 1L;

    /**
     * Don't have message: should log problem before throwing exception
     */
    OptUnsafeError() {
      super();
    }

  }

}