package exm.stc.frontend.typecheck;

import static exm.stc.frontend.typecheck.FunctionTypeChecker.checkOverloadsAmbiguity;
import static exm.stc.frontend.typecheck.FunctionTypeChecker.concretiseInputsNonOverloaded;
import static exm.stc.frontend.typecheck.FunctionTypeChecker.concretiseInputsOverloaded;
import static exm.stc.frontend.typecheck.FunctionTypeChecker.selectArgType;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import exm.stc.common.Logging;
import exm.stc.common.exceptions.InvalidOverloadException;
import exm.stc.common.exceptions.TypeMismatchException;
import exm.stc.common.lang.DefaultVals;
import exm.stc.common.lang.FnID;
import exm.stc.common.lang.ForeignFunctions;
import exm.stc.common.lang.Types;
import exm.stc.common.lang.Types.FunctionType;
import exm.stc.common.lang.Types.SubType;
import exm.stc.common.lang.Types.Type;
import exm.stc.common.lang.Types.UnionType;
import exm.stc.common.lang.Var;
import exm.stc.common.lang.Var.Alloc;
import exm.stc.common.lang.Var.DefType;
import exm.stc.common.lang.Var.VarProvenance;
import exm.stc.common.util.Pair;
import exm.stc.frontend.Context.FnOverload;
import exm.stc.frontend.GlobalContext;
import exm.stc.frontend.typecheck.FunctionTypeChecker.FnCallInfo;
import exm.stc.frontend.typecheck.FunctionTypeChecker.FnMatch;

public class FunctionTypeCheckerTest {

  private static final FnID FAKE_FN_ID = new FnID("foobar", "foobar");

  private static final SubType FLOAT_SUB_TYPE = new SubType(Types.F_FLOAT, "float2");
  private static final Type INT_OR_FLOAT =
      UnionType.createUnionType(Types.F_INT, Types.F_FLOAT);
  private static final Type FLOAT_OR_INT =
      UnionType.createUnionType(Types.F_FLOAT, Types.F_INT);
  private static final Type INT_OR_STRING =
      UnionType.createUnionType(Types.F_INT, Types.F_STRING);

  private static final Type STRING_OR_INT =
      UnionType.createUnionType(Types.F_STRING, Types.F_INT);

  private static final GlobalContext FAKE_CONTEXT =
      new GlobalContext("fake.swift", Logging.getSTCLogger(),
      new ForeignFunctions());
  @Rule
  public ExpectedException exception = ExpectedException.none();

  @BeforeClass
  public static void setupLogging() throws Exception {
    Logging.setupLogging("FunctionTypeCheckerTest.stc.log", true);
  }

  @Test
  public void testSelectArgTypeSimple() {
    assertEquals("Basic matching should work",
        Pair.create(Types.F_FLOAT, Types.F_FLOAT),
        selectArgType(Types.F_FLOAT, Types.F_FLOAT, false));
  }

  @Test
  public void testSelectArgTypeSubtype() {
    assertEquals("Subtype upcasting should work",
        Pair.create(Types.F_FLOAT, FLOAT_SUB_TYPE),
        selectArgType(Types.F_FLOAT, FLOAT_SUB_TYPE, false));

    assertTrue("Subtype downcasting not allowed",
        selectArgType(FLOAT_SUB_TYPE, Types.F_FLOAT, false) == null);
  }

  @Test
  public void testSelectArgTypeUnion() {
    assertEquals("Int matches IntOrFloat",
        Pair.create(Types.F_INT, Types.F_INT),
        selectArgType(Types.F_INT, INT_OR_FLOAT, false));

    assertEquals("Float matches IntOrFloat",
        Pair.create(Types.F_INT, Types.F_INT),
        selectArgType(Types.F_INT, INT_OR_FLOAT, false));

    assertEquals("IntOrFloat matches IntOrFloat",
        Pair.create(Types.F_INT, Types.F_INT),
        selectArgType(INT_OR_FLOAT, INT_OR_FLOAT, false));

    assertEquals("IntOrFloat matches Float",
        Pair.create(Types.F_FLOAT, Types.F_FLOAT),
        selectArgType(INT_OR_FLOAT, Types.F_FLOAT, false));
  }

