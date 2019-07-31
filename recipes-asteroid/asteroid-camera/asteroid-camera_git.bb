SUMMARY = "Asteroid's camera app"
HOMEPAGE = "https://github.com/AsteroidOS/asteroid-camera.git"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=84dcc94da3adb52b53ae4fa38fe49e5d"

SRC_URI = "git://github.com/AsteroidOS/asteroid-camera.git;protocol=https"
SRCREV = "${AUTOREV}"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"
inherit qmake5

DEPENDS += "qml-asteroid qttools-native qtdeclarative-native qtmultimedia"
RDEPENDS_${PN} += "qtmultimedia"
FILES_${PN} += "/usr/share/translations/"
