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
package exm.stc.frontend;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import exm.stc.ast.SwiftAST;
import exm.stc.ast.antlr.ExMParser;
import exm.stc.common.Logging;
import exm.stc.common.exceptions.DoubleDefineException;
import exm.stc.common.exceptions.InvalidSyntaxException;
import exm.stc.common.exceptions.STCRuntimeError;
import exm.stc.common.exceptions.TypeMismatchException;
import exm.stc.common.exceptions.UndefinedTypeException;
import exm.stc.common.exceptions.UserException;
import exm.stc.common.lang.Arg;
import exm.stc.common.lang.ExecTarget;
import exm.stc.common.lang.FnID;
import exm.stc.common.lang.ForeignFunctions.SpecialFunction;
import exm.stc.common.lang.Operators.BuiltinOpcode;
import exm.stc.common.lang.Operators.Op;
import exm.stc.common.lang.Operators.OpInputType;
import exm.stc.common.lang.Types;
import exm.stc.common.lang.Types.RefType;
import exm.stc.common.lang.Types.ScalarUpdateableType;
import exm.stc.common.lang.Types.StructType;
import exm.stc.common.lang.Types.StructType.StructField;
import exm.stc.common.lang.Types.TupleType;
import exm.stc.common.lang.Types.Type;
import exm.stc.common.lang.Types.UnionType;
import exm.stc.common.lang.Var;
import exm.stc.common.lang.Var.Alloc;
import exm.stc.common.lang.WaitMode;
import exm.stc.common.util.Pair;
import exm.stc.common.util.StackLite;
import exm.stc.common.util.TernaryLogic.Ternary;
import exm.stc.frontend.VariableUsageInfo.VInfo;
import exm.stc.frontend.tree.ArrayElems;
import exm.stc.frontend.tree.ArrayRange;
import exm.stc.frontend.tree.Literals;
import exm.stc.frontend.typecheck.OpTypeChecker;
import exm.stc.frontend.typecheck.OpTypeChecker.MatchedOp;
import exm.stc.frontend.typecheck.TypeChecker;
import exm.stc.ic.STCMiddleEnd;

/**
 * This module contains logic to walk individual expression in Swift and generate code to evaluate them
 */
public class ExprWalker {

  private final FunctionCallEvaluator fnCall;
  private final VarCreator varCreator;
  private final STCMiddleEnd backend;
  private final LoadedModules modules;

  public ExprWalker(WrapperGen wrappers, VarCreator creator,
                    STCMiddleEnd backend, LoadedModules modules) {
    this.fnCall = new FunctionCallEvaluator(creator, wrappers, this, backend);
    this.varCreator = creator;
    this.backend = backend;
    this.modules = modules;
  }

  /**
   * Evaluate expression into provided output variables
   *
   * @param oList
   *          : the list of variables that the result of the expression should
   *          be assigned to. Multiple variables are only valid if the
   *          expression is a function call
   * @param renames
   *          if not null, replace references to variables in map
   */
  public void evalToVars(Context context, SwiftAST tree, List<Var> oList,
          Map<String, String> renames) throws UserException {
    LogHelper.debug(context, "walkExpr " + tree.getText() +
          " assigning to vars: " + oList);
    int token = tree.getType();
    syncFilePos(context, tree);

    if (token == ExMParser.CALL_FUNCTION) {
      fnCall.evalFunctionCall(context, tree, oList, renames);
      return;
    } else if (token == ExMParser.TUPLE) {
      tupleExpression(context, tree, oList, renames);
      return;
    }

    assert(oList.size() == 1): "Cannot assign expression type " +
            LogHelper.tokName(token) + " to multiple variables";

    Var oVar = oList.get(0);
    assert(oVar.type().isConcrete()) : oVar.type();

    switch (token) {
      case ExMParser.VARIABLE:
        String srcVarName = tree.child(0).getText();
        if (renames != null &&
            renames.containsKey(srcVarName)) {
          srcVarName = renames.get(srcVarName);
        }

        Var srcVar = context.lookupVarUser(srcVarName);

        if (oVar.name().equals(srcVar.name())) {
          throw new UserException(context, "Assigning variable " +
                oVar.name() + " to itself");

        }
        assignVariable(context, oVar, srcVar);
        break;

      case ExMParser.INT_LITERAL:
        assignIntLit(context, oVar, Literals.extractIntLit(context, tree));
        break;

      case ExMParser.FLOAT_LITERAL:
        assignFloatLit(context, tree, oVar);
        break;

      case ExMParser.STRING_LITERAL:
        assignStringLit(context, tree, oVar);
        break;

      case ExMParser.BOOL_LITERAL:
        assignBoolLit(context, tree, oVar);
        break;

      case ExMParser.OPERATOR:
        // Handle unary negation as special case
        Long intLit = Literals.extractIntLit(context, tree);
        Double floatLit = Literals.extractFloatLit(context, tree);
        if (intLit != null) {
          assignIntLit(context, oVar, intLit);
        } else if (floatLit != null ) {
          assignFloatLit(context, tree, oVar);
        } else {
          if (oList.size() != 1) {
            throw new STCRuntimeError("Operator had " +
                oList.size() + " outputs, doesn't make sense");
          }
          callOperator(context, tree, oList.get(0), renames);
        }
        break;

      case ExMParser.ARRAY_LOAD:
        arrayLoad(context, tree, oVar, renames);
        break;

      case ExMParser.STRUCT_LOAD:
        structLoad(context, tree, oVar.type(), false, oVar, renames);
        break;

      case ExMParser.ARRAY_RANGE:
        arrayRange(context, tree, oVar, renames);
        break;
      case ExMParser.ARRAY_ELEMS:
      case ExMParser.ARRAY_KV_ELEMS:
        arrayElems(context, tree, oVar, renames);
        break;
      default:
        throw new STCRuntimeError
        ("Unexpected token type in expression context: "
            + LogHelper.tokName(token));
    }
  }