  private static final FunctionType VARARGS_TYPE = new FunctionType(
                            Arrays.asList(Types.F_INT, INT_OR_FLOAT),
                            Arrays.asList(Types.F_STRING), true);

  @Test
  public void testMatchNoVarArgs() throws TypeMismatchException {
    FnCallInfo fc = makeFnCallInfo(VARARGS_TYPE,
        Arrays.asList(Types.F_INT, Types.F_FLOAT, Types.F_INT, Types.F_FLOAT));

    FnMatch match = concretiseInputsOverloaded(FAKE_CONTEXT, fc);

    assertEquals("One matching type", 1, match.concreteAlts.size());
    assertEquals("Varargs expanded",
        Arrays.asList(Types.F_INT, Types.F_FLOAT, Types.F_INT, Types.F_FLOAT),
        match.concreteAlts.get(0).getInputs());
  }

  @Test
  public void testMatchMultiVarArgs() throws TypeMismatchException {
    FnCallInfo fc = makeFnCallInfo(VARARGS_TYPE,
                                    Arrays.asList(Types.F_INT));

    FnMatch match = concretiseInputsOverloaded(FAKE_CONTEXT, fc);

    assertEquals("One matching type", 1, match.concreteAlts.size());
    assertEquals("Varargs expanded", Arrays.asList(Types.F_INT),
                  match.concreteAlts.get(0).getInputs());
  }

  @Test
  public void testMatchVarArgsFail() throws TypeMismatchException {
    exception.expect(TypeMismatchException.class);
    FnCallInfo fc = makeFnCallInfo(VARARGS_TYPE,
                      Arrays.asList(Types.F_INT, Types.F_STRING));
    concretiseInputsOverloaded(FAKE_CONTEXT, fc);
  }


  @Test
  public void testMatchOptional() throws TypeMismatchException {
    // Function is f(int x, bool y=true)
    String name = "f";
    FunctionType ft = makeSimpleFT(Types.F_INT, Types.F_BOOL);
    Var constVar = new Var(Types.F_BOOL, "true", Alloc.GLOBAL_CONST,
                        DefType.GLOBAL_CONST, VarProvenance.unknown());
    DefaultVals<Var> defaults = DefaultVals.fromDefaultValVector(
                                  Arrays.asList(null, constVar));
    FnOverload fo = makeFnOverload(new FnID(name, name), ft, defaults);

    // Try calling with both args
    List<Type> intBoolArgs = Arrays.asList(Types.F_INT, Types.F_BOOL);
    FnCallInfo fc = makeFnCallInfo(name, fo.asList(), intBoolArgs);
    FnMatch match = concretiseInputsOverloaded(FAKE_CONTEXT, fc);

    assertEquals("One matching type", 1, match.concreteAlts.size());
    assertEquals("Matched args", intBoolArgs,
                  match.concreteAlts.get(0).getInputs());

    List<Type> intArgs = Arrays.asList(Types.F_INT);
    fc = makeFnCallInfo(name, fo.asList(), intArgs);
    match = concretiseInputsOverloaded(FAKE_CONTEXT, fc);

    // Should resolve to (int, bool) - last value filled in by default
    assertEquals("One matching type", 1, match.concreteAlts.size());
    assertEquals("Matched args", intBoolArgs,
                  match.concreteAlts.get(0).getInputs());
  }

  /**
   * Regression test - not enough arguments provided
   * @throws TypeMismatchException
   */
  @Test
  public void testMissingArgs() throws TypeMismatchException {
    exception.expect(TypeMismatchException.class);

    FunctionType intFn = makeSimpleFT(Types.F_INT, Types.F_INT);
    FnID intFnID = new FnID("int", "int");
    FnOverload intOverload = makeFnOverload(intFnID, intFn);

    // Shouldn't match - not enough args
    FnMatch match = concretiseInputsNonOverloaded(FAKE_CONTEXT,
        intOverload, Arrays.asList(Types.F_INT),
        Collections.<String, Type>emptyMap(), true);

    System.err.println(match);
  }

