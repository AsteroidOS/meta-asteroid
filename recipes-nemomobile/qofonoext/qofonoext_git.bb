SUMMARY = "A library for accessing nemomobile specific ofono extensions, and a declarative plugin for it."
HOMEPAGE = "https://git.merproject.org/mer-core/libqofonoext"
LICENSE = "LGPL-2.1+"
LIC_FILES_CHKSUM = "file://src/qofonoext.cpp;beginline=1;endline=14;md5=e78738e9230b2e0f55eb7f63e3444df5"

SRC_URI = "git://git.merproject.org/mer-core/libqofonoext.git;protocol=https"
SRCREV = "f19e882d4f7084acfa8681e57fa284218525a3d3"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"

DEPENDS += "ofono qtbase libqofono qtsystems"
inherit qmake5

FILES_${PN} += "/usr/lib/qml/org/nemomobile/ofono/"
