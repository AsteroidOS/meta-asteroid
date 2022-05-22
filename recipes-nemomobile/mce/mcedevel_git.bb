SUMMARY = "Nemomobile's MCE's development files."
HOMEPAGE = "https://github.com/sailfishos/mce-dev"
LICENSE = "LGPL-2.1+"
LIC_FILES_CHKSUM = "file://COPYING;md5=2d5025d4aa3495befef8f17206a5b0a1"

SRC_URI = "git://github.com/sailfishos/mce-dev.git;protocol=https;branch=master"
SRCREV = "5af012a1ac579d90aa5d44ce1cee6cc4cfe2b040"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"

ALLOW_EMPTY:${PN} = "1"

do_compile() {
}

do_install() {
    oe_runmake install 'DESTDIR=${D}' 'PCDIR=${libdir}/pkgconfig'
}
