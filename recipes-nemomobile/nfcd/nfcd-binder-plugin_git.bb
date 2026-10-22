SUMMARY = "Nemomobile's NFC daemon's hwbinder plugin"
HOMEPAGE = "https://github.com/mer-hybris/nfcd-binder-plugin"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://src/plugin.h;beginline=1;endline=31;md5=ba484c1af8c917210c60e63b7b499327"

SRC_URI = "git://github.com/mer-hybris/nfcd-binder-plugin.git;protocol=https;branch=master \
           file://0001-Makefile-Allow-for-CC-to-be-overridden.patch \
           file://0002-Run-coreInitialized-and-prediscover-before-reporting-.patch \
           "
SRCREV = "ee270922a39d3730226936d7e78896dd508400be"
PR = "r1"
PV = "+git${SRCPV}"
B = "${S}"

DEPENDS = "libgbinder glib-2.0 libglibutil nfcd libncicore libnciplugin"

do_install() {
	oe_runmake install DESTDIR=${D}
}

inherit pkgconfig

FILES:${PN} += "${libdir}/nfcd/plugins/binder.so"
