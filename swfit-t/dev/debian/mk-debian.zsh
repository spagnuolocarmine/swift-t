#!/bin/sh
set -eu

# MK DEBIAN
# Make the Debian package
# Used internally by Makefiles

echo "MK DEBIAN"

if [ ${#} != 5 ]
then
  echo "mk-debian: usage: PKG_TYPE DEB ORIG_TGZ NAME VERSION"
  echo "mk-debian: given $*"
  exit 1
fi

DEB_TYPE=$1 # Debian type: dev or bin
DEB=$2      # Output DEB file
ORIG_TGZ=$3 # Upstream TGZ file
NAME=$4     # Debian name
VERSION=$5  # Debian version

TOP=$PWD

echo "Making: $NAME $DEB_TYPE $VERSION => $DEB"

BUILD_DIR=$( mktemp -d .deb-work-XXX )
echo "Working in: $BUILD_DIR"
cd $BUILD_DIR

set -x
export DEBIAN_PKG=1
if ! [ ${DEB_TYPE} = "bin" ]
then
  NAME=$NAME-dev
fi

ln ../$ORIG_TGZ
tar xfz $ORIG_TGZ
(
  cd $NAME-$VERSION
  echo Running debuild in: $(pwd)
  debuild -eDEB_BUILD_OPTIONS="parallel=4" -us -uc
)

mv -v $DEB $TOP

cd $TOP
rm -r $BUILD_DIR
