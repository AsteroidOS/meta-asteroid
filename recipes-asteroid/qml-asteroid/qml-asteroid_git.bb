SUMMARY = "QML components for AsteroidOS"
HOMEPAGE = "https://github.com/AsteroidOS/qml-asteroid.git"
LICENSE = "LGPL-2.1"
LIC_FILES_CHKSUM = "file://COPYING;md5=1702a92c723f09e3fab3583b165a8d90"

SRC_URI = "git://github.com/AsteroidOS/qml-asteroid.git;protocol=https"
SRC_URI_append_qemux86 = " file://0001-Spinners-Disable-shaders-which-cause-all-sorts-of-pr.patch"
SRCREV = "${AUTOREV}"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"
inherit qmake5

DEPENDS += "asteroid-machine-config qtdeclarative qtsvg qtvirtualkeyboard mlite mapplauncherd-booster-qtcomponents qtdeclarative-native"
RDEPENDS_${PN} += "asteroid-machine-config qtsvg-plugins qtvirtualkeyboard asteroid-icons-ion"

FILES_${PN} += "/usr/lib /usr/share/icons/asteroid/"
FILES_${PN}-dbg += "/usr/lib/qml/org/asteroid/controls/.debug/ /usr/lib/qml/QtQuick/Controls/Styles/Asteroid/.debug/"
FILES_${PN}-dev += "/usr/lib/mkspecs/"
