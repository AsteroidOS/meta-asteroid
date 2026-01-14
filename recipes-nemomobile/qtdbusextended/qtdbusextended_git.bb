SUMMARY = "Extended DBus for Qt"
HOMEPAGE = "https://github.com/nemomobile/qtdbusextended"
LICENSE = "LGPL-2.1-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=9851ce31b8dbc090eecd6cec46a8bf62"

SRC_URI = "git://github.com/nemomobile/qtdbusextended.git;protocol=https;branch=master \
    file://0001-Use-variant-when-setting-properties.patch \
"
SRCREV = "34971431233dc408553245001148d34a09836df1"
PR = "r1"
PV = "+git${SRCPV}"
inherit qmake5

DEPENDS += "qtbase"
RDEPENDS:${PN} += "qtbase"

FILES:${PN}-dev += "/usr/lib/mkspecs"
