SUMMARY = "QML components for AsteroidOS"
HOMEPAGE = "https://github.com/AsteroidOS/qml-asteroid.git"
LICENSE = "LGPL-2.1-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=1702a92c723f09e3fab3583b165a8d90"

SRC_URI = "git://github.com/AsteroidOS/qml-asteroid.git;protocol=https;branch=master"
SRCREV = "7eb92e63e4a0b8357fb9ab68babb710252e5ba77"
PV = "2.0+63+git"
PE = "1"
PR = "r1"
inherit qt6-cmake pkgconfig

DEPENDS += "extra-cmake-modules qtdeclarative qtsvg qtvirtualkeyboard mapplauncherd-booster-asteroid qtdeclarative-native qtshadertools qtshadertools-native qt5compat"
RDEPENDS:${PN} += "asteroid-machine-config qtsvg-plugins qtvirtualkeyboard asteroid-icons-ion qtimageformats-plugins"

FILES:${PN} += "/usr/lib /usr/share/icons/asteroid/"
FILES:${PN}-dbg += "/usr/lib/qml/org/asteroid/controls/.debug/ /usr/lib/qml/QtQuick/Controls/Styles/Asteroid/.debug/"
FILES:${PN}-dev += "/usr/lib/mkspecs/ /usr/share/asteroidapp/cmake/ /usr/bin/asteroid-generate-desktop"
