SUMMARY = "mer-hybris libncicore"
HOMEPAGE = "https://github.com/mer-hybris/libncicore"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=91469899584792fd3bac502adbdf8225"

SRC_URI = "git://github.com/mer-hybris/libncicore.git;protocol=https;branch=master \
           file://0001-Makefile-Allow-for-CC-to-be-overridden.patch \
           "
SRCREV = "7063aead7fb89938d5c248c1695f2dd657341da0"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"

DEPENDS += "glib-2.0 libglibutil glib-2.0-native"

EXTRA_OEMAKE = "KEEP_SYMBOLS=1"

do_install() {
	oe_runmake install DESTDIR=${D}
	oe_runmake install-dev DESTDIR=${D}
}

inherit pkgconfig
