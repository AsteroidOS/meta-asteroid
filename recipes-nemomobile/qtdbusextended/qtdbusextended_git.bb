SUMMARY = "Extended DBus for Qt"
HOMEPAGE = "https://github.com/nemomobile/qtdbusextended"
LICENSE = "LGPL-2.1"
LIC_FILES_CHKSUM = "file://COPYING;md5=9851ce31b8dbc090eecd6cec46a8bf62"

SRC_URI = "git://github.com/nemomobile/qtdbusextended.git;protocol=https"
SRCREV = "34971431233dc408553245001148d34a09836df1"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"
inherit qmake5

DEPENDS += "qtbase"
RDEPENDS_${PN} += "qtbase"

FILES_${PN}-dev += "/usr/lib/mkspecs"
