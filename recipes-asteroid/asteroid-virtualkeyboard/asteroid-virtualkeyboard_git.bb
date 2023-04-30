SUMMARY = "Asteroid's virtual keyboard"
HOMEPAGE = "https://github.com/beroset/asteroid-virtualkeyboard.git"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"

SRC_URI = "git://github.com/AsteroidOS/asteroid-virtualkeyboard.git;protocol=https;branch=main"
SRCREV = "${AUTOREV}"
PV = "1.0+git${SRCPV}"
S = "${WORKDIR}/git"

inherit cmake_qt5 

DEPENDS += "qml-asteroid qttools-native qtdeclarative-native"

FILES:${PN} += "/usr/lib/qml/QtQuick/VirtualKeyboard/Styles/watch/"
