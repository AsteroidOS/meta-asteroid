SUMMARY = "C++ library providing miscelaneous handy wrappers around Qt classes/functionality. Initially it was created as the port of cutes-js to C++ to port (the-)vault to C++."
HOMEPAGE = "https://git.merproject.org/mer-core/qtaround"
LICENSE = "LGPL-2.1+"
LIC_FILES_CHKSUM = "file://LICENSE;md5=9d1d95673c01a94e06648bf72ecda12d"

SRC_URI = "git://git.merproject.org/mer-core/qtaround.git;protocol=https \
           file://0001-Add-a-missing-math.h-include.patch"
SRCREV = "468b9683308fd98c8ae449ee73f0044ac1e7a0e1"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"

DEPENDS += "qtbase cor tut-dev"
inherit cmake_qt5

EXTRA_OECMAKE=" -DVERSION=0.2.6 -DOE_QMAKE_PATH_EXTERNAL_HOST_BINS=${STAGING_DIR_NATIVE}/usr/bin/"

FILES_${PN}-dbg += "/opt"