  /**
   * Evaluates expression, creating temporary output variable if needed
   *
   * @param type expected result type of expression
   * @return return the name of a newly created tmp variable
   * @throws UserException
   */
  public Var eval(Context context, SwiftAST tree, Type type,
      boolean storeInStack, Map<String, String> renames) throws UserException {
    assert(type != null);
    syncFilePos(context, tree);
    if (tree.getType() == ExMParser.VARIABLE) {
      // Base case: don't need to create new variable
      String varName = tree.child(0).getText();
      if (renames != null && renames.containsKey(varName)) {
        varName = renames.get(varName);
      }
      Var var = context.lookupVarUser(varName);
      // Check to see that the current variable's storage is adequate
      // Might need to convert type, can't do that here
      if ((var.storage() == Alloc.STACK || (!storeInStack))
              && var.type().equals(type)) {
        return var;
      }
    }

    if (tree.getType() == ExMParser.STRUCT_LOAD && Types.isStruct(
                TypeChecker.findExprType(context, tree.child(0)))) {
      return structLoad(context, tree, type, storeInStack, null, renames);
    } else {
      Var tmp = varCreator.createTmp(context, type, storeInStack, false);
      LogHelper.debug(context, "Create tmp " + tmp + " to eval expr " +
                      LogHelper.tokName(tree.getType()));
      evalToVars(context, tree, tmp.asList(), renames);
      return tmp;
    }
  }

  /**
   * Evaluate 1..n expressions to temporary variables.
   * In 1 cases, expression directly evaluated.
   * In 2+ cases, assumed to be tuple.
   * @param context
   * @param tree
   * @param abstractType expression type, may be tuple type
   * @param storeInStack
   * @param renames
   * @return
   * @throws UserException
   */
  public List<Var> evalMulti(Context context, SwiftAST tree, List<Type> types,
      boolean storeInStack, Map<String, String> renames) throws UserException {
    int n = types.size();
    assert(n >= 1);

    if (n == 1) {
      return eval(context, tree, types.get(0), storeInStack, renames).asList();
    }

    List<Var> results = new ArrayList<Var>(n);
    assert(tree.getType() == ExMParser.TUPLE);
    assert(n == tree.childCount());
    for (int i = 0; i < n; i++) {
      results.add(eval(context, tree.child(i), types.get(i), storeInStack, renames));
    }

    return results;
  }

  /**
   * Do a by-value copy from src to dst
   *
   * @param context
   * @param dst
   * @param src
   * @param abstractType
   * @throws UserException
   */
  public void copyByValue(Context context, Var dst, Var src)
                           throws UserException {
    copyByValue(context, dst, src, true);
  }


  public void copyByValue(Context context, Var dst, Var src, boolean strictTypes)
        throws UserException {
    if (strictTypes) {
      assert(src.type().assignableTo(dst.type()));
    } else {
      assert(src.type().getImplType().assignableTo(
          dst.type().getImplType()));
    }

    if (Types.simpleCopySupported(src)) {
       backendAsyncCopy(context, dst, src, strictTypes);
    } else if (Types.isFile(src)) {
      copyFileByValue(dst, src);
    } else {
      throw new STCRuntimeError(context.getFileLine() +
          " copying type " + src + " by value not yet "
          + " supported by compiler");
    }
  }

