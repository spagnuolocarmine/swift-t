
/*
   EMEWS EQJL.swift
*/

import location;
pragma worktypedef resident_work;

@dispatch=resident_work
(void v) _void_jl(string code, string expr="\"\"") "turbine" "0.1.0"
    [ "turbine::julia 1 1 <<code>> <<expr>> "];

@dispatch=resident_work
(string output) _string_jl(string code, string expr) "turbine" "0.1.0"
    [ "set <<output>> [ turbine::julia 1 1 <<code>> <<expr>> ]" ];

string init_package_string = "import eqjl\neqjl.init('%s')";

(void v) EQJL_init_package(location loc, string packageName){
    //printf("EQPy_init_package(%s) ...", packageName);
    string code = init_package_string % (packageName); //,packageName);
    //printf("Code is: \n%s", code);
    @location=loc _void_jl(code) => v = propagate();
}

(void v)
EQJL_stop(location loc){
    // do nothing but set the void
    v = propagate();
}

string get_string = "result = eqjl.output_q_get()";

(string result) EQJL_get(location loc){
    //printf("EQPy_get called");
    string code = get_string;
    //printf("Code is: \n%s", code);
    result = @location=loc _string_jl(code, "result");
}

string put_string = """
eqjl.input_q.put("%s")\n""
""";

(void v) EQJL_put(location loc, string data){
    // printf("EQPy_put called with: \n%s", data);
    string code = put_string % data;
    // printf("EQPy_put code: \n%s", code);
    @location=loc _void_jl(code) => v = propagate();
}

// Local Variables:
// c-basic-offset: 4
// End: