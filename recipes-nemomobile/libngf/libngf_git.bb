SUMMARY = "Nemomobile's libngf"
HOMEPAGE = "https://git.merproject.org/mer-core/libngf"
LICENSE = "LGPL-2.1+"
LIC_FILES_CHKSUM = "file://COPYING;md5=4fbd65380cdd255951079008b364516c"

SRC_URI = "git://git.merproject.org/mer-core/libngf.git;protocol=https"
SRCREV = "6ec854723d6d48b6499d4c096adbd2101439b855"
PR = "r1"
PV = "+git${SRCREV}"
S = "${WORKDIR}/git"

DEPENDS += "glib-2.0 dbus dbus-glib"
RDEPENDS_${PN} += "ngfd"

inherit autotools pkgconfig
