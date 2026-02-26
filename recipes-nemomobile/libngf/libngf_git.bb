SUMMARY = "Nemomobile's libngf"
HOMEPAGE = "https://github.com/sailfishos/libngf"
LICENSE = "LGPL-2.1-or-later"
LIC_FILES_CHKSUM = "file://COPYING;md5=4fbd65380cdd255951079008b364516c"

SRC_URI = "git://github.com/sailfishos/libngf.git;protocol=https;branch=master \
        file://0001-Disable-tests.patch"
SRCREV = "89ab179ea85ccd8202a0dbac119855f5f1321163"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"

DEPENDS += "glib-2.0 dbus dbus-glib libcheck"
RDEPENDS:${PN} += "ngfd"

inherit autotools pkgconfig
