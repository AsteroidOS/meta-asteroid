SUMMARY = "mer-hybris libnciplugin"
HOMEPAGE = "https://github.com/mer-hybris/libnciplugin"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=c049b5654a2ea5d8d3b45c4416abe4ae"

SRC_URI = "git://github.com/mer-hybris/libnciplugin.git;protocol=https;branch=master \
           file://0001-Makefile-Allow-for-CC-to-be-overridden.patch \
           "
SRCREV = "3b844682112733be1b1d6d2bc745dab40f03b152"
PR = "r1"
PV = "+git${SRCPV}"
B = "${S}"

DEPENDS = "libgbinder glib-2.0 libglibutil nfcd libncicore"

EXTRA_OEMAKE = "KEEP_SYMBOLS=1"

do_install() {
	oe_runmake install DESTDIR=${D}
	oe_runmake install-dev DESTDIR=${D}
}

inherit pkgconfig
