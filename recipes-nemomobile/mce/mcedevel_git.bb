SUMMARY = "Nemomobile's MCE's development files."
HOMEPAGE = "https://git.merproject.org/mer-core/mce-dev"
LICENSE = "LGPL-2.1+"
LIC_FILES_CHKSUM = "file://COPYING;md5=2d5025d4aa3495befef8f17206a5b0a1"

SRC_URI = "git://git.merproject.org/mer-core/mce-dev.git;protocol=https"
SRCREV = "${AUTOREV}"
PR = "r1"
PV = "+git${SRCREV}"
S = "${WORKDIR}/git"

do_compile() {
}

do_install() {
    install -d ${D}/usr/include/mce/
    cp include/mce/* ${D}/usr/include/mce/

    install -d ${D}/usr/lib/pkgconfig/
    cp mce.pc ${D}/usr/lib/pkgconfig/
}