  /**
   * Simple overload resolution test
   * @throws TypeMismatchException
   */
  @Test
  public void testSelectOverload() throws TypeMismatchException {
    FunctionType intFn = makeSimpleFT(Types.F_INT);
    FunctionType stringFn = makeSimpleFT(Types.F_STRING);
    FnID intFnID = new FnID("int", "int");
    FnID stringFnID = new FnID("string", "string");

    FnCallInfo fc = makeOverloadedFnCallInfo(
        Arrays.asList(Types.F_STRING), Arrays.asList(
        makeFnOverload(intFnID, intFn),
        makeFnOverload(stringFnID, stringFn)));

    FnMatch match = concretiseInputsOverloaded(FAKE_CONTEXT, fc);

    assertEquals(stringFnID, match.overload.id);
    assertEquals(1, match.concreteAlts.size());
    assertEquals(stringFn, match.concreteAlts.get(0));
  }

  /**
   * Overload resolution test with some matching args
   * @throws TypeMismatchException
   */
  @Test
  public void testSelectOverloadPartialMatch() throws TypeMismatchException {
    FunctionType stringFn = makeSimpleFT(Types.F_INT, Types.F_FILE, Types.F_STRING);
    FunctionType blobFn = makeSimpleFT(Types.F_INT, Types.F_FILE, Types.F_BLOB);
    FnID blobFnID = new FnID("a", "a");
    FnID stringFnID = new FnID("b", "a");

    FnCallInfo fc = makeOverloadedFnCallInfo(
        Arrays.asList(Types.F_INT, Types.F_FILE, Types.F_STRING),
        Arrays.asList(makeFnOverload(blobFnID, blobFn),
                      makeFnOverload(stringFnID, stringFn)));

    FnMatch match = concretiseInputsOverloaded(FAKE_CONTEXT, fc);

    assertEquals(stringFnID, match.overload.id);
    assertEquals(1, match.concreteAlts.size());
    assertEquals(stringFn, match.concreteAlts.get(0));
  }

  @Test
  public void testSelectOverloadNoMatch() throws TypeMismatchException {
    exception.expect(TypeMismatchException.class);

    FunctionType intFn = makeSimpleFT(Types.F_INT);
    FunctionType stringFn = makeSimpleFT(Types.F_STRING);
    FnID intFnID = new FnID("int", "int");
    FnID stringFnID = new FnID("string", "string");

    FnCallInfo fc = makeOverloadedFnCallInfo(
        Arrays.asList(Types.F_FLOAT), Arrays.asList(
            makeFnOverload(intFnID, intFn),
            makeFnOverload(stringFnID, stringFn)));

    concretiseInputsOverloaded(FAKE_CONTEXT, fc);
  }

  @Test
  public void testSelectOverloadNoMatch2() throws TypeMismatchException {
    exception.expect(TypeMismatchException.class);

    FunctionType intFn = makeSimpleFT(Types.F_INT);
    FunctionType stringFn = makeSimpleFT(Types.F_STRING);
    FnID intFnID = new FnID("int", "int");
    FnID stringFnID = new FnID("string", "string");

    FnCallInfo fc = makeOverloadedFnCallInfo(
        Arrays.asList(Types.F_FLOAT, Types.F_FLOAT), Arrays.asList(
            makeFnOverload(intFnID, intFn),
            makeFnOverload(stringFnID, stringFn)));

    concretiseInputsOverloaded(FAKE_CONTEXT, fc);
  }

