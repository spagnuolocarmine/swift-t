
# TURBINE BUILD CONFIG

# BASH-formatted setup script filtered by turbine/configure
#
# This contains variables relevant to compiling code that uses the 
# Turbine C interface

DEBIAN_BUILD=0 # Let configure-time substitution tell us 
                            # if this is a Debian installation
if (( DEBIAN_BUILD ))
then
  TURBINE_HOME=/usr/lib/turbine
else
  TURBINE_HOME='/home/giuseppe/EMEWS/swift-t-install/turbine'
fi
TURBINE_VERSION='1.2.3'
C_UTILS_HOME='/home/giuseppe/EMEWS/swift-t-install/c-utils'
TCL_HOME='/usr'
TCL_VERSION='8.6'
TCL_LIB_DIR='/usr/lib/x86_64-linux-gnu'
TCL_SYSLIB_DIR=''
TCL_LIB_SPEC='-L/usr/lib/x86_64-linux-gnu -ltcl8.6'
# Tcl library dependencies for static build
TCL_LIB_SPEC_EXTRA='-ldl -lz  -lpthread -lm'
TCL_INCLUDE_SPEC='-I/usr/include/tcl8.6'
TCLSH='/usr/bin/tclsh8.6'
ADLB_HOME='/home/giuseppe/EMEWS/swift-t-install/lb'

MPI_INCLUDE='/usr/local/include'
# Only one of the following is used
MPI_LIB_DIR='/usr/local/lib'
MPI_LIB_NAME='mpi'
MPI_LIB_SPEC='-lmpi'

ENABLE_MPE='0'
MPE='0'

# TURBINE_INCLUDES has the flags for all non-system dependencies of 
# Turbine that user code may reference
TURBINE_INCLUDES="-I${TURBINE_HOME}/include -I${C_UTILS_HOME}/include \
                  -I${ADLB_HOME}/include ${TCL_INCLUDE_SPEC}"
if [ ! -z "$MPI_INCLUDE" -a "$MPI_INCLUDE" != 0 ]; then
  TURBINE_INCLUDES+=" -I$MPI_INCLUDE"
fi

# Only use -ltclturbinestatic when static build is enabled
TURBINE_STATIC=0
tclturbinestatic="-ltclturbinestatic"
(( ! TURBINE_STATIC )) && tclturbinestatic=""

# TURBINE_LIBS has the flags for all library dependencies of
# Turbine that user code may reference
TURBINE_LIBS="-L${TURBINE_HOME}/lib \
              ${tclturbinestatic} -ltclturbine \
              -L${ADLB_HOME}/lib -ladlb \
              -L${C_UTILS_HOME}/lib -lexmcutils \
              ${TCL_LIB_SPEC} ${TCL_LIB_SPEC_EXTRA}"

# Rpath including all ExM libraries and dependencies
TURBINE_RPATH="-Wl,-rpath,${TURBINE_HOME}/lib \
               -Wl,-rpath,${ADLB_HOME}/lib \
               -Wl,-rpath,${C_UTILS_HOME}/lib"

if [ ! -z "$MPI_LIB_DIR" -a "$MPI_LIB_DIR" != 0 ]; then
  TURBINE_LIBS+=" -L$MPI_LIB_DIR"
  TURBINE_RPATH+=" -Wl,-rpath,${MPI_LIB_DIR}"
fi
TURBINE_LIBS+=" ${MPI_LIB_SPEC}"

if [ "$ENABLE_MPE" = 1 ]; then
  TURBINE_LIBS+=" -L${MPE}/lib -lmpe"
  TURBINE_INCLUDES+=" -I${MPE}/include"
  TURBINE_RPATH+=" -Wl,-rpath,${MPE}/lib"
fi

