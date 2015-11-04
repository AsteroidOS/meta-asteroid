SUMMARY = "Asteroid's system settings app"
HOMEPAGE = "https://github.com/AsteroidOS/asteroid-settings.git"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=2c1c00f9d3ed9e24fa69b932b7e7aff2"

SRC_URI = "git://github.com/AsteroidOS/asteroid-settings.git;protocol=https"
SRCREV = "${AUTOREV}"
PR = "r1"
PV = "+git${SRCREV}"
S = "${WORKDIR}/git"
inherit qmake5

DEPENDS += "qtquickcontrols-nemo nemo-qml-plugin-systemsettings"
