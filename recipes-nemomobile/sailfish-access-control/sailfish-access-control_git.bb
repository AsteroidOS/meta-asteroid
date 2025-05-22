SUMMARY = "sailfish access control, a thin wrapper around getuid and friends."
HOMEPAGE = "https://git.merproject.org/mer-core/sailfish-access-control"
LICENSE = "LGPL-2.1-or-later"
LIC_FILES_CHKSUM = "file://glib/sailfishaccesscontrol.c;beginline=1;endline=17;md5=b6d1a1603875ba04da1967b348657dfa"

SRC_URI = "git://github.com/sailfishos/sailfish-access-control.git;protocol=https;branch=master"
SRCREV = "7b3979d8358e46127859eef05c1dc67729e36e34"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"

DEPENDS += "glib-2.0"
inherit pkgconfig

do_compile() {
    oe_runmake -C glib
}

do_install:append() {
    oe_runmake -C glib install ROOT=${D}
}
