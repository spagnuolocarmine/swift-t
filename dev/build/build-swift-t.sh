#!/usr/bin/env bash
set -eu

. /sw/summit/lmod/7.7.10/rhel7.3_gnu4.8.5/lmod/7.7.10/init/bash

# BUILD SWIFT-T

# Main user interface
# Swift/T build script: runs configuration and compilation
# See options.sh for options

THIS=$(   dirname  $0 )
SCRIPT=$( basename $0 )

${THIS}/check-settings.sh
source ${THIS}/functions.sh
source ${THIS}/options.sh
source ${THIS}/swift-t-settings.sh
source ${THIS}/setup.sh

LOG $LOG_WARN "Installing Swift/T into: $SWIFT_T_PREFIX"
LOG_WAIT 3

LOG $LOG_INFO ""
${THIS}/build-cutils.sh

LOG $LOG_INFO ""
${THIS}/build-lb.sh

LOG $LOG_INFO ""
${THIS}/build-turbine.sh

LOG $LOG_INFO ""
${THIS}/build-stc.sh

LOG $LOG_INFO
LOG $LOG_WARN "Swift/T build successful."