  /**
   *
   * @param context
   * @param structVar Variable of type struct or struct ref
   * @param fieldName Path from struct to lookup
   * @param storeInStack
   * @return the contents of the struct field if structVar is a non-ref,
   *        a reference to the contents of the struct field if structVar is
   *        a ref
   * @throws UserException
   * @throws UndefinedTypeException
   */
  public Var structLookup(Context context, Var struct,
      List<String> fieldPath, boolean storeInStack, Var outVar)
          throws UserException,
      UndefinedTypeException {
    assert(struct != null);
    assert(fieldPath != null);
    assert(fieldPath.size() > 0);
    Type fieldType = TypeChecker.findStructFieldType(context, fieldPath,
                                                   struct.type());
    boolean storedAsRef = VarRepr.storeRefInStruct(fieldType);

    Var result;
    Var backendStruct = VarRepr.backendVar(struct);

    Type resultType = TypeChecker.structLoadResultType(struct.type(), fieldType);

    if (Types.isStructRef(struct)) {
      if (outVar == null || !resultType.assignableTo(outVar.type())) {
        result = varCreator.createStructFieldTmp(context,
            struct, resultType, fieldPath, Alloc.TEMP);
      } else {
        result = outVar;
      }
      backend.structRefCopyOut(VarRepr.backendVar(result),
                               backendStruct, fieldPath);
    } else {
      assert(Types.isStruct(struct));
      if (storedAsRef)  {
        // Copy out reference once it's set (field maybe not initialized)
        result = varCreator.createStructFieldTmp(context, struct, resultType,
                                                 fieldPath, Alloc.TEMP);

        backend.structCopyOut(VarRepr.backendVar(result), backendStruct,
                              fieldPath);
      } else if (!storedAsRef && outVar == null) {
        // Just create alias to data in struct for later use
        result = structCreateAlias(context, struct, fieldPath);
      } else {
        assert(!storedAsRef && outVar != null);
        // Copy data in struct to existing output variable
        backend.structCopyOut(VarRepr.backendVar(outVar),
                              backendStruct, fieldPath);
        result = outVar;
      }
    }

    // If necessary, copy result to outVar
    if (result == outVar) {
      return outVar;
    } else {
      return derefOrCopyResult(context, result, outVar);
    }
  }

  public Var structLookup(Context context, Var struct,
      List<String> fieldPath, boolean storeInStack)
          throws UserException, UndefinedTypeException {
    return structLookup(context, struct, fieldPath, storeInStack, null);
  }

  /**
   * Dereference src into dst
   * ie. dst = *src
   * @param dst
   * @param src
   * @throws UserException
   * @throws UndefinedTypeException
   */
  public void dereference(Context context, Var dst, Var src)
      throws UndefinedTypeException, UserException {
    assert(Types.isRef(src));
    assert(Types.isAssignableRefTo(src, dst));

    Var backendDst = VarRepr.backendVar(dst);
    Var backendSrc = VarRepr.backendVar(src);

    Type dstType = dst.type();
    if (Types.isScalarFuture(dstType)) {
      backend.derefScalar(backendDst, backendSrc);
    } else if (Types.isFile(dstType)) {
      backend.derefFile(backendDst, backendSrc);
    } else if (Types.isContainer(dstType)) {
      derefThenCopyContainer(context, dst, src);
    } else if (Types.isStruct(dstType)) {
      dereferenceStruct(context, dst, src);
    } else {
      throw new STCRuntimeError("Can't dereference type " + src.type());
    }
  }

  public void assign(Var dst, Arg src) {
    assert(src.type().assignableTo(Types.retrievedType(dst))) :
                      dst + " = " + src;
    Var backendDst = VarRepr.backendVar(dst);
    Arg backendSrc = VarRepr.backendArg(src);
    if (Types.isScalarFuture(dst)) {
      backend.assignScalar(backendDst, backendSrc);
    } else if (Types.isArray(dst)) {
      backend.assignArray(backendDst, backendSrc);
    } else if (Types.isBag(dst)) {
      backend.assignBag(backendDst, backendSrc);
    } else if (Types.isStruct(dst)) {
      backend.assignStruct(backendDst, backendSrc);
    } else if (Types.isFile(dst)) {
      // TODO: is it right to always assign filename here?
      assignFile(dst, src, Arg.TRUE);
    } else {
      throw new STCRuntimeError("Can't assign: " + dst);
    }
  }

  public void assignFile(Var dst, Arg src, Arg setFilename) {
    Var backendDst = VarRepr.backendVar(dst);
    Arg backendSrc = VarRepr.backendArg(src);
    Arg backendSetFileName = VarRepr.backendArg(setFilename);
    backend.assignFile(backendDst, backendSrc, backendSetFileName);
  }

  public void retrieve(Var dst, Var src) {
    Var backendDst = VarRepr.backendVar(dst);
    Var backendSrc = VarRepr.backendVar(src);
    if (Types.isScalarFuture(src)) {
      backend.retrieveScalar(backendDst, backendSrc);
    } else if (Types.isFile(src)) {
      backend.retrieveFile(backendDst, backendSrc);
    } else if (Types.isArray(src)) {
      // TODO: recursively?
      backend.retrieveArray(backendDst, backendSrc);
    } else if (Types.isBag(src)) {
      // TODO: recursively?
      backend.retrieveBag(backendDst, backendSrc);
    } else if (Types.isStruct(src)) {
      // TODO: recursively?
      backend.retrieveStruct(backendDst, backendSrc);
    } else {
      throw new STCRuntimeError("Don't know how to fetch " + src);
    }
  }

  /**
   * Create a value variable and retrieve value of future into it
   * @param context
   * @param future
   * @return
   * @throws UserException
   * @throws UndefinedTypeException
   * @throws DoubleDefineException
   */
  public Var retrieveToVar(Context context, Var future)
      throws UserException, UndefinedTypeException, DoubleDefineException {
    Var val = varCreator.createValueOfVar(context, future);
    retrieve(val, future);
    return val;
  }

  public Var retrieveContainerValues(Context context, Var c)
          throws UserException {
    assert(Types.isContainer(c));
    Type unpackedT = Types.unpackedType(c);
    Var val = varCreator.createValueVar(context, unpackedT, c, true);
    backend.retrieveRecursive(VarRepr.backendVar(val), VarRepr.backendVar(c));
    // TODO: recursively free e.g. blobs in list
    return val;
  }

