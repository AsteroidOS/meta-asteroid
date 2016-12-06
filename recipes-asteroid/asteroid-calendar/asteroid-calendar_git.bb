SUMMARY = "Asteroid's calendar app"
HOMEPAGE = "https://github.com/AsteroidOS/asteroid-calendar.git"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=84dcc94da3adb52b53ae4fa38fe49e5d"

SRC_URI = "git://github.com/AsteroidOS/asteroid-calendar.git;protocol=https"
SRCREV = "70de1d63ed3c77da246af9df7293ba26ee1bc8f0"
PR = "r1"
PV = "+git${SRCREV}"
S = "${WORKDIR}/git"
inherit qmake5

DEPENDS += "qml-asteroid mapplauncherd-booster-qtcomponents nemo-qml-plugin-calendar qtvirtualkeyboard"
RDEPENDS_${PN} += "nemo-qml-plugin-calendar qtvirtualkeyboard"
