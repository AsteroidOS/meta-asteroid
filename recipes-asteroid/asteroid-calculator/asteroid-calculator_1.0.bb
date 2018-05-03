SUMMARY = "Asteroid's calculator app"
HOMEPAGE = "https://github.com/AsteroidOS/asteroid-calculator.git"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=84dcc94da3adb52b53ae4fa38fe49e5d"

SRC_URI = "git://github.com/AsteroidOS/asteroid-calculator.git;protocol=https;branch=1.0"
SRCREV = "5fa146c46d0041cfd5ea495df7190f3281b60ae7"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"
inherit qmake5

DEPENDS += "qml-asteroid"
