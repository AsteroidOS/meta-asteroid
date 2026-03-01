SUMMARY = "Nemomobile's libresourceqt"
HOMEPAGE = "https://github.com/sailfishos/libresourceqt"
LICENSE = "LGPL-2.1-or-later"
LIC_FILES_CHKSUM = "file://COPYING;md5=4fbd65380cdd255951079008b364516c"

SRC_URI = "git://github.com/sailfishos/libresourceqt;protocol=https;branch=master"
SRCREV = "a7f6ef9bdf23c1333c119c970c8cb15a870fd879"
PR = "r1"
PV = "+git${SRCPV}"

DEPENDS += " qtbase libresource dbus virtual/libgles2"
inherit qmake5 pkgconfig

B = "${UNPACKDIR}/${BP}"

FILES:${PN}-dbg += "/usr/lib/libresourceqt-qt5-tests /usr/share"
