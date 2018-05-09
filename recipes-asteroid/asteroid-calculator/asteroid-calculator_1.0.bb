SUMMARY = "Asteroid's calculator app"
HOMEPAGE = "https://github.com/AsteroidOS/asteroid-calculator.git"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=84dcc94da3adb52b53ae4fa38fe49e5d"

SRC_URI = "git://github.com/AsteroidOS/asteroid-calculator.git;protocol=https;branch=1.0"
SRCREV = "a963a97c5328b375e70b449dc8e34a268367c61a"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"
inherit qmake5

DEPENDS += "qml-asteroid"
