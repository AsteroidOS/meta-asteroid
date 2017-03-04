SUMMARY = "Qt and QML MPRIS interface and adaptor"
HOMEPAGE = "https://github.com/nemomobile/qtmpris"
LICENSE = "LGPL-2.1"
LIC_FILES_CHKSUM = "file://COPYING;md5=5c936b15295e0f34fd6618c596808948"

SRC_URI = "git://github.com/nemomobile/qtmpris.git;protocol=https"
SRCREV = "4e2881b8ce6b4de837f4c827a8dc9e86b222e1a6"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"
inherit qmake5

DEPENDS += "qtdbusextended qtdeclarative"
RDEPENDS_${PN} += "qtdbusextended"

FILES_${PN} += "/usr/lib/qml/org/nemomobile/mpris"
FILES_${PN}-dev += "/usr/lib/mkspecs"
