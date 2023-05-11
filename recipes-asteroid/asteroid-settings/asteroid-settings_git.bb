SUMMARY = "Asteroid's system settings app"
HOMEPAGE = "https://github.com/AsteroidOS/asteroid-settings.git"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=84dcc94da3adb52b53ae4fa38fe49e5d"

SRC_URI = "git://github.com/AsteroidOS/asteroid-settings.git;protocol=https;branch=master"
SRCREV = "${AUTOREV}"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"
inherit cmake_qt5 pkgconfig

DEPENDS += "qml-asteroid asteroid-generate-desktop-native nemo-qml-plugin-systemsettings nemo-qml-plugin-dbus qttools-native qtdeclarative-native"
RDEPENDS:${PN} += "nemo-qml-plugin-systemsettings nemo-qml-plugin-dbus qtmultimedia-qmlplugins libconnman-qt5-qmlplugins"
FILES:${PN} += "/usr/share/translations/ ${libdir}/asteroid-settings.so"