  public void retrieveRef(Var dst, Var src, boolean mutable) {
    backend.retrieveRef(VarRepr.backendVar(dst), VarRepr.backendVar(src),
                        mutable);
  }

  public void assignRef(Var dst, Var src, boolean mutable) {
    // Only assign single refcounts
    long readRefs = 1;
    long writeRefs = mutable ? 1 : 0;
    backend.assignRef(VarRepr.backendVar(dst), VarRepr.backendVar(src),
                      readRefs, writeRefs);
  }

  /**
   * Create a future of the appropriate type for the argument
   * @param bodyContext
   * @param value
   * @param mutableRef if storing to a ref, does it need to be mutable
   * @return
   * @throws UserException
   * @throws UndefinedTypeException
   */
  public Var assignToVar(Context bodyContext, Arg value, boolean mutableRef)
      throws UserException, UndefinedTypeException {
    assert(value.isConst() || value.getVar().storage() == Alloc.LOCAL);
    Type resultType = Types.storeResultType(value, mutableRef);
    Var result = varCreator.createTmp(bodyContext, resultType);
    assign(result, value);
    return result;
  }

  /**
   * emit intermediate code for an async op
   * @param op
   * @param out
   * @param inputs
   */
  public void asyncOp(BuiltinOpcode op, Var out, List<Arg> inputs) {
    backend.asyncOp(op, VarRepr.backendVar(out), VarRepr.backendArgs(inputs));
  }

  public void localOp(BuiltinOpcode op, Var out, List<Arg> inputs) {
    backend.localOp(op, VarRepr.backendVar(out), VarRepr.backendArgs(inputs));
  }

  public Arg valueOfConstExpr(Context context, Type expectedType, SwiftAST val,
      String targetVarName) throws UserException, TypeMismatchException,
      InvalidSyntaxException {
    Type valType = TypeChecker.findExprType(context, val);
    if (!valType.assignableTo(expectedType)) {
      throw new TypeMismatchException(context, "cannot assign expression"
          + " of type " + valType.typeName() + " to "
          + targetVarName + " which has type " + expectedType);
    }

    String msg = "Don't support non-literal expressions for constants";

    switch (expectedType.primType()) {
    case BOOL:
      String bval = Literals.extractBoolLit(context, val);
      if (bval == null) {
        throw new UserException(context, msg);
      }
      return Arg.newBool(Boolean.parseBoolean(bval));
    case INT:
      Long ival = Literals.extractIntLit(context, val);
      if (ival == null) {
        throw new UserException(context, msg);
      }
      return Arg.newInt(ival);
    case FLOAT:
      Double fval = Literals.extractFloatLit(context, val);
      if (fval == null) {
        Long sfval = Literals.extractIntLit(context, val);
        if (sfval == null) {
          throw new UserException(context, msg);
        } else {
          fval = Literals.interpretIntAsFloat(context, sfval);
        }
      }
      assert(fval != null);
      return Arg.newFloat(fval);
    case STRING:
      String sval = Literals.extractStringLit(context, val);
      if (sval == null) {
        throw new UserException(context, msg);
      }
      return Arg.newString(sval);
    default:
      throw new STCRuntimeError("Unexpect value tree type in "
          + " global constant: " + LogHelper.tokName(val.getType()));
    }
  }

  /**
   * Synchronize file position to line mapping
   * @param context
   * @param tree
   */
  private void syncFilePos(Context context, SwiftAST tree) {
    context.syncFilePos(tree, modules.currentModule().moduleName(),
                        modules.currLineMap());
  }

  private void callOperator(Context context, SwiftAST tree,
      Var out, Map<String, String> renames) throws UserException {
    String opName = tree.child(0).getText();
    int op_argcount = tree.getChildCount() - 1;

    // Use the AST token label to find the actual operator
    MatchedOp opMatch = OpTypeChecker.getOpFromTree(context, tree, out.type());
    Op op = opMatch.op;
    List<Type> exprTypes = opMatch.exprTypes;

    List<OpInputType> inArgs = op.type.in();
    int argcount = inArgs.size();

    if (op_argcount != argcount) {
      throw new STCRuntimeError("Operator " + opName + " has " + op_argcount
                             + " arguments in AST, but expected" + argcount);
    }

    ArrayList<Arg> iList = new ArrayList<Arg>(argcount);
    for (int i = 0; i < op_argcount; i++) {
      OpInputType inArg = inArgs.get(i);
      Type exprType = exprTypes.get(i);
      if (inArg.variadic) {
        // Flatten out variadic args list
        List<Var> args =  evalMulti(context, tree.child(i + 1),
                 TupleType.getFields(exprType), false, renames);
        for (Var arg: args) {
          iList.add(Arg.newVar(arg));
        }
      } else {
        // Store into temporary variables
        Var arg = eval(context, tree.child(i + 1), exprType, false, renames);
        iList.add(Arg.newVar(arg));
      }
    }
    asyncOp(op.code, out, iList);
  }


