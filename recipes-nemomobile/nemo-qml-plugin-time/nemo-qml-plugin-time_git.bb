SUMMARY = "QML Plugin for time on Nemo"
HOMEPAGE = "https://github.com/nemomobile/nemo-qml-plugin-time"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://src/plugin.cpp;beginline=1;endline=31;md5=6fe870673c7cd84b28372abaa5be2f48"

SRC_URI = "git://github.com/nemomobile/nemo-qml-plugin-time;protocol=https"
SRCREV = "${AUTOREV}"
PR = "r1"
PV = "+git${SRCREV}"
S = "${WORKDIR}/git"
inherit qmake5

DEPENDS += "qtquickcontrols"
RDEPENDS_${PN} += "qtquickcontrols-qmlplugins"
