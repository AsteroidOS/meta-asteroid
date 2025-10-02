SUMMARY = "Nemomobile's libiphb."
HOMEPAGE = "https://github.com/sailfishos/libiphb"
LICENSE = "LGPL-2.1-or-later"
LIC_FILES_CHKSUM = "file://COPYING;md5=4fbd65380cdd255951079008b364516c"

SRC_URI = "gitsm://github.com/sailfishos/libiphb.git;protocol=https;branch=master"

SRCREV = "69f059da35fdd7aa72e38a5f7c596631a2f839cc"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"

DEPENDS += " mcedevel glib-2.0 dbus-glib dbus libdsme "
inherit autotools pkgconfig

B = "${WORKDIR}/git"

FILES:${PN}-dbg += "/opt"
