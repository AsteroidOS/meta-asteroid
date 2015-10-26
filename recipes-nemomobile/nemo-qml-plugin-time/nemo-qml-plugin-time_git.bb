SUMMARY = "QML Plugin for time on Nemo"
HOMEPAGE = "https://git.merproject.org/mer-core/nemo-qml-plugin-time"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://src/plugin.cpp;beginline=1;endline=31;md5=6fe870673c7cd84b28372abaa5be2f48"

SRC_URI = "git://git.merproject.org/mer-core/nemo-qml-plugin-time.git;protocol=https"
SRCREV = "${AUTOREV}"
PR = "r1"
PV = "+git${SRCREV}"
S = "${WORKDIR}/git"
inherit qmake5

DEPENDS += "qtquickcontrols timed"
RDEPENDS_${PN} += "qtquickcontrols-qmlplugins"

FILES_${PN}-dbg += "/usr/lib/qt5/qml/org/nemomobile/time/.debug /opt/"
FILES_${PN} += "/usr/lib/qt5/qml/org/nemomobile/time/ "
