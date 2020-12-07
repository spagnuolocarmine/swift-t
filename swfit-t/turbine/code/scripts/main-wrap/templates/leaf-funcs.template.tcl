
# This will not work in its current form. -Justin

#generate Tcl leaf function for non-main

cat << EOF > ${USER_LEAF}.tcl
namespace eval main_leaf {

    proc main_leaf_wrap { rc A } {
	deeprule \$A 1 0 "main_leaf::main_leaf_wrap_impl \$rc \$A" type $::turbine::WORK
    }

    proc main_leaf_wrap_impl { rc A } {

        set length [ adlb::container_size \$A ]
        set tds [ adlb::enumerate \$A dict all 0 ]
        set argv [ list ]
        # Fill argv with blanks
        dict for { i td } \$tds {
            lappend argv 0
        }
        # Set values at ordered list positions
        dict for { i td } \$tds {
            set s [ adlb::retrieve \$td ]
            lset argv \$i \$s
        }
        set rc_value [ ${USER_LEAF}_extension {*}\$argv ]
        turbine::store_integer \$rc \$rc_value
    }
}
EOF
