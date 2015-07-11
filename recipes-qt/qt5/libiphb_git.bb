SUMMARY = "Nemomobile's libiphb."
HOMEPAGE = "https://github.com/nemomobile/libiphb.git"
LICENSE = "LGPL-2.1+"
LIC_FILES_CHKSUM = "file://COPYING;md5=4fbd65380cdd255951079008b364516c"

SRC_URI = "git://github.com/nemomobile/libiphb.git;protocol=https"

SRCREV = "${AUTOREV}"
PR = "r1"
PV = "+git${SRCREV}"
S = "${WORKDIR}/git"

DEPENDS += " mcedevel glib-2.0 dbus-glib dbus libdsme "
inherit autotools pkgconfig

B = "${WORKDIR}/git"

do_install_append() {
    rm -rf ${D}/opt
}

