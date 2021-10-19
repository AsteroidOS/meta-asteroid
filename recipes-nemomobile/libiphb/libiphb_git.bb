SUMMARY = "Nemomobile's libiphb."
HOMEPAGE = "https://github.com/sailfishos/libiphb"
LICENSE = "LGPL-2.1+"
LIC_FILES_CHKSUM = "file://COPYING;md5=4fbd65380cdd255951079008b364516c"

SRC_URI = "git://github.com/sailfishos/libiphb.git;protocol=https"

SRCREV = "5db3ab70268933369fbfc90e8ca3fd00b774c66b"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"

DEPENDS += " mcedevel glib-2.0 dbus-glib dbus libdsme "
inherit autotools pkgconfig

B = "${WORKDIR}/git"

FILES:${PN}-dbg += "/opt"
