SUMMARY = "Nemomobile's libresourceqt"
HOMEPAGE = "https://github.com/mer-packages/libresourceqt"
LICENSE = "LGPL-2.1-or-later"
LIC_FILES_CHKSUM = "file://COPYING;md5=4fbd65380cdd255951079008b364516c"

SRC_URI = "git://github.com/mer-packages/libresourceqt;protocol=https;branch=master \
    file://001-Disables_resourceqt-client_build.patch"
SRCREV = "4483fd800ab67c66d33ff30b28bd5c3137feec7a"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"

DEPENDS += " qtbase libresource dbus virtual/libgles2"
inherit qmake5 pkgconfig

B = "${WORKDIR}/git"

FILES:${PN}-dbg += "/usr/lib/libresourceqt-qt5-tests /usr/share"
