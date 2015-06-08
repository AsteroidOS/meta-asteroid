SUMMARY = "Nemomobile's libresourceqt"
HOMEPAGE = "https://github.com/mer-packages/libresourceqt"
LICENSE = "LGPL-2.1+"
LIC_FILES_CHKSUM = "file://COPYING;md5=4fbd65380cdd255951079008b364516c"

SRC_URI = "git://github.com/mer-packages/libresourceqt;protocol=https \
    file://001-Disables_resourceqt-client_build.patch"
SRCREV = "${AUTOREV}"
PR = "r1"
PV = "+git${SRCREV}"
S = "${WORKDIR}/git"

DEPENDS += " qtbase libresource dbus virtual/libgles2"
inherit qmake5

B = "${WORKDIR}/git"
