SUMMARY = "Nemomobile's libngf"
HOMEPAGE = "https://git.merproject.org/mer-core/libngf"
LICENSE = "LGPL-2.1+"
LIC_FILES_CHKSUM = "file://COPYING;md5=4fbd65380cdd255951079008b364516c"

SRC_URI = "git://git.merproject.org/mer-core/libngf.git;protocol=https"
SRCREV = "06be88da245bf5eed6880e871f65d35115d05674"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"

DEPENDS += "glib-2.0 dbus dbus-glib libcheck"
RDEPENDS_${PN} += "ngfd"

inherit autotools pkgconfig
