
package exm.ast;

import java.util.*;

import exm.ast.Types.FunctionType;
import exm.ast.Types.SwiftType;
import exm.ast.Variable.DefType;
import exm.ast.Variable.VariableStorage;
import exm.parser.util.*;

public class LocalContext
extends Context
{
  Context parent = null;
  GlobalContext globals = null;

  private final FunctionContext functionContext;

  public LocalContext(Context parent) {
    this(parent, null);
  }

  public LocalContext(Context parent, String functionName)
  {
    this.functionContext = functionName != null ?
          new FunctionContext(functionName) : null;

    this.parent = parent;
    this.level = parent.level + 1;
    this.logger = parent.getLogger();
    this.globals = parent.getGlobals();
    nested = true;
    line = parent.line;
    this.structFieldMap = new HashMap<String, Variable>();
    if (parent != null && parent instanceof LocalContext) { 
      this.structFieldMap.putAll(((LocalContext)parent).structFieldMap);
    }
  }

  @Override
  public Variable getDeclaredVariable(String name)
  {
    Variable result;
    result = variables.get(name);
    if (result != null)
      return result;
    return parent.getDeclaredVariable(name);
  }

  @Override
  public Variable declareVariable(SwiftType type, String name, VariableStorage scope,
      DefType defType, String mapping)
  throws UserException
  {
    logger.trace("context: declareVariable: " +
                 type.toString() + " " + name + "<" + scope.toString() + ">"
                 + "<" + defType.toString() + ">");

    Variable variable = new Variable(type, name, scope, defType, mapping);
    declareVariable(variable);
    return variable;
  }

  @Override
  public Variable createIntermediateVariable(SwiftType type) throws UserException {
	  String name;
	  if (Types.requiresMapping(type)) {
      throw new STCRuntimeError("Can't create temporary mapped " +
                        "variables yet");
    }
	  do {
	    int counter = getFunctionContext().getCounterVal("intermediate_var");
	    name = Variable.TMP_VAR_PREFIX + counter;
	  } while (getDeclaredVariable(name) != null); // In case variable name in use

	  return declareVariable(type, name, VariableStorage.STACK, 
	              DefType.LOCAL_COMPILER, null);
  }

  @Override
  public Variable createLocalTmpVariable(SwiftType type) {
    String name;
    if (Types.requiresMapping(type)) {
      throw new STCRuntimeError("Can't create temporary mapped " +
                        "variables yet");
    }
    do {
      int counter = getFunctionContext().getCounterVal("local_tmp_var");
      name = Variable.LOCAL_TMP_VAR_PREFIX + counter;
    } while (getDeclaredVariable(name) != null);

    Variable v =  new Variable(type, name, VariableStorage.TEMPORARY,
                                          DefType.LOCAL_COMPILER);
    variables.put(name, v);
    return v;
  }

  @Override
  public Variable createAliasVariable(SwiftType type) throws UserException {
    String name;
    do {
      int counter = getFunctionContext().getCounterVal("alias_var");
      name = Variable.ALIAS_VAR_PREFIX + counter;
    } while (getDeclaredVariable(name) != null);

    Variable v =  new Variable(type, name, VariableStorage.ALIAS,
                                          DefType.LOCAL_COMPILER);
    variables.put(name, v);
    return v;
  }

  /**
   *
   * @param type
   * @param varName the name of the variable this is the value of:
   *    try and work this into the generated name. Can be left as
   *    null
   * @return
   * @throws UserException
   */
  @Override
  public Variable createLocalValueVariable(SwiftType type, String varName)
      throws UserException {
    String name = null;
    String prefix = Variable.LOCAL_VALUE_VAR_PREFIX;
    boolean generate = true;
    if (varName != null) {
      prefix += varName;
      // see if we can give it a nice name
      if (getDeclaredVariable(prefix) == null) {
        name = prefix;
        generate = false;
      }
    }

    if (generate) {
      do {
        int counter = getFunctionContext().getCounterVal("value_var");
        name = prefix + counter;
      } while (getDeclaredVariable(name) != null);
    }
    assert(name != null);
    Variable v =  new Variable(type, name, VariableStorage.LOCAL,
                                          DefType.LOCAL_COMPILER);
    variables.put(name, v);
    return v;
  }

  Variable declareVariable(Variable variable)
  throws DoubleDefineException
  {
    String name = variable.getName();
    Variable t = getDeclaredVariable(name);
    if (t != null)
      throw new DoubleDefineException
      (this, "variable already defined: " + name);

    variables.put(name, variable);
    return variable;
  }

  @Override
  public SwiftType getType(String name)
  throws UndefinedVariableException
  {
    Variable variable = getDeclaredVariable(name);
    if (variable == null)
      throw new UndefinedVariableException
      (this, "undefined variable: " + name);
    return variable.getType();
  }

  @Override
  public boolean isAppFunction(String name)
  {
    return globals.isAppFunction(name);
  }

  @Override
  public boolean isBuiltinFunction(String name)
  {
    return globals.isBuiltinFunction(name);
  }
  
  @Override
  public boolean isSyncComposite(String name) {
    return globals.isSyncComposite(name);
  }

  @Override
  public boolean isCompositeFunction(String name)
  {
    return globals.isCompositeFunction(name);
  }

  @Override
  public FunctionType lookupFunction(String name) {
    return globals.lookupFunction(name);
  }

  @Override
  public void defineCompositeFunction(String name, FunctionType ft,
        boolean async) throws DoubleDefineException {
    globals.defineCompositeFunction(name, ft, async);
  }

  @Override
  public void defineAppFunction(String name, FunctionType ft)
    throws DoubleDefineException {
    globals.defineAppFunction(name, ft);
  }

  @Override
  public GlobalContext getGlobals()
  {
    return globals;
  }

  @Override
  public Map<String, VisibleVariable> getVisibleVariables()
  {
    Map<String, VisibleVariable> result =
      new HashMap<String, VisibleVariable>(variables.size());

    // Add all from parent and update the scope level
    result.putAll(parent.getVisibleVariables());

    for (VisibleVariable v: result.values()) {
      v.setScopeLevel(v.getScopeLevel() + 1);
    }

    for (Variable v: variables.values()) {
      // Add to result, overwriting any parent variables with same name
      if (v.getStorage() == VariableStorage.STACK) {
        result.put(v.getName(), new VisibleVariable(0, v));
      }
    }

    return result;
  }

  public void addDeclaredVariables(List<Variable> variables)
  throws DoubleDefineException
  {
    for (Variable v : variables)
      declareVariable(v);
  }

  @Override
  public void setInputFile(String file) {
    globals.setInputFile(file);
  }

  @Override
  public String getInputFile() {
    return globals.getInputFile();
  }

  @Override
  public String toString()
  {
    return getVisibleVariables().toString();
  }

  @Override
  public SwiftType lookupType(String typeName) {
    return globals.lookupType(typeName);
  }

  @Override
  public void defineType(String typeName, SwiftType newType)
    throws DoubleDefineException {
    globals.defineType(typeName, newType);
  }
  @Override
  public Map<String, SwiftType> getCurrentTypeMapping() {
    return globals.getCurrentTypeMapping();
  }

  /** <var>.<path> -> variable) */


  /**
   * Called when we want to create a new alias for a structure filed
   */
  @Override
  protected Variable createStructFieldTmp(Variable struct,
      SwiftType fieldType, String fieldPath,
      VariableStorage storage) {
    // Should be unique in context
    String basename = Variable.STRUCT_FIELD_VAR_PREFIX
        + struct.getName() + "_" + fieldPath.replace('.', '_');
    String name = basename;
    int counter = 1;
    while (getDeclaredVariable(name) != null) {
      name = basename + "-" + counter;
      counter++;
    }
    Variable tmp = new Variable(fieldType, name, storage, DefType.LOCAL_COMPILER);
    variables.put(tmp.getName(), tmp);
    if (!structFieldMap.containsKey(fieldPath)) {
      structFieldMap.put(struct.getName() + "." + fieldPath, tmp);
    }
    return tmp;
  }
  
  private final HashMap<String, Variable> structFieldMap;
  
  @Override
  public Variable getStructFieldTmp(Variable struct, List<String> fieldPath) {
    return structFieldMap.get(struct.getName() + "." + buildPathStr(fieldPath)); 
  }

  @Override
  public Collection<Variable> getCachedStructFields() {
    return Collections.unmodifiableCollection(structFieldMap.values());
  }
  
  @Override
  public FunctionContext getFunctionContext() {
    if (this.functionContext != null) {
      return this.functionContext;
    } else {
      return parent.getFunctionContext();
    }
  }
  
  private final ArrayList<Variable> arraysToClose = 
        new ArrayList<Variable>();
  
  @Override
  public void flagArrayForClosing(Variable var) {
    assert(Types.isArray(var.getType()));
    arraysToClose.add(var);
  }
  
  @Override
  public List<Variable> getArraysToClose() {
    return Collections.unmodifiableList(arraysToClose);
  }
}