  /**
   * Check that union args are handled correctly when resolving overloads
   * @throws TypeMismatchException
   */
  @Test
  public void testSelectOverloadUnion1() throws TypeMismatchException {
    FunctionType intFn = makeSimpleFT(Types.F_INT);
    FunctionType floatFn = makeSimpleFT(Types.F_FLOAT);
    FnID intFnID = new FnID("int", "int");
    FnID floatFnID = new FnID("float", "float");

    FnCallInfo fc = makeOverloadedFnCallInfo(
        Arrays.asList(INT_OR_STRING), Arrays.asList(
            makeFnOverload(intFnID, intFn),
            makeFnOverload(floatFnID, floatFn)));

    FnMatch match = concretiseInputsOverloaded(FAKE_CONTEXT, fc);
    assertEquals(intFnID, match.overload.id);
    assertEquals(1, match.concreteAlts.size());
    assertEquals(intFn, match.concreteAlts.get(0));
  }

  /**
   * Check that union args are handled correctly when they could match
   * multiple overloads
   * @throws TypeMismatchException
   */
  @Test
  public void testSelectOverloadUnion2() throws TypeMismatchException {
    FunctionType intFn = makeSimpleFT(Types.F_INT);
    FunctionType floatFn = makeSimpleFT(Types.F_FLOAT);
    FnID intFnID = new FnID("int", "int");
    FnID floatFnID = new FnID("float", "float");

    FnOverload intOverload = makeFnOverload(intFnID, intFn);
    FnOverload floatOverload = makeFnOverload(floatFnID, floatFn);
    List<FnOverload> overloadList = Arrays.asList(intOverload, floatOverload);

    List<FnOverload> overloadListRev = Arrays.asList(floatOverload, intOverload);

    // Expression is first an int, so should resolve to int function
    FnCallInfo fc = makeOverloadedFnCallInfo(Arrays.asList(INT_OR_FLOAT),
                                             overloadList);

    FnMatch match = concretiseInputsOverloaded(FAKE_CONTEXT, fc);

    assertEquals(intFnID, match.overload.id);
    assertEquals(1, match.concreteAlts.size());
    assertEquals(intFn, match.concreteAlts.get(0));

    FnCallInfo fc2 = makeOverloadedFnCallInfo(Arrays.asList(INT_OR_FLOAT),
                                              overloadListRev);

    FnMatch match2 = concretiseInputsOverloaded(FAKE_CONTEXT, fc2);

    assertEquals(intFnID, match2.overload.id);
    assertEquals(1, match2.concreteAlts.size());
    assertEquals(intFn, match2.concreteAlts.get(0));


    FnCallInfo fc3 = makeOverloadedFnCallInfo(Arrays.asList(FLOAT_OR_INT),
                                              overloadListRev);

    FnMatch match3 = concretiseInputsOverloaded(FAKE_CONTEXT, fc3);

    assertEquals(floatFnID, match3.overload.id);
    assertEquals(1, match3.concreteAlts.size());
    assertEquals(floatFn, match3.concreteAlts.get(0));
  }

  /**
   * Test truly ambiguous scenario with union args
   * @throws TypeMismatchException
   */
  @Test
  public void testSelectOverloadUnion3() throws TypeMismatchException {
    FunctionType ft1 = makeSimpleFT(Types.F_INT, Types.F_STRING);
    FunctionType ft2 = makeSimpleFT(Types.F_STRING, Types.F_INT);
    FnID fnid1 = new FnID("1", "f");
    FnID fnid2 = new FnID("2", "f");

    FnOverload ol1 = makeFnOverload(fnid1, ft1);
    FnOverload ol2 = makeFnOverload(fnid2, ft2);
    List<FnOverload> overloadList = Arrays.asList(ol2, ol1);

    // Arguments don't unambiguously identify either
    FnCallInfo fc = makeOverloadedFnCallInfo(
        Arrays.asList(INT_OR_STRING, INT_OR_STRING), overloadList);

    exception.expect(TypeMismatchException.class);
    concretiseInputsOverloaded(FAKE_CONTEXT, fc);
  }

