SUMMARY = "Asteroid's timer app"
HOMEPAGE = "https://github.com/AsteroidOS/asteroid-timer.git"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=84dcc94da3adb52b53ae4fa38fe49e5d"

SRC_URI = "git://github.com/AsteroidOS/asteroid-timer.git;protocol=https;branch=1.0"
SRCREV = "25a27817e082de06e42cf2497cca552fdf4ae5bc"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"
inherit qmake5

DEPENDS += "qml-asteroid nemo-qml-plugin-dbus nemo-keepalive"
RDEPENDS_${PN} += "nemo-keepalive"
