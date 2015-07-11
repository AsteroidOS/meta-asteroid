SUMMARY = "Nemomobile's libresource"
HOMEPAGE = "https://github.com/mer-packages/libresource"
LICENSE = "LGPL-2.1+"
LIC_FILES_CHKSUM = "file://COPYING;md5=4fbd65380cdd255951079008b364516c"

SRC_URI = "git://github.com/mer-packages/libresource;protocol=https"
SRCREV = "${AUTOREV}"
PR = "r1"
PV = "+git${SRCREV}"
S = "${WORKDIR}/git"

DEPENDS += " glib-2.0 dbus-glib dbus"
inherit autotools pkgconfig
