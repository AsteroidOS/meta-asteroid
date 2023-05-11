SUMMARY = "Asteroid's heart rate monitor app"
HOMEPAGE = "https://github.com/AsteroidOS/asteroid-hrm.git"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=84dcc94da3adb52b53ae4fa38fe49e5d"

SRC_URI = "git://github.com/AsteroidOS/asteroid-hrm.git;protocol=https;branch=master"
SRCREV = "${AUTOREV}"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"
inherit cmake_qt5

DEPENDS += "qml-asteroid asteroid-generate-desktop-native qtsensors qttools-native qtdeclarative-native"
FILES:${PN} += "/usr/share/translations/ ${libdir}/asteroid-hrm.so"
