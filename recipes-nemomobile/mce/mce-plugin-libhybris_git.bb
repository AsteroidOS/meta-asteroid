SUMMARY = "libhybris plugin for the Nemomobile's MCE."
HOMEPAGE = "https://github.com/nemomobile/mce-plugin-libhybris.git"
LICENSE = "LGPL-2.1-or-later"
LIC_FILES_CHKSUM = "file://COPYING;md5=4fbd65380cdd255951079008b364516c"

SRC_URI = "git://github.com/nemomobile/mce-plugin-libhybris.git;protocol=https;branch=master"
SRCREV = "2c48a3f1724b9e82acd13addb70f3201508c811a"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"

DEPENDS += "mce"

do_install() {
    oe_runmake install DESTDIR=${D}
}
