SUMMARY = "Mer's Qt5 fork of KDE PIM 4's core component"
HOMEPAGE = "https://github.com/sailfishos/kcalcore"
LICENSE = "LGPL-2.1-only"
LIC_FILES_CHKSUM = "file://COPYING.LIB;md5=2d5025d4aa3495befef8f17206a5b0a1"

SRC_URI = "git://github.com/sailfishos/kcalcore.git;protocol=https;branch=master \
        file://0001-Removes-unused-reference-to-a-host-include-directory.patch \
        file://0002-Disable-tests.patch"
SRCREV = "2c6873c0478b87d54a84c3c3f0e9aead262b9d9d"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"
inherit qmake5

DEPENDS += "qtbase timed libical bison-native"