  /**
   * Test unambiguous scenario with union args
   * @throws TypeMismatchException
   */
  @Test
  public void testSelectOverloadUnion4() throws TypeMismatchException {
    FunctionType ft1 = makeSimpleFT(Types.F_INT, Types.F_STRING);
    FunctionType ft2 = makeSimpleFT(Types.F_STRING, Types.F_INT);
    FnID fnid1 = new FnID("1", "f");
    FnID fnid2 = new FnID("2", "f");

    FnOverload ol1 = makeFnOverload(fnid1, ft1);
    FnOverload ol2 = makeFnOverload(fnid2, ft2);
    List<FnOverload> overloadList = Arrays.asList(ol2, ol1);

    // First elements of unions are (string, int), so we should pick ft2
    FnCallInfo fc = makeOverloadedFnCallInfo(
        Arrays.asList(STRING_OR_INT, INT_OR_STRING), overloadList);

    FnMatch match = concretiseInputsOverloaded(FAKE_CONTEXT, fc);
    assertEquals(fnid2, match.overload.id);
    assertEquals(ft2, match.overload.type);
  }

  @Test
  public void testSelectOverloadVarArgs1() throws TypeMismatchException {
    List<Type> twoStrings = Arrays.asList(Types.F_STRING, Types.F_STRING);
    FunctionType ft1 = makeFT(twoStrings, true);
    FunctionType ft1NoVarArgs = makeFT(twoStrings, false);
    FunctionType ft2 = makeFT(Arrays.asList(FLOAT_OR_INT), true);
    FnID fid1 = new FnID("1", "");
    FnID fid2 = new FnID("2", "");

    FnCallInfo fc = makeOverloadedFnCallInfo(
                            twoStrings,
                            Arrays.asList(makeFnOverload(fid1, ft1),
                                          makeFnOverload(fid2, ft2)));

    FnMatch match = concretiseInputsOverloaded(FAKE_CONTEXT, fc);

    assertEquals(fid1, match.overload.id);
    assertEquals(1, match.concreteAlts.size());
    assertEquals(ft1NoVarArgs, match.concreteAlts.get(0));

  }

  @Test
  public void testSelectOverloadVarArgs2() throws TypeMismatchException {
    makeFT(Arrays.asList(Types.F_STRING, Types.F_STRING), false);
    makeFT(Arrays.asList(Types.F_STRING, FLOAT_OR_INT), true);
  }

  private FnCallInfo makeFnCallInfo(String name, List<FnOverload> fnTypes,
      List<Type> argTypes) {
    return new FnCallInfo(name, fnTypes, argTypes,
              Collections.<String, Type>emptyMap());
  }

  private FnCallInfo makeOverloadedFnCallInfo(List<Type> argTypes,
      List<FnOverload> fTypes) {
    return makeFnCallInfo("overloaded_function", fTypes, argTypes);
  }

  private FnCallInfo makeFnCallInfo(FunctionType fnType, List<Type> argTypes) {
    List<String> inArgNames = generateArgNames(argTypes.size());

    FnOverload overload = new FnOverload(FAKE_FN_ID, fnType, inArgNames,
          DefaultVals.<Var>noDefaults(fnType));
    return makeFnCallInfo(FAKE_FN_ID.originalName(), overload.asList(), argTypes);
  }


  private FnOverload makeFnOverload(FnID id, FunctionType type,
                                DefaultVals<Var> defaultVals) {
    List<String> argNames = generateArgNames(type.getInputs().size());
    return new FnOverload(id, type, argNames, defaultVals);
  }

  private FnOverload makeFnOverload(FnID id, FunctionType type) {
    return makeFnOverload(id, type, DefaultVals.<Var>noDefaults(type));
  }

  private List<String> generateArgNames(int numArgs) {
    List<String> inArgNames = new ArrayList<String>();

    for (int i = 0; i < numArgs; i++) {
      inArgNames.add("inarg" + i);
    }
    return inArgNames;
  }

