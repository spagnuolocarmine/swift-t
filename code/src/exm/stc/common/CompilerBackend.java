/*
 * Copyright 2013 University of Chicago and Argonne National Laboratory
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License
 */
package exm.stc.common;

import java.util.Collections;
import java.util.List;

import exm.stc.common.exceptions.UndefinedTypeException;
import exm.stc.common.exceptions.UserException;
import exm.stc.common.lang.Arg;
import exm.stc.common.lang.Operators;
import exm.stc.common.lang.Operators.BuiltinOpcode;
import exm.stc.common.lang.PassedVar;
import exm.stc.common.lang.Redirects;
import exm.stc.common.lang.TaskMode;
import exm.stc.common.lang.RefCounting.RefCountType;
import exm.stc.common.lang.Types.FunctionType;
import exm.stc.common.lang.Var;

public interface CompilerBackend {

  public void header();

  public void turbineStartup();

  public void requirePackage(String pkg, String version);
  
  /**
   * @param var variable object
   * @throws UndefinedTypeException
   */
  public void declare(Var var,
      Arg initReaders, Arg initWriters) throws UndefinedTypeException;

  public void decrRef(Var var, Arg amount);

  public void incrRef(Var var, Arg amount);
  
  public void decrWriters(Var var, Arg amount);

  public void incrWriters(Var var, Arg amount);


  public void localOp(BuiltinOpcode op, Var out, 
                                            List<Arg> in);
  
  public void asyncOp(BuiltinOpcode op, Var out, 
                               List<Arg> in, Arg priority);  
  
  /**
   * Set target=addressof(src)
   */
  public void assignReference(Var target, Var src);

  public void dereferenceInt(Var target, Var src);
  
  public void dereferenceBool(Var target, Var src);

  public void dereferenceFloat(Var dst, Var src);
  
  public void dereferenceBlob(Var dst, Var src);
  
  public void dereferenceFile(Var dst, Var src);

  public void retrieveRef(Var target, Var src, Arg decr);
  
  /**
   * Copy the handle to a future, creating an alias
   * @param dst
   * @param src
   */
  public void makeAlias(Var dst, Var src);

  public void dereferenceString (Var target, Var src);

  /**assignInt, which can take a value variable or a literal int in oparg
   */
  public void assignInt(Var target, Arg src);
  public void retrieveInt(Var target, Var source, Arg decr);

  public void assignVoid(Var target, Arg src);
  /**
   * Used to represent dataflow dependency.  Sets target to
   * arbitrary value
   * @param target
   * @param source
   */
  public void retrieveVoid(Var target, Var source, Arg decr);
  
  public void assignFloat(Var target, Arg src);
  public void retrieveFloat(Var target, Var source, Arg decr);

  /** assignString, which can take a value variable or a literal int in oparg
   */
  public void assignString(Var target, Arg src);

  public void retrieveString(Var target, Var source, Arg decr);
  
  public void assignBool(Var target, Arg src);
  public void retrieveBool(Var target, Var source, Arg decr);

  public void assignBlob(Var target, Arg src);
  public void retrieveBlob(Var target, Var src, Arg decr);
  
  /**
   * Set file object.  Increment local file ref count
   * @param target
   * @param src dummy local variable
   */
  public void assignFile(Var target, Arg src);

  public void retrieveFile(Var target, Var src, Arg decr);
  

  /**
   * Used to cleanup local file if needed
   * @param fileVal
   */
  public void decrLocalFileRef(Var fileVal);
  
  /**
   * Decrement reference count for cached blob
   * @param blob handle to future
   */
  public void decrBlobRef(Var blob);
  

  /**
   * Free local blob value
   * @param blobval
   */
  public void freeBlob(Var blobval);
  
  /**
   * Extract handle to filename future out of file variable
   * @param initUnmapped if true, assign arbitrary filename to unmapped files
   */
  public void getFileName(Var filename, Var file, boolean initUnmapped);
  
  /**
   * Choose a temporary file name
   * @param filenameVal
   */
  public void chooseTmpFilename(Var filenameVal);
  
  /**
   * Set filename of file future to a local string value
   * @param file file future
   * @param filenameVal a local string value
   */
  public void setFilenameVal(Var file, Arg filenameVal);

  /**
   * NOTE: all built-ins should be defined before other functions
   * @param function
   * @param inputs
   * @param outputs
   * @param priority 
   */
  public void builtinFunctionCall(String function,
      List<Var> inputs, List<Var> outputs, Arg priority);

