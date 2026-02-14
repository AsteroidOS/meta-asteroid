SUMMARY = "Qt and QML MPRIS interface and adaptor"
HOMEPAGE = "https://github.com/nemomobile/qtmpris"
LICENSE = "LGPL-2.1-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=5c936b15295e0f34fd6618c596808948"

SRC_URI = "git://github.com/nemomobile/qtmpris.git;protocol=https;branch=master"
SRCREV = "7251898353f1f5804c9480172ad7df88c4fe7eb6"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"
inherit qmake5 pkgconfig

DEPENDS += "qtdbusextended qtdeclarative"
RDEPENDS:${PN} += "qtdbusextended"

FILES:${PN} += "/usr/lib/qml/org/nemomobile/mpris"
FILES:${PN}-dev += "/usr/lib/mkspecs"
