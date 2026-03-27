SUMMARY = "mer-hybris libncicore"
HOMEPAGE = "https://github.com/mer-hybris/libncicore"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=8dca037da60041e7ec2349c7aedb18c1"

SRC_URI = "git://github.com/mer-hybris/libncicore.git;protocol=https;branch=master \
           file://0001-Makefile-Allow-for-CC-to-be-overridden.patch \
           "
SRCREV = "7c4e1a8a743bbd713e684a824442f663cadb7a83"
PR = "r1"
PV = "+git${SRCPV}"

DEPENDS += "glib-2.0 libglibutil glib-2.0-native"

EXTRA_OEMAKE = "KEEP_SYMBOLS=1"

do_install() {
	oe_runmake install DESTDIR=${D}
	oe_runmake install-dev DESTDIR=${D}
}

inherit pkgconfig