  public void functionCall(String function,
      List<Var> inputs, List<Var> outputs, List<Boolean> blockOn, 
      TaskMode mode, Arg priority);

  public void builtinLocalFunctionCall(String functionName,
          List<Arg> inputs, List<Var> outputs);
  
  /**
   * Generate command to run an external application immediately
   * @param redirects 
   */
  public void runExternal(String cmd, List<Arg> args,
           List<Arg> inFiles, List<Var> outFiles, List<Arg> outFileNames, 
           Redirects<Arg> redirects,
           boolean hasSideEffects, boolean deterministic);
  
  /**
   * lookup structVarName.structField and copy to oVarName
   * @param result
   * @param structVar
   * @param structField
   */
  public void structLookup(Var result, Var structVar,
      String structField);
  
  public void structRefLookup(Var result, Var structVar,
      String fieldName);

  public void structClose(Var struct);

  public void structInsert(Var structVar, String fieldName,
                                          Var fieldContents);

  public void arrayLookupFuture(Var oVar, Var arrayVar,
      Var indexVar, boolean isArrayRef);

  public void arrayLookupRefImm(Var oVar, Var arrayVar,
      Arg arrayIndex, boolean isArrayRef);
  
  /**
   * Direct lookup of array without any blocking at all.  This is only
   * safe to use if we know the array is closed, or if we know that the
   * item at this index is already there
   * @param oVar
   * @param arrayVar
   * @param arrayIndex
   */
  public void arrayLookupImm(Var oVar, Var arrayVar,
      Arg arrayIndex);

  public void arrayInsertFuture(Var array,
      Var ix, Var member, Arg writersDecr);
  
  public void arrayRefInsertFuture(Var outerArray,
      Var array, Var ix, Var member);

  /**
   * Build array with indices [0..members.size() - 1] comprised of the
   * variables from members 
   * @param array
   * @param members
   */
  public void arrayBuild(Var array, List<Var> members);
  
  public void arrayInsertImm(Var array, Arg ix, Var member,
      Arg writersDecr);
  
  public void arrayRefInsertImm(Var outerArray, 
      Var array, Arg ix, Var member);

  public void arrayCreateNestedFuture(Var arrayResult,
      Var array, Var ix);

  public void arrayCreateNestedImm(Var arrayResult,
      Var array, Arg ix);

  public void arrayRefCreateNestedFuture(Var arrayResult,
      Var outerArray, Var array, Var ix);

  public void arrayRefCreateNestedImm(Var arrayResult,
      Var outerArray, Var array, Arg ix);

  public void initUpdateable(Var updateable, Arg val);
  public void latestValue(Var result, Var updateable);
  
  public void update(Var updateable, Operators.UpdateMode updateMode,
                              Var val);
  /** Same as above, but takes a value or constant as arg */
  public void updateImm(Var updateable, Operators.UpdateMode updateMode,
      Arg val);
  
  /**
   * @param name
   * @param type
   * @param impl tcl function implementing this.  Must be provided
   * @throws UserException
   */
  public void defineBuiltinFunction(String name,
                FunctionType type, TclFunRef impl) throws UserException;
  
  /**
   * 
   * @param functionName
   * @param oList
   * @param iList
   * @param mode the context the function will run in (e.g. SYNC if
   *        called synchronously).  This is needed for optimizer correctness.
   * @throws UserException
   */
  public void startFunction(String functionName,
      List<Var> oList, List<Var> iList, TaskMode mode)
            throws UserException;

  public void endFunction();

  public void startNestedBlock();

  public void endNestedBlock();

  public void addComment(String comment);

  /**
   * @param condition the variable name to branch based on (int or bool value type)
   * @param hasElse whether there will be an else clause ie. whether startElseBlock()
   *                will be called later for this if statement
   */
  public void startIfStatement(Arg condition, boolean hasElse);

  public void startElseBlock();

  public void endIfStatement();

  /**
   * 
   * @param switchVar must be integer value type
   * @param caseLabels
   * @param hasDefault
   */
  public void startSwitch(Arg switchVar,
      List<Integer> caseLabels, boolean hasDefault);

  public void endCase();

  public void endSwitch();

  
  /**
   * Represents a refcount operation
   */
  public static class RefCount {
    public final Var var;
    public final RefCountType type;
    public final Arg amount;
    
