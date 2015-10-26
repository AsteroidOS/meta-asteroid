SUMMARY = "Nemomobile's statefs-providers"
HOMEPAGE = "https://git.merproject.org/mer-core/statefs-providers"
LICENSE = "LGPL-2.1+"
LIC_FILES_CHKSUM = "file://LICENSE;md5="

SRC_URI = "git://git.merproject.org/mer-core/statefs-providers.git;protocol=https"
SRCREV = "${AUTOREV}"
PR = "r1"
PV = "+git${SRCREV}"
S = "${WORKDIR}/git"

DEPENDS += "statefs boost"
inherit cmake_qt5

EXTRA_OECMAKE=" -DVERSION=x.x.x -DOE_QMAKE_PATH_EXTERNAL_HOST_BINS=${STAGING_DIR_NATIVE}/usr/bin/qt5/"
