SUMMARY = "mer-hybris libnciplugin"
HOMEPAGE = "https://github.com/mer-hybris/libnciplugin"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=98cc3a1c8b4816ed2d8984676c8edaa8"

SRC_URI = "git://github.com/mer-hybris/libnciplugin.git;protocol=https;branch=master \
           file://0001-Makefile-Allow-for-CC-to-be-overridden.patch \
           "
SRCREV = "25d15f229f8db462d6f9ea884560918c14739b84"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"
B = "${S}"

DEPENDS = "libgbinder glib-2.0 libglibutil nfcd libncicore"

EXTRA_OEMAKE = "KEEP_SYMBOLS=1"

do_install() {
	oe_runmake install DESTDIR=${D}
	oe_runmake install-dev DESTDIR=${D}
}

inherit pkgconfig
