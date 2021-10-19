SUMMARY = "Asteroid's calculator app"
HOMEPAGE = "https://github.com/AsteroidOS/asteroid-calculator.git"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=84dcc94da3adb52b53ae4fa38fe49e5d"

SRC_URI = "git://github.com/AsteroidOS/asteroid-calculator.git;protocol=https"
SRCREV = "${AUTOREV}"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"
inherit cmake_qt5

DEPENDS += "qml-asteroid asteroid-generate-desktop-native qtdeclarative-native qttools-native"

do_install:append() {
    # This app only uses translations for the desktop shortcut.
    rm -rvf ${D}/usr/share/translations/
}
