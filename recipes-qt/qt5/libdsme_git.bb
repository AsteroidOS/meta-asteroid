SUMMARY = "Nemomobile's libdsme."
HOMEPAGE = "https://github.com/nemomobile/libdsme.git"
LICENSE = "LGPL-2.1+"
LIC_FILES_CHKSUM = "file://COPYING;md5=2d5025d4aa3495befef8f17206a5b0a1"

DEPENDS += " glib-2.0 "

SRC_URI = "git://github.com/nemomobile/libdsme.git;protocol=https \
    file://001-Allows-custom-cflags.patch \
"
SRCREV = "${AUTOREV}"
PR = "r1"
PV = "+git${SRCREV}"
S = "${WORKDIR}/git"

do_install() {
	oe_runmake install DESTDIR=${D}
    rm -rf ${D}/opt
}
