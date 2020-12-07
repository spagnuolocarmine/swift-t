
# MACHINE MIRA G++

#TCL_HOME=/home/wozniak/Public/sfw/ppc64/tcl-8.5.12
TCL_HOME=/home/wozniak/Public/sfw/ppc64/bgxlc/static/tcl-8.5.12
TCL_VERSION=8.5
CC=/bgsys/drivers/ppcfloor/gnu-linux/bin/powerpc64-bgq-linux-gcc
CXX=/bgsys/drivers/ppcfloor/gnu-linux/bin/powerpc64-bgq-linux-g++
STC=/home/wozniak/Public/sfw/ppc64/stc/bin/stc

MPI_HOME=/bgsys/drivers/V1R2M1/ppc64/comm
MPI_LIB_NAME=mpich-gcc
MPICC=/bgsys/drivers/V1R2M1/ppc64/comm/bin/gcc/mpicxx

TURBINE_HOME=/home/wozniak/Public/sfw/ppc64/static/turbine
ADLB_HOME=/home/wozniak/Public/sfw/ppc64/static/lb
C_UTILS_HOME=/home/wozniak/Public/sfw/ppc64/static/c-utils

source $GENLEAF_HOME/settings/flags.g++.sh
