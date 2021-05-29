SUMMARY = "sailfish access control, a thin wrapper around getuid and friends."
HOMEPAGE = "https://git.merproject.org/mer-core/sailfish-access-control"
LICENSE = "LGPL-2.1+"
LIC_FILES_CHKSUM = "file://glib/sailfishaccesscontrol.c;beginline=1;endline=17;md5=b6d1a1603875ba04da1967b348657dfa"

SRC_URI = "git://git.merproject.org/mer-core/sailfish-access-control.git;protocol=https"
SRCREV = "f858fede95624e119cf3a79927ce5bae11a15ef2"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"

DEPENDS += "glib-2.0"
inherit pkgconfig

do_compile() {
    oe_runmake -C glib
}

do_install_append() {
    oe_runmake -C glib install ROOT=${D}
}