  /**
   * Evaluate a tuple expression.
   * @param context
   * @param tree
   * @param oList
   * @param renames
   * @throws UserException
   */
  private void tupleExpression(Context context, SwiftAST tree,
      List<Var> oList, Map<String, String> renames) throws UserException {
    assert(tree.getType() == ExMParser.TUPLE);
    int n = tree.childCount();
    assert(n == oList.size()) : "Assignment count mismatch not caught in type checking";

    for (int i = 0; i < n; i++) {
      evalToVars(context, tree.child(i), oList.get(i).asList(), renames);
    }
  }

  /**
   * Handle an expression which is an array access. Copies a member of an array,
   * specified by index, into another variable. If the other variable is an
   * alias variable, we can avoid the copy.
   *
   * @param context
   * @param tree
   * @param oVar
   *          the variable to copy into
   * @throws UserException
   */
  private void arrayLoad(Context context, SwiftAST tree, Var oVar,
        Map<String, String> renames)
      throws UserException {
    if (tree.getChildCount() != 2) {
      throw new STCRuntimeError("array_load subtree should have "
          + " only two children, but has " + tree.getChildCount());
    }

    // Work out the type of the array so we know the type of the temp var
    SwiftAST arrayTree = tree.child(0);
    Type arrExprType = TypeChecker.findExprType(context, arrayTree);
    Type arrType = chooseArrayTypeForLookup(oVar, arrExprType);

    // Evaluate the array
    Var arrayVar = eval(context, arrayTree, arrType, false, renames);

    // Any integer expression can index into array
    SwiftAST arrayIndexTree = tree.child(1);
    Type indexType = TypeChecker.findExprType(context, arrayIndexTree);
    if (!Types.isArrayKeyFuture(arrayVar, indexType)) {
      throw new TypeMismatchException(context,
            "array index expression does not have appropriate key type "
          + "for key of array type " + arrayVar.type() + ".  Type of index "
          + "expression was " + indexType.typeName());
    }

    Var backendArray = VarRepr.backendVar(arrayVar);
    Type backendElemType =
        TypeChecker.containerElemType(backendArray, false);

    Var backendOVar = VarRepr.backendVar(oVar);

    // The direct output of the array op
    Var copyDst;
    boolean mustDereference;
    if (backendElemType.assignableTo(backendOVar.type())) {
      // Want to copy out
      copyDst = oVar;
      mustDereference = false;
    } else {
      assert(Types.isRefTo(backendElemType, backendOVar)) :
            backendElemType + " => " + backendOVar;
      // Need to dereference into temporary var
      Type readOnlyElemType = TypeChecker.containerElemType(arrayVar, false);
      copyDst = varCreator.createTmp(context,
              new RefType(readOnlyElemType, false));
      mustDereference = true;
    }


    Var backendCopyDst = VarRepr.backendVar(copyDst);
    Long arrayIndex = Literals.extractIntLit(context, arrayIndexTree);
    if (arrayIndex != null) {
      // Handle the special case where the index is a constant.
      if (Types.isArrayRef(arrType)) {
        backend.arrayRefCopyOutImm(backendCopyDst,
            backendArray, Arg.newInt(arrayIndex));
      } else {
        backend.arrayCopyOutImm(backendCopyDst,
                backendArray, Arg.newInt(arrayIndex));
      }
    } else {
      // Handle the general case where the index must be computed
      Var indexVar = eval(context, arrayIndexTree,
                          Types.arrayKeyType(arrayVar), false, renames);
      if (Types.isArrayRef(arrType)) {
        backend.arrayRefCopyOutFuture(backendCopyDst, backendArray,
              VarRepr.backendVar(indexVar));
      } else {
        backend.arrayCopyOutFuture(backendCopyDst, backendArray,
                VarRepr.backendVar(indexVar));
      }
    }
    // Do the dereference down here so that it is generated in a more logical
    // order
    if (mustDereference) {
      dereference(context, oVar, copyDst);
    }
  }

  private Type chooseArrayTypeForLookup(Var oVar, Type arrExprType) {
    for (Type altType: UnionType.getAlternatives(arrExprType)) {
      assert(Types.isArray(altType) || Types.isArrayRef(altType));
      Type lookupRes = VarRepr.containerElemRepr(
                                Types.containerElemType(altType), false);
      if (lookupRes.equals(oVar.type())) {
        return altType;
      }
    }
    throw new STCRuntimeError("No viable array type for lookup up "
              + arrExprType + " into " + oVar);
  }

