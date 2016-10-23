SUMMARY = "Mer's Qt5 fork of KDE PIM 4's core component"
HOMEPAGE = "https://git.merproject.org/mer-core/kcalcore"
LICENSE = "LGPL-2.1"
LIC_FILES_CHKSUM = "file://COPYING.LIB;md5=2d5025d4aa3495befef8f17206a5b0a1"

SRC_URI = "git://git.merproject.org/mer-core/kcalcore.git;protocol=https \
           file://0001-Removes-unused-reference-to-a-host-include-directory.patch"
SRCREV = "7db97a571b828e671cfa2ee851893d1c5a2891e3"
PR = "r1"
PV = "+git${SRCREV}"
S = "${WORKDIR}/git"
inherit qmake5

DEPENDS += "qtbase timed libical"
