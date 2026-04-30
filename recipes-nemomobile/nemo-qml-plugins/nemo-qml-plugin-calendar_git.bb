SUMMARY = "QML Plugin for calendar on Nemo"
HOMEPAGE = "https://github.com/sailfishos/nemo-qml-plugin-calendar"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://src/plugin.cpp;beginline=1;endline=31;md5=4f66b392565d1dd726d4c892676d96fd"

# TODO: use sailfishos/nemo-qml-plugin-calendar when https://github.com/sailfishos/nemo-qml-plugin-calendar/pull/73 is merged
SRC_URI = "git://github.com/PureTryOut/nemo-qml-plugin-calendar.git;protocol=https;branch=feat/qt6"
SRCREV = "ef4f8d0e7a3e801b26991c3f034148b5bf8de48a"
PV = "0.7.8"
S = "${WORKDIR}/git"
inherit qt6-qmake pkgconfig

DEPENDS += "qtbase qtdeclarative mkcal libaccounts-qt5 timed"

FILES:${PN}-dbg += "/opt /usr/lib/qml/org/nemomobile/calendar/.debug"
FILES:${PN} += "/usr/lib/qml/org/nemomobile/calendar/ /usr/share/dbus-1/services/org.nemomobile.calendardataservice.service"
