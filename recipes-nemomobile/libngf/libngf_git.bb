SUMMARY = "Nemomobile's libngf"
HOMEPAGE = "https://github.com/nemomobile/libngf.git"
LICENSE = "LGPL-2.1+"
LIC_FILES_CHKSUM = "file://COPYING;md5=4fbd65380cdd255951079008b364516c"

SRC_URI = "git://github.com/nemomobile/libngf.git;protocol=https"
SRCREV = "${AUTOREV}"
PR = "r1"
PV = "+git${SRCREV}"
S = "${WORKDIR}/git"

DEPENDS += " glib-2.0 dbus dbus-glib "

inherit autotools pkgconfig
