SUMMARY = "Glacier components for Nemomobile, based on QtQuickControls"
HOMEPAGE = "https://github.com/nemomobile/qtquickcontrols-nemo.git"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING.LIB;md5=4193e7f1d47a858f6b7c0f1ee66161de"

SRC_URI = "git://github.com/nemomobile/qtquickcontrols-nemo.git;protocol=https"
SRCREV = "${AUTOREV}"
PR = "r1"
PV = "+git${SRCREV}"
S = "${WORKDIR}/git"
inherit qmake5

DEPENDS += "qtquickcontrols"
RDEPENDS_${PN} += "qtquickcontrols-qmlplugins"