  /**
   * Lookup the turbine ID of a struct member
   *
   * @param context
   * @param tree
   *          STRUCT_LOOKUP expression
   * @param type
   *          type of expression
   * @param storeInStack
   * @param outVar (optional) variable to copy output into
   * @return a new variable which is an alias for the struct member
   * @throws UndefinedTypeException
   * @throws UserException
   */
  private Var structLoad(Context context, SwiftAST tree,
      Type type, boolean storeInStack, Var outVar,
      Map<String, String> renames) throws UndefinedTypeException,
      UserException {
    LogHelper.debug(context, "Eval struct lookup into " + outVar);

    if (storeInStack) {
      throw new STCRuntimeError("Dont know how to store results of "
          + " struct lookup in stack");
    }

    // Check if the field is cached
    assert (tree.getType() == ExMParser.STRUCT_LOAD);
    assert (tree.getChildCount() == 2);

    SwiftAST structTree = tree.child(0);
    LinkedList<String> pathFromRoot = new LinkedList<String>();
    pathFromRoot.addFirst(tree.child(1).getText());
    /*
     * Walk the tree to find out the full path if we are accessing a nested
     * struct.  rootStruct should be the name of the outermost nested struct
     */
    while (structTree.getType() == ExMParser.STRUCT_LOAD) {
      assert (structTree.getChildCount() == 2);
      pathFromRoot.addFirst(structTree.child(1).getText());
      structTree = structTree.child(0);
    }

    Var rootStruct;
    if (structTree.getType() == ExMParser.VARIABLE) {
      // The root is a local variable
      assert (structTree.getChildCount() == 1);
      String structVarName = structTree.child(0).getText();
      rootStruct = context.lookupVarUser(structVarName);
    } else {
      Type parentType = TypeChecker.findExprType(context, structTree);
      // Type error should have been caught earlier
      assert(Types.isStruct(parentType) || Types.isStructRef(parentType));
      rootStruct = eval(context, structTree, parentType, false, renames);
    }

    return structLookup(context, rootStruct, pathFromRoot, storeInStack, outVar);
  }


  private Var derefOrCopyResult(Context context, Var lookupResult,
      Var outVar) throws UndefinedTypeException, UserException {
    try {
      if (outVar == null) {
        return lookupResult;
      } else if (Types.isRefTo(lookupResult, outVar)) {
        dereference(context, outVar, lookupResult);
        return outVar;
      } else {
        copyByValue(context, outVar, lookupResult);
        return outVar;
      }
    } catch (RuntimeException e) {
      Logging.getSTCLogger().debug("Failure while trying to get " +
                                    lookupResult + " into " + outVar);
      throw e;
    }
  }


  private void arrayRange(Context context, SwiftAST tree, Var oVar,
      Map<String, String> renames) throws UserException {
    assert(Types.isArray(oVar));
    ArrayRange ar = ArrayRange.fromAST(context, tree);
    Type rangeType = ar.rangeType(context);

    assert(rangeType.assignableTo(oVar.type().memberType()));

    Var startV = eval(context, ar.getStart(), rangeType, false, null);
    Var endV = eval(context, ar.getEnd(), rangeType, false, null);
    List<Var> inArgs;
    SpecialFunction fn;
    if (ar.getStep() != null) {
      Var stepV = eval(context, ar.getStep(), rangeType,  false, null);

      inArgs = Arrays.asList(startV, endV, stepV);
      if (Types.isInt(rangeType)) {
        fn = SpecialFunction.RANGE_STEP;
      } else {
        assert(Types.isFloat(rangeType));
        fn = SpecialFunction.RANGE_FLOAT_STEP;
      }
    } else {
      inArgs = Arrays.asList(startV, endV);
      if (Types.isInt(rangeType)) {
        fn = SpecialFunction.RANGE;
      } else {
        assert(Types.isFloat(rangeType));
        fn = SpecialFunction.RANGE_FLOAT;
      }
    }
    FnID fnID = context.getForeignFunctions().findSpecialImpl(fn);
    if (fnID == null) {
      throw new STCRuntimeError("could not find implementation for " + fn);
    }
    backend.builtinFunctionCall(fnID, VarRepr.backendVars(inArgs),
                                VarRepr.backendVars(oVar));
  }

  /**
   * Construct an array with elements
   * [e1, e2, e3, e4].  We start numbering from 0
   * @param context
   * @param tree
   * @param oVar
   * @param renames
   * @throws UserException
   */
  private void arrayElems(Context context, SwiftAST tree, Var oVar,
    Map<String, String> renames) throws UserException {
    assert(Types.isArray(oVar));
    ArrayElems ae = ArrayElems.fromAST(context, tree);
    Type arrType = TypeChecker.findExprType(context, tree);
    assert(Types.isArray(arrType) || Types.isUnion(arrType));
    assert(arrType.assignableTo(oVar.type()));

    Type keyType = Types.arrayKeyType(oVar);
    Type valType = Types.containerElemType(oVar);

    // Evaluate all the values
    List<Var> vals = new ArrayList<Var>(ae.getElemCount());
    for (SwiftAST val: ae.getVals()) {
      vals.add(eval(context, val, valType, false, renames));
    }

    Var backendOVar = VarRepr.backendVar(oVar);
    boolean elemIsRef = VarRepr.storeRefInContainer(Types.containerElemType(oVar));
    /* We can only use arrayBuild operation if we have the keys and values in
     * the appropriate format for the internal container representation.
     * If user specified keys, they will be futures so we can't use them here.
     * If the container representation stores values inline, can't use
     * those either. */
    if (ae.hasKeys()) {
      List<Var> backendKeys = new ArrayList<Var>(ae.getElemCount());
      for (SwiftAST key: ae.getKeys()) {
        Var keyVar = eval(context, key, keyType, false, renames);
        backendKeys.add(VarRepr.backendVar(keyVar));
      }

      for (int i = 0; i < ae.getElemCount(); i++) {
        Var backendVal = VarRepr.backendVar(vals.get(i));
        if (elemIsRef) {
          // Store reference to future
          backend.arrayStoreFuture(backendOVar, backendKeys.get(i),
                                   backendVal.asArg());
        } else {
          // Must copy from future into container
          backend.arrayCopyInFuture(backendOVar, backendKeys.get(i),
                                    backendVal);
        }
      }
    } else {
      assert(!ae.hasKeys());
      assert(Types.isInt(keyType));
      List<Arg> backendKeys = arrayElemsDefaultKeys(ae);
      if (elemIsRef) {
        // We know keys ahead of time and elem storage format matches our
        // input variables, use arrayBuild operation
        backend.arrayBuild(backendOVar, backendKeys,
                           VarRepr.backendVars(vals));
      } else {
        for (int i = 0; i < ae.getElemCount(); i++) {
          Var backendVal = VarRepr.backendVar(vals.get(i));
          if (elemIsRef) {
            // Store reference to future
            backend.arrayStore(backendOVar, backendKeys.get(i),
                                     backendVal.asArg());
          } else {
            // Must copy from future into container
            backend.arrayCopyInImm(backendOVar, backendKeys.get(i),
                                   backendVal);
          }
        }
      }
    }

  }

