SUMMARY = "Nemomobile's statefs-loader-qt"
HOMEPAGE = "https://git.merproject.org/mer-core/statefs-loader-qt"
LICENSE = "LGPL-2.1+"
LIC_FILES_CHKSUM = "file://COPYING;md5=4fbd65380cdd255951079008b364516c"

SRC_URI = "git://git.merproject.org/mer-core/statefs-loader-qt.git;protocol=https"
SRCREV = "2685ce9f7dce1068bb0da34fa38a07e75131d51e"
PR = "r1"
PV = "+git${SRCREV}"
S = "${WORKDIR}/git"

DEPENDS += "qtbase cor statefs"
inherit cmake_qt5

B = "${WORKDIR}/git"
EXTRA_OECMAKE=" -DUSEQT=5 -DOE_QMAKE_PATH_EXTERNAL_HOST_BINS=${STAGING_DIR_NATIVE}/usr/bin/qt5/"

FILES_${PN} += "/usr/lib/statefs/"
FILES_${PN}-dbg += "/usr/lib/statefs/.debug/"
