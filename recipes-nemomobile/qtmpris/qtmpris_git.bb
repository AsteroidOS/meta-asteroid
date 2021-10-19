SUMMARY = "Qt and QML MPRIS interface and adaptor"
HOMEPAGE = "https://github.com/nemomobile/qtmpris"
LICENSE = "LGPL-2.1"
LIC_FILES_CHKSUM = "file://COPYING;md5=5c936b15295e0f34fd6618c596808948"

SRC_URI = "git://github.com/nemomobile/qtmpris.git;protocol=https"
SRCREV = "62c55e43dad6a479439ada609741ebebc4adaf23"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"
inherit qmake5

DEPENDS += "qtdbusextended qtdeclarative"
RDEPENDS:${PN} += "qtdbusextended"

FILES:${PN} += "/usr/lib/qml/org/nemomobile/mpris"
FILES:${PN}-dev += "/usr/lib/mkspecs"