  /**
   * Check for unambiguous cases that shouldn't raise exception
   * @throws InvalidOverloadException
   */
  @Test
  public void testUnambiguousOverloads() throws InvalidOverloadException {
    checkOverloadsAmbiguity(FAKE_CONTEXT, "",
        makeFT(Arrays.asList(Types.F_INT, Types.F_INT), false),
        makeFT(Arrays.asList(Types.F_INT), false));

    checkOverloadsAmbiguity(FAKE_CONTEXT, "",
        makeFT(Arrays.asList(Types.F_INT), false),
        makeFT(Arrays.asList(Types.F_FLOAT), false));

    checkOverloadsAmbiguity(FAKE_CONTEXT, "",
        makeFT(Arrays.asList(Types.F_INT), false),
        makeFT(Arrays.asList(Types.F_FLOAT), true));

    checkOverloadsAmbiguity(FAKE_CONTEXT, "",
        makeFT(Arrays.asList(Types.F_INT, Types.F_INT, Types.F_INT), true),
        makeFT(Arrays.asList(Types.F_INT), false));
  }

  /**
   * Check for trivial ambiguous case
   * @throws InvalidOverloadException
   */
  @Test
  public void testAmbiguousOverloadBasic1() throws InvalidOverloadException {

    exception.expect(InvalidOverloadException.class);

    FunctionType ft = makeFT(Arrays.asList(Types.V_INT, Types.V_FLOAT), false);

    checkOverloadsAmbiguity(FAKE_CONTEXT, "", ft, ft);
  }

  @Test
  public void testAmbiguousOverloadBasic2() throws InvalidOverloadException {

    exception.expect(InvalidOverloadException.class);

    checkOverloadsAmbiguity(FAKE_CONTEXT, "",
        makeFT(Arrays.asList(Types.F_INT, Types.F_INT), false),
        makeFT(Arrays.asList(Types.F_INT), true));
  }

  @Test
  public void testAmbiguousOverloadBasic3() throws InvalidOverloadException {
    exception.expect(InvalidOverloadException.class);

    checkOverloadsAmbiguity(FAKE_CONTEXT, "",
        makeFT(Arrays.asList(Types.F_INT, Types.F_INT, Types.F_INT), true),
        makeFT(Arrays.asList(Types.F_INT, Types.F_INT), false));
  }

  @Test
  public void testAmbiguousOverloadBasic4() throws InvalidOverloadException {
    exception.expect(InvalidOverloadException.class);

    checkOverloadsAmbiguity(FAKE_CONTEXT, "",
        makeFT(Arrays.asList(Types.F_INT), false),
        makeFT(Arrays.asList(INT_OR_FLOAT), false));
  }

  @Test
  public void testAmbiguousOverloadBasic5() throws InvalidOverloadException {
    exception.expect(InvalidOverloadException.class);

    checkOverloadsAmbiguity(FAKE_CONTEXT, "",
        makeFT(Arrays.asList(Types.F_FLOAT), false),
        makeFT(Arrays.asList((Type)FLOAT_SUB_TYPE), false));
  }

  @Test
  public void testAmbiguousOverloadOutputs() throws InvalidOverloadException {
    exception.expect(InvalidOverloadException.class);

    checkOverloadsAmbiguity(FAKE_CONTEXT, "",
        makeFT(Arrays.asList(Types.F_FLOAT, Types.F_FLOAT),
               Arrays.asList(Types.F_FLOAT), false),
        makeFT(Arrays.asList(Types.F_FILE), Arrays.asList(Types.F_INT), false));
  }

  private FunctionType makeSimpleFT(Type ...inputs) {
    return makeFT(Arrays.asList(inputs), false);
  }

  private FunctionType makeFT(List<Type> inputs, boolean varArgs) {
    return makeFT(Collections.<Type>emptyList(), inputs, varArgs);
  }

  private FunctionType makeFT(List<Type> outputs, List<Type> inputs,
      boolean varArgs) {
    return new FunctionType(inputs, outputs, varArgs);
  }

}
