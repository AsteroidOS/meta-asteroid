SUMMARY = "QML components for AsteroidOS"
HOMEPAGE = "https://github.com/AsteroidOS/qml-asteroid.git"
LICENSE = "LGPL-2.1-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=1702a92c723f09e3fab3583b165a8d90"

SRC_URI = "git://github.com/AsteroidOS/qml-asteroid.git;protocol=https;branch=master \
    file://0001-Fix-build-with-Qt6.patch \
    "
SRCREV = "${AUTOREV}"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"
inherit qt6-cmake pkgconfig

DEPENDS += "extra-cmake-modules qtdeclarative qtsvg qtvirtualkeyboard mapplauncherd-booster-qtcomponents qtdeclarative-native qt5compat"
RDEPENDS:${PN} += "asteroid-machine-config qtsvg-plugins qtvirtualkeyboard asteroid-icons-ion"

FILES:${PN} += "/usr/lib /usr/share/icons/asteroid/"
FILES:${PN}-dbg += "/usr/lib/qml/org/asteroid/controls/.debug/ /usr/lib/qml/QtQuick/Controls/Styles/Asteroid/.debug/"
FILES:${PN}-dev += "/usr/lib/mkspecs/ /usr/share/asteroidapp/cmake/ /usr/bin/asteroid-generate-desktop"

EXTRA_OECMAKE += "-DBUILD_WITH_QT6=ON"
