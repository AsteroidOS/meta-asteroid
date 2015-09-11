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

FILES_${PN} += "/usr/lib/qt5"
FILES_${PN}-dbg += "/usr/lib/qt5/examples/.debug/ /usr/lib/qt5/qml/QtQuick/Controls/Nemo/.debug/ /usr/lib/qt5/qml/QtQuick/Controls/Styles/Nemo/.debug/"
