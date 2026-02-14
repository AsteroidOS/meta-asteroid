SUMMARY = "Nemomobile's MCE's development files."
HOMEPAGE = "https://github.com/sailfishos/mce-dev"
LICENSE = "LGPL-2.1-or-later"
LIC_FILES_CHKSUM = "file://COPYING;md5=2d5025d4aa3495befef8f17206a5b0a1"

SRC_URI = "git://github.com/sailfishos/mce-dev.git;protocol=https;branch=master"
SRCREV = "f0a933c8c2c5a41c1c81c11220d8ca0d7b5b53c4"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"

ALLOW_EMPTY:${PN} = "1"

do_compile() {
}

do_install() {
    oe_runmake install 'DESTDIR=${D}' 'PCDIR=${libdir}/pkgconfig'
}
