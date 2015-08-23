SUMMARY = "libhybris plugin for the Nemomobile's MCE."
HOMEPAGE = "https://github.com/nemomobile/mce-plugin-libhybris.git"
LICENSE = "LGPL-2.1+"
LIC_FILES_CHKSUM = "file://COPYING;md5=4fbd65380cdd255951079008b364516c"

SRC_URI = "git://github.com/nemomobile/mce-plugin-libhybris.git;protocol=https"
SRCREV = "${AUTOREV}"
PR = "r1"
PV = "+git${SRCREV}"
S = "${WORKDIR}/git"

DEPENDS += "mce"

do_install() {
    oe_runmake install DESTDIR=${D}
}
