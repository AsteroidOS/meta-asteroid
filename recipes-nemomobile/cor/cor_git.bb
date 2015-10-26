SUMMARY = "Nemomobile's Cor"
HOMEPAGE = "https://git.merproject.org/mer-core/cor"
LICENSE = "LGPL-2.1+"
LIC_FILES_CHKSUM = "file://COPYING;md5=d2c621b4dd653efb7cbad641e0a30c59"

SRC_URI = "git://git.merproject.org/mer-core/cor.git;protocol=https"
SRCREV = "${AUTOREV}"
PR = "r1"
PV = "+git${SRCREV}"
S = "${WORKDIR}/git"

inherit cmake

DEPENDS += "udev tut-dev"
EXTRA_OECMAKE=" -DVERSION=0.1.17"

FILES_${PN}-dbg += "/opt /usr/lib/cmake/cor"
