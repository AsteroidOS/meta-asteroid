SUMMARY = "Qt and QML MPRIS interface and adaptor"
HOMEPAGE = "https://github.com/sailfishos/amber-mpris"
LICENSE = "LGPL-2.1-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=cdba88dcbc846ef65673f333281e882b"

SRC_URI = "git://github.com/sailfishos/amber-mpris.git;protocol=https;branch=master"
SRCREV = "0dc2c15104a13c16f3028cb9e73f1e4dc886f4d0"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"
inherit qt6-qmake pkgconfig

DEPENDS += "qtdeclarative"

FILES:${PN} += "/usr/lib/qml/Amber/Mpris"
FILES:${PN}-dev += "/usr/lib/mkspecs"
