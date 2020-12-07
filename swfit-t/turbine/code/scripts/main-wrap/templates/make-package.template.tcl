
# Define convenience macros
changecom(`dnl')
define(`getenv', `esyscmd(printf -- "$`$1' ")')

# dnl Receive USER_LEAF from environment for m4 processing
set USER_LEAF getenv(USER_LEAF)
set STATIC    getenv(STATIC)

set name     main_leaf
set version  0.0
set leaf_so  lib${USER_LEAF}.so
set leaf_tcl ${USER_LEAF}.tcl

if { ! $STATIC } {
    exec echo [ ::pkg::create -name $name -version $version \
                    -load $leaf_so -source $leaf_tcl ] > pkgIndex.tcl
} else {
     exec echo [ ::pkg::create -name $name -version $version \
                     -source $leaf_tcl ] > pkgIndex.tcl
}
