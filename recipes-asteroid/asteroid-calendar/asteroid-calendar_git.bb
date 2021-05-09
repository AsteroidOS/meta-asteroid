SUMMARY = "Asteroid's calendar app"
HOMEPAGE = "https://github.com/AsteroidOS/asteroid-calendar.git"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=84dcc94da3adb52b53ae4fa38fe49e5d"

SRC_URI = "git://github.com/AsteroidOS/asteroid-calendar.git;protocol=https"
SRCREV = "${AUTOREV}"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"
inherit cmake_qt5

DEPENDS += "qml-asteroid asteroid-generate-desktop-native nemo-qml-plugin-calendar qttools-native qtdeclarative-native"
RDEPENDS_${PN} += "nemo-qml-plugin-calendar"
FILES_${PN} += "/usr/share/translations/"
