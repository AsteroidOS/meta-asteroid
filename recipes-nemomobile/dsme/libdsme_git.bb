SUMMARY = "Nemomobile's libdsme."
HOMEPAGE = "https://github.com/sailfishos/libdsme"
LICENSE = "LGPL-2.1-or-later"
LIC_FILES_CHKSUM = "file://COPYING;md5=2d5025d4aa3495befef8f17206a5b0a1"

DEPENDS += " glib-2.0 libcheck pkgconfig-native"

SRC_URI = "git://github.com/sailfishos/libdsme.git;protocol=https;branch=master \
    file://001-Allows-custom-cflags.patch"
SRCREV = "67e57c5e90e37d4a53cf3ea4dae028444c62c8e8"
PR = "r1"
PV = "+git${SRCPV}"

do_compile:prepend () {
    export CFLAGS="$CFLAGS -fPIC"
}

do_install() {
	oe_runmake install DESTDIR=${D}
}

FILES:${PN}-dbg += "/opt"
