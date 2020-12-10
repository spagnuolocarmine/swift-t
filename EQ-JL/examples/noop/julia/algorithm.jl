begin
    include("../ext/EQJL/eqjl.jl")
    using .eqjl
    function algo() 
        eqjl.OUT_put("1;2;3;4;5;6")
        result = eqjl.IN_get()
        eqjl.OUT_put("33;45;46")
        result = eqjl.IN_get()
        eqjl.OUT_put("FINAL")
    end
    @async algo()
end