    public RefCount(Var var, RefCountType type, Arg amount) {
      super();
      this.var = var;
      this.type = type;
      this.amount = amount;
    }
    
    @Override
    public String toString() {
      return var.name() + "<" + type.toString() + ">" + amount;
    }
    
    public static final List<RefCount> NONE = Collections.emptyList();
  }

  /**
   * 
   * @param loopName unique name for loop
   * @param arrayVar
   * @param memberVar
   * @param loopCountVar counter variable, can be null
   * @param splitDegree
   * @param leafDegree 
   * @param arrayClosed if true, assume array is already closed
   * @param passedVars
   * @param keepOpenVars
   */
  public void startForeachLoop(String loopName,
      Var arrayVar, Var memberVar, Var loopCountVar, int splitDegree,
      int leafDegree, boolean arrayClosed,
      List<PassedVar> passedVars, List<RefCount> perIterIncrs);

  public void endForeachLoop(int splitDegree,
            boolean arrayClosed, List<RefCount> perIterDecrements);

  /**
   * A loop over a prespecified range.  The range can be totally fixed
   *   ( the bounds might be literal integers) or can vary at runtime (
   *   ( in which case it is specified by integer value variables )
   *   The loop construct should run immediately, but have the loop iterations
   *   run in parallel
   * @param loopName unique name for loop
   * @param loopVar variable (integer value) used to store iteration parameter
   * @param countVar variable (integer value) used to store iteration number starting
   *                from 0 (optional) 
   * @param start start (inclusive) of the loop: should be int or int value var
   * @param end end (inclusive) of the loop: should be int or int value var
   * @param increment increment of the loop: should be int or int value var
   * @param passedVars variables used in loop body
   * @param perIterIncrs variable reference operations
   * @param desiredUnroll the suggested unrolling factor
   * @param splitDegree the desired loop split factor (negative if no splitting)
   */
  public void startRangeLoop(String loopName, Var loopVar, Var countVar,
      Arg start, Arg end, Arg increment, int splitDegree, int leafDegree, 
      List<PassedVar> passedVars, List<RefCount> perIterIncrs);
  public void endRangeLoop(int splitDegree, List<RefCount> perIterDecrs);
  /**
   * Add a global variable (currently constant literals are supported)
   * @param name
   * @param val
   */
  public void addGlobal(String name, Arg val);
   
  /**
     Generate and return Tcl from our internal TclTree
   */
  public String code();
  
  /**
   * Different kinds of wait statements that can be optimized in
   * different ways
   */
  public static enum WaitMode {
    DATA_ONLY, /* Used to allow data load inside wait */
    EXPLICIT, /* Explicit synchronisation on variable, 
           can only eliminate if var closed */
    TASK_DISPATCH; /* Used to dispatch async task to 
    load balancer/other node */
  }
  
  /**
   * Start code that will execute asynchronously
   * @param procName the name of the wait block (useful so generated
   *    tcl code can have a nice name for the block)
   * @param waitVars
   * @param usedVars any variables which are read or written inside block
   * @param keepOpenVars any vars that need to be kept open for wait
   * @param mode what guarantees wait statement should provide
   * @param recursive if true, wait until all contents of arrays/structs
   *                   (recursively) are closed
   * @param target controls where asynchronous execution occurs
   */
  public void startWaitStatement(String procName,
      List<Var> waitVars,
      List<Var> usedVars, Arg priority,
      WaitMode mode, boolean recursive, TaskMode target);

  public void endWaitStatement();

  
  /**
   * 
   * @param loopName
   * @param loopVars first one is loop condition
   * @param initVals initial values for loop variables
   * @param usedVariables
   * @param keepOpenVars
   * @param blockingVars
   */
  public void startLoop(String loopName, List<Var> loopVars,
      List<Boolean> definedHere, List<Var> initVals, List<Var> usedVariables,
      List<Var> keepOpenVars, List<Boolean> blockingVars);
  
  public void loopContinue(List<Var> newVals,
      List<Var> usedVariables,
      List<Boolean> blockingVars);
  /**
   * @param loopUsedVars variables from outside loop referred to in loop.
   *              references decremented at loop break
   * @param keepOpenVars
   */
  public void loopBreak(List<Var> loopUsedVars, List<Var> keepOpenVars);
  public void endLoop();
}