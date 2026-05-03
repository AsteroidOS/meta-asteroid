SUMMARY = "A library for accessing nemomobile specific ofono extensions, and a declarative plugin for it."
HOMEPAGE = "https://github.com/sailfishos/libqofonoext"
LICENSE = "LGPL-2.1-or-later"
LIC_FILES_CHKSUM = "file://LICENSE.LGPL;md5=05ec901d0fb5d274579e113de1fea001"

SRC_URI = "git://github.com/sailfishos/libqofonoext.git;protocol=https;branch=master"
SRCREV = "7a0e704f8a6f2ccac4e945103574ab07c9cb7e2a"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"

DEPENDS += "ofono qtbase libqofono"
inherit qt6-cmake pkgconfig

FILES:${PN} += "/usr/lib/qml/org/nemomobile/ofono/"
