SUMMARY = "Asteroid's compass app"
HOMEPAGE = "https://github.com/AsteroidOS/asteroid-compass.git"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=84dcc94da3adb52b53ae4fa38fe49e5d"

SRC_URI = "git://github.com/AsteroidOS/asteroid-compass.git;protocol=https"
SRCREV = "${AUTOREV}"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"
inherit qmake5

DEPENDS += "qml-asteroid"
RDEPENDS_${PN} += "qtsensors qtsensors-qmlplugins qtsensors-plugins"
