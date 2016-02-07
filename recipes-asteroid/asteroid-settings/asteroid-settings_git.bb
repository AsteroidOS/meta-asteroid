SUMMARY = "Asteroid's system settings app"
HOMEPAGE = "https://github.com/AsteroidOS/asteroid-settings.git"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=84dcc94da3adb52b53ae4fa38fe49e5d"

SRC_URI = "git://github.com/AsteroidOS/asteroid-settings.git;protocol=https"
SRCREV = "${AUTOREV}"
PR = "r1"
PV = "+git${SRCREV}"
S = "${WORKDIR}/git"
inherit qmake5

DEPENDS += "qml-asteroid nemo-qml-plugin-systemsettings nemo-qml-plugin-dbus qtconnectivity mapplauncherd-booster-qtcomponents"
RDEPENDS_${PN} += "qtconnectivity-qmlplugins nemo-qml-plugin-systemsettings nemo-qml-plugin-dbus"
