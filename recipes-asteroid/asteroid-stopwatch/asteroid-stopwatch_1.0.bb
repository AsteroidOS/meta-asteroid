SUMMARY = "Asteroid's stopwatch app"
HOMEPAGE = "https://github.com/AsteroidOS/asteroid-stopwatch.git"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=84dcc94da3adb52b53ae4fa38fe49e5d"

SRC_URI = "git://github.com/AsteroidOS/asteroid-stopwatch.git;protocol=https;branch=1.0"
SRCREV = "d78a4dfa7fc18ceb42a58c28dcc399e02647187d"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"
inherit qmake5

DEPENDS += "qml-asteroid"
