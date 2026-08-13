SUMMARY = "Geoclue 0 plugin for QtPositioning Qt6"
HOMEPAGE = "https://github.com/beroset/qtpositioning-geoclue"
LICENSE = "LGPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e6a600fd5e1d9cbde2d983680233ad02"
SRC_URI = "git://github.com/beroset/qtpositioning-geoclue.git;protocol=https;branch=main"
SRCREV = "c701fde6184622a28d3dbf67b8817cc05efcad3d"
S = "${WORKDIR}/git"
DEPENDS = "qtbase qtpositioning"
inherit qt6-cmake pkgconfig

FILES:${PN} += "/usr/lib/"

