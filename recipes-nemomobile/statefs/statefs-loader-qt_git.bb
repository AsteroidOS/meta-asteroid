SUMMARY = "Nemomobile's statefs-loader-qt"
HOMEPAGE = "https://github.com/sailfishos/statefs-loader-qt"
LICENSE = "LGPL-2.1+"
LIC_FILES_CHKSUM = "file://COPYING;md5=4fbd65380cdd255951079008b364516c"

SRC_URI = "git://github.com/sailfishos/statefs-loader-qt.git;protocol=https"
SRCREV = "2685ce9f7dce1068bb0da34fa38a07e75131d51e"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"

DEPENDS += "qtbase cor statefs"
inherit cmake_qt5

B = "${WORKDIR}/git"
EXTRA_OECMAKE=" -DUSEQT=5 -DOE_QMAKE_PATH_EXTERNAL_HOST_BINS=${STAGING_DIR_NATIVE}/usr/bin/"

FILES:${PN} += "/usr/lib/statefs/"
FILES:${PN}-dbg += "/usr/lib/statefs/.debug/"
