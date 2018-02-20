SUMMARY = "QML Plugin for calendar on Nemo"
HOMEPAGE = "https://git.merproject.org/mer-core/nemo-qml-plugin-calendar"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://src/plugin.cpp;beginline=1;endline=31;md5=4f66b392565d1dd726d4c892676d96fd"

SRC_URI = "git://git.merproject.org/mer-core/nemo-qml-plugin-calendar.git;protocol=https"
SRCREV = "dcf610f82840016b254896035d4223baa559075e"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"
inherit qmake5

DEPENDS += "qtdeclarative kcalcore mkcal libaccounts-qt5"

FILES_${PN}-dbg += "/opt /usr/lib/qml/org/nemomobile/calendar/.debug"
FILES_${PN} += "/usr/lib/qml/org/nemomobile/calendar/ /usr/share/dbus-1/services/org.nemomobile.calendardataservice.service"
