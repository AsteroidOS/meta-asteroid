SUMMARY = "QML Plugin for notifications on Nemo"
HOMEPAGE = "https://git.merproject.org/mer-core/nemo-qml-plugin-notifications"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://src/plugin/plugin.cpp;beginline=1;endline=31;md5=71911a081287caa33b542251575d913d"

SRC_URI = "git://git.merproject.org/mer-core/nemo-qml-plugin-notifications.git;protocol=https"
SRCREV = "f6c3b97f6ea5ae59a50aa2ff25702b8f398b8e55"
PR = "r1"
PV = "+git${SRCREV}"
S = "${WORKDIR}/git"
inherit qmake5

DEPENDS += "qtdeclarative"

FILES_${PN}-dbg += "/opt /usr/lib/qt5/qml/org/nemomobile/notifications/.debug"
FILES_${PN}-dev += "/usr/lib/libnemonotifications-qt5.prl"
FILES_${PN} += "/usr/lib/qt5/qml/org/nemomobile/notifications/"
