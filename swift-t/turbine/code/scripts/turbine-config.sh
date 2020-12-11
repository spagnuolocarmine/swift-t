
# TURBINE CONFIG SH

# BASH-formatted setup script filtered by turbine/configure
#
# Influential environment variables include:
# SWIFT_PATH / TURBINE_PATH / TURBINE_USER_LIB - directory for user library code
# TURBINE_STATIC_EXEC - if true, try to use statically linked executable

DEBIAN_BUILD=0 # Let configure-time substitution tell us
                            # if this is a Debian installation
if (( DEBIAN_BUILD ))
then
  export TURBINE_HOME=/usr/lib/turbine
else
  export TURBINE_HOME='/home/giuseppe/swift-t-install/turbine'
fi
TURBINE_VERSION=1.2.3
export C_UTILS=/home/giuseppe/swift-t-install/c-utils
export TCL=/usr
export TCLSH=/usr/bin/tclsh8.6
export ADLB=/home/giuseppe/swift-t-install/lb

export USE_CC=/usr/local/bin/mpicc
export MPI_IMPL=OpenMPI
export MPI_LIB=/usr/local/lib
export MPI_LABEL="/usr/local/lib mpi"
export TURBINE_LAUNCHER=${TURBINE_LAUNCHER:-/usr/local/bin/mpiexec}
export TURBINE_LINE_OUTPUT_FLAG=
export TURBINE_SH=${TURBINE_HOME}/bin/turbine_sh
export TURBINE_MAC=no

# If we have pkgIndex.tcl/.so package
TURBINE_PKG_AVAIL=1

TCLLIBPATH=
if [[ -n ${SWIFT_PATH:-} ]]
then
  TCLLIBPATH+="${SWIFT_PATH} "
elif [[ -n ${TURBINE_PATH:-} ]]
then
  TCLLIBPATH+="${TURBINE_PATH} "
elif [[ -n ${TURBINE_USER_LIB:-} ]]
then
  TCLLIBPATH+="${TURBINE_USER_LIB} "
fi

EXEC_SCRIPT=${EXEC_SCRIPT:-0}
TURBINE_STATIC_EXEC=${TURBINE_STATIC_EXEC:-0}
if (( EXEC_SCRIPT ))
then
  # Run script directly
  export TCLSH=""
elif (( TURBINE_STATIC_EXEC ))
then
  # Use statically linked executable with builtin Turbine package
  export TCLSH=${TURBINE_SH}
elif (( !TURBINE_PKG_AVAIL ))
then
  # Don't have dynamically loadable package - must use statically linked
  # executable
  export TCLSH=${TURBINE_SH}
else
  # Use regular tclsh plus loadable Turbine Tcl package
  if [[ ${TCLSH} == "" ]]
  then
    echo "Could not find tclsh!"
    return 1
  fi
  TCLLIBPATH+="${TURBINE_HOME}/lib"
fi

export TCLLIBPATH

export TURBINE_MACHINE=normal

export TURBINE_USE_PYTHON=
export TURBINE_USE_PYTHON_NAME=
export TURBINE_USE_R=0

if [[ ${TURBINE_USE_R} != 0 ]]
then
  R_LIB=${TURBINE_USE_R}/lib
  export LD_LIBRARY_PATH=${LD_LIBRARY_PATH:-}${LD_LIBRARY_PATH:+:}${R_LIB}
fi

return 0
