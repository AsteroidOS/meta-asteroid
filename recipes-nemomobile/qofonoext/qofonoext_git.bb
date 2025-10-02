SUMMARY = "A library for accessing nemomobile specific ofono extensions, and a declarative plugin for it."
HOMEPAGE = "https://github.com/sailfishos/libqofonoext"
LICENSE = "LGPL-2.1-or-later"
LIC_FILES_CHKSUM = "file://LICENSE.LGPL;md5=05ec901d0fb5d274579e113de1fea001"

SRC_URI = "git://github.com/sailfishos/libqofonoext.git;protocol=https;branch=master"
SRCREV = "1893185f2124ef5487fc684f9e69237b8551f4c4"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"

DEPENDS += "ofono qtbase libqofono qtsystems"
inherit qmake5 pkgconfig

FILES:${PN} += "/usr/lib/qml/org/nemomobile/ofono/"
