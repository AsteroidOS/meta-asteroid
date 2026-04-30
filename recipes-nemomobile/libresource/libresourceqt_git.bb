SUMMARY = "Nemomobile's libresourceqt"
HOMEPAGE = "https://github.com/sailfishos/libresourceqt"
LICENSE = "LGPL-2.1-or-later"
LIC_FILES_CHKSUM = "file://COPYING;md5=4fbd65380cdd255951079008b364516c"

SRC_URI = "git://github.com/sailfishos/libresourceqt;protocol=https;branch=master"
SRCREV = "142b512f9de840bb7855415885cb6e8f1f09e08c"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"

DEPENDS += " qtbase libresource dbus virtual/libgles2"
inherit qt6-qmake pkgconfig

B = "${WORKDIR}/git"

FILES:${PN}-dbg += "/usr/lib/libresourceqt-qt6-tests /usr/share"
