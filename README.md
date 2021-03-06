# Swift/T version with working Julia 1.5

## Changelog
- turbine/code/Makefile.in
  - Lines 312-314 deleted
    ```INCLUDES += -I $(USE_JULIA)/src
	  INCLUDES += -I $(USE_JULIA)/usr/include
	  INCLUDES += -I $(USE_JULIA)/src/support```
  - Line 314 added ```INCLUDES += -I $(USE_JULIA)/include/julia```
  - Line 390 ```JULIA_LIB = $(USE_JULIA)/lib``` 
- turbine/code/src/tcl/julia/tcl-julia.c
  - Line 12 added library ```#include <dlfcn.h>``` in order to do the dynamic link from external source through 
```dlopen("libjulia.so", RTLD_NOW | RTLD_GLOBAL);```
  - Line 38 commented definition ```JL_SET_STACK_BASEM;``` in function ```julia_inizialize(void)```
- turbine/code/configure.ac
  - Line 848 changed ```AC_CHECK_FILE(${USE_JULIA}/include/julia/julia.h, [],```.

## Installation
1. Create a settings file:
```
./dev/build/init-settings.sh
```

1. Edit the settings file ```dev/build/swift-t-settings.sh```
```
95 # Enable Julia integration
96 ENABLE_JULIA=1
97 JULIA_INSTALL={JULIA-HOME}
```
Remember to change ```{JULIA-HOME}```with your Julia home src.

2. Run the build script ```dev/build/build-swift-t.sh```

See [The Swift/T](http://swift-lang.github.io/swift-t/guide.html) Guide for more informations.

### Contributors

- Carmine Spagnuolo, PhD
- Giuseppe D'Ambrosio, PhD Student