  private List<Arg> arrayElemsDefaultKeys(ArrayElems ae) {
    List<Arg> backendKeys = new ArrayList<Arg>(ae.getElemCount());
    for (int i = 0; i < ae.getElemCount(); i++) {
      backendKeys.add(Arg.newInt(i));
    }
    return backendKeys;
  }

  /**
   * Copy in.
   * @param struct
   * @param fieldPath
   * @param input
   * @throws TypeMismatchException
   * @throws DoubleDefineException
   * @throws UndefinedTypeException
   */
  void structCopyIn(Context context, Var struct,
                      List<String> fieldPath, Var input)
                          throws UserException {
    if (Types.simpleCopySupported(input)) {
      backend.structCopyIn(VarRepr.backendVar(struct), fieldPath,
          VarRepr.backendVar(input));
    } else if (Types.isFile(input)) {
      Var fieldAlias = structCreateAlias(context, struct, fieldPath);
      copyFileByValue(fieldAlias, input);
    } else {
      throw new STCRuntimeError("Unexpected type: " + input);
    }
  }

  /**
   * Assign int literal value
   * @param context
   * @param dst
   * @param val value
   * @throws UserException
   */
  private void assignIntLit(Context context, Var dst, Long val)
                                  throws UserException {
   LogHelper.trace(context, dst.toString()+"="+val);
   if (Types.isInt(dst)) {
     assign(dst, Arg.newInt(val));
   } else {
     assert(Types.isFloat(dst)) : dst;
     double fVal = Literals.interpretIntAsFloat(context, val);
     assign(dst, Arg.newFloat(fVal));
   }
  }

  /**
   * Assign bool literal value from tree
   * @param context
   * @param dst
   * @param tree
   * @throws UserException
   */
  private void assignBoolLit(Context context, SwiftAST tree, Var dst)
            throws UserException {
   assert(Types.isBool(dst));
   String val = Literals.extractBoolLit(context, tree);
  assign(dst, Arg.newBool(Boolean.parseBoolean(val)));
  }

  /**
   * Assign float literal value from tree
   * @param context
   * @param tree
   * @param dst
   * @throws UserException
   */
  private void assignFloatLit(Context context, SwiftAST tree, Var dst)
  throws UserException {
   assert(Types.isFloat(dst));
   double val = Literals.extractFloatLit(context, tree);
   assign(dst, Arg.newFloat(val));
  }

  /**
   * Assign float literal value from tree
   * @param context
   * @param tree
   * @param dst
   * @throws UserException
   */
  private void assignStringLit(Context context, SwiftAST tree, Var dst)
          throws UserException {
    assert(Types.isString(dst));
    String val = Literals.extractStringLit(context, tree);
    assert(val != null);
    assign(dst, Arg.newString(val));
  }

  /**
   * Handle variable assignment, assigning src to dst
   * @param context
   * @param dst
   * @param src
   * @throws UserException
   */
  private void assignVariable(Context context, Var dst, Var src)
                                  throws UserException {
    if (Types.isPrimUpdateable(src)) {
      Var snapshot = snapshotUpdateable(context, src);
      src = snapshot;
    }

    Type srcType = src.type();
    Type dstType = dst.type();
    TypeChecker.checkCopy(context, srcType, dstType);

    copyByValue(context, dst, src);
  }

  /**
   * Get a snapshot of an updateable and assign to future
   * @param context
   * @param src
   * @return
   * @throws UserException
   * @throws UndefinedTypeException
   */
  Var snapshotUpdateable(Context context, Var src)
      throws UserException, UndefinedTypeException {
    assert(Types.isPrimUpdateable(src));
    // Create a future alias to the updateable type so that
    // types match
    Var val = varCreator.createTmpLocalVal(context,
                          ScalarUpdateableType.asScalarValue(src.type()));
    Var backendVal = VarRepr.backendVar(val);

    backend.latestValue(backendVal, src);

    if (!src.type().assignableTo(Types.UP_FLOAT)) {
      throw new STCRuntimeError(src.type() + " not yet supported");
    }

    /* Create a future with a snapshot of the value of the updateable
     * By making the retrieve and store explicit the optimizer should be
     * able to optimize out the future in many cases
     */
    Var snapshot = assignToVar(context, val.asArg(), false);
    return snapshot;
  }

