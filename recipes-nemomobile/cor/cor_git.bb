SUMMARY = "Nemomobile's Cor"
HOMEPAGE = "https://github.com/sailfishos/cor"
LICENSE = "LGPL-2.1+"
LIC_FILES_CHKSUM = "file://COPYING;md5=d2c621b4dd653efb7cbad641e0a30c59"

SRC_URI = "git://github.com/sailfishos/cor.git;protocol=https \
           file://0001-Fix-error-with-GCC-6.patch \
           file://0002-Add-a-missing-header-include.patch"
SRCREV = "64b0168577372cb7e4e12a40fefd97746188b274"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"

inherit cmake

DEPENDS += "udev tut-dev"
EXTRA_OECMAKE=" -DVERSION=0.1.17"

FILES:${PN}-dbg += "/opt /usr/lib/cmake/cor"
