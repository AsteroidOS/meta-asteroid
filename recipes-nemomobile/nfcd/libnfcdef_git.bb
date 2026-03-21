SUMMARY = "Library for parsing and building NFC Data Exchange Format (NDEF) messages"
HOMEPAGE = "https://github.com/sailfishos/libnfcdef"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=df51399d0baac2e00f462b7f8acc0812"

SRC_URI = "git://github.com/sailfishos/libnfcdef.git;protocol=https;branch=master \
           file://0001-Fix-build.patch \
           "
SRCREV = "2f4d115c977919de74fbf1ab30ce8d43b1d7ed32"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"

EXTRA_OEMAKE = "KEEP_SYMBOLS=1"

DEPENDS = "glib-2.0 libglibutil"

do_compile:append() {
    oe_runmake release
}

do_install() {
    oe_runmake install install-dev DESTDIR=${D}
}

inherit pkgconfig
