# Swift/T version with working Julia 1.5

## Changelog
- turbine/code/Makefile.in
  - Line 314 ```INCLUDES += -I $(USE_JULIA)/include/julia```
  - Line 390 ```JULIA_LIB = $(USE_JULIA)/lib``` 
- turbine/code/src/tcl/julia/tcl-julia.c
  - added library ```#include <dlfcn.h>``` in order to do the dynamic link from external source through 
```dlopen("libjulia.so", RTLD_NOW | RTLD_GLOBAL);```, commented definition ```JL_SET_STACK_BASEM;``` in ```julia_inizialize(void).

## Build

1. 
