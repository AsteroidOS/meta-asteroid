SUMMARY = "Asteroid's camera app"
HOMEPAGE = "https://github.com/AsteroidOS/asteroid-camera.git"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=84dcc94da3adb52b53ae4fa38fe49e5d"

SRC_URI = "git://github.com/AsteroidOS/asteroid-camera.git;protocol=https;branch=master"
SRCREV = "${AUTOREV}"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"
inherit cmake_qt5

DEPENDS += "qml-asteroid asteroid-generate-desktop-native qttools-native qtdeclarative-native qtmultimedia"
RDEPENDS:${PN} += "qtmultimedia"

do_install:append() {
    # This app only uses translations for the desktop shortcut.
    rm -rvf ${D}/usr/share/translations/
}
