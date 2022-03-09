SUMMARY = "A 2048 like game for AsteroidOS"
HOMEPAGE = "https://github.com/AsteroidOS/asteroid-diamonds.git"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"

SRC_URI = "git://github.com/AsteroidOS/asteroid-diamonds.git;protocol=https"
SRCREV = "${AUTOREV}"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"
inherit cmake_qt5

FILES:${PN} += "/usr/share/icons/asteroid/"
FILES:${PN} += "/usr/share/translations/"

DEPENDS += "qml-asteroid asteroid-generate-desktop-native qttools-native qtdeclarative-native"