  /**
   * Copy non-local data by value
   * @param context
   * @param dst
   * @param src
   * @throws UserException
   */
  private void backendAsyncCopy(Context context, Var dst, Var src,
          boolean strictTypes) throws UserException {
    if (strictTypes) {
      assert(src.type().assignableTo(dst.type()));
    } else {
      assert(src.type().getImplType().assignableTo(
          dst.type().getImplType()));
    }
    assert(src.storage() != Alloc.LOCAL);
    backend.asyncCopy(VarRepr.backendVar(dst), VarRepr.backendVar(src));
  }

  private void copyFileByValue(Var dst, Var src)
      throws TypeMismatchException {
    Var backendSrc = VarRepr.backendVar(src);
    Var backendDst = VarRepr.backendVar(dst);
    if (dst.isMapped() == Ternary.FALSE ||
        dst.type().fileKind().supportsPhysicalCopy()) {
        backend.copyFile(backendDst, backendSrc);
    } else {
      throw new TypeMismatchException("Do not support physical copy " +
          "to (possibly) mapped variable " + dst.name() + " with " +
          "type " + dst.type().typeName());
    }
  }

  private void derefThenCopyContainer(Context context, Var dst, Var src)
      throws UserException, UndefinedTypeException {
    assert(Types.isContainerRef(src));
    assert(Types.isRefTo(src, dst));
    String wName = context.getFunctionContext().constructName("copy-wait");
    List<Var> waitVars = Arrays.asList(src);
    backend.startWaitStatement(wName, VarRepr.backendVars(waitVars),
            WaitMode.WAIT_ONLY, false, false, ExecTarget.nonDispatchedAny());
    Var derefed = varCreator.createTmpAlias(context, dst.type());
    retrieveRef(derefed, src, false);
    backendAsyncCopy(context, dst, derefed, true);
    backend.endWaitStatement();
  }

  private Var structCreateAlias(Context context, Var struct,
      List<String> fieldPath) throws UserException {
    Type fieldType = TypeChecker.findStructFieldType(context, fieldPath,
                                                     struct.type());

    Var result = varCreator.createStructFieldAlias(context,
                        struct, fieldType, fieldPath);
    backend.structCreateAlias(VarRepr.backendVar(result),
                  VarRepr.backendVar(struct), fieldPath);
    return result;
  }

  /**
   * Copy a struct reference to a struct.
   * @param context
   * @param dst
   * @param src
   * @throws UserException
   * @throws UndefinedTypeException
   */
  private void dereferenceStruct(Context context, Var dst, Var src)
      throws UserException, UndefinedTypeException {
    List<Var> waitVars = Arrays.asList(src);
    backend.startWaitStatement( context.constructName("copystruct"),
                    VarRepr.backendVars(waitVars), WaitMode.WAIT_ONLY,
                    false, false, ExecTarget.nonDispatchedAny());
    Var rValDerefed = varCreator.createTmp(context,
            src.type().memberType(), false, true);
    retrieveRef(rValDerefed, src, false);
    backendAsyncCopy(context, dst, rValDerefed, true);
    backend.endWaitStatement();
  }

  void findArraysInStruct(Context context,
      Var root, VInfo structVInfo, List<Pair<Var, VInfo>> arrays)
          throws UndefinedTypeException, UserException {
    assert(Types.isStruct(root));
    findArraysInStruct(context, root, (StructType)root.type(),
                    structVInfo, new StackLite<String>(), arrays);
  }

  /**
   *
   * @param context
   * @param rootStruct root struct
   * @param currStructType current structure type (of root of sub-structure)
   * @param currStructVInfo
   * @param fieldPath
   * @param arrays
   * @throws UndefinedTypeException
   * @throws UserException
   */
  private void findArraysInStruct(Context context,
      Var rootStruct, StructType currStructType, VInfo currStructVInfo,
      StackLite<String> fieldPath, List<Pair<Var, VInfo>> arrays) throws UndefinedTypeException,
                                                                      UserException {
    assert(currStructVInfo != null);

    for (StructField f: currStructType.fields()) {
      fieldPath.push(f.name());
      if (Types.isArray(f.type())) {
        Var fieldVar = structLookup(context, rootStruct, fieldPath, false);
        VInfo fieldInfo = currStructVInfo != null ?
            currStructVInfo.getFieldVInfo(f.name()) : null;
        arrays.add(Pair.create(fieldVar, fieldInfo));
      } else if (Types.isStruct(f.type())) {
        VInfo nestedVInfo = currStructVInfo.getFieldVInfo(f.name());
        findArraysInStruct(context, rootStruct, (StructType)f.type(),
                                  nestedVInfo, fieldPath, arrays);
      }

      fieldPath.pop();
    }
  }
}
