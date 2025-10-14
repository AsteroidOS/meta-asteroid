SUMMARY = "QML Plugin for calendar on Nemo"
HOMEPAGE = "https://github.com/sailfishos/nemo-qml-plugin-calendar"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://src/plugin.cpp;beginline=1;endline=31;md5=4f66b392565d1dd726d4c892676d96fd"

SRC_URI = "git://github.com/sailfishos/nemo-qml-plugin-calendar.git;protocol=https;branch=master"
SRCREV = "d8bac39b8f1b175b5be0d0aa1047d40e52574d66"
PV = "0.7.8"
S = "${WORKDIR}/git"
inherit qmake5 pkgconfig

DEPENDS += "qtdeclarative mkcal libaccounts-qt5"

FILES:${PN}-dbg += "/opt /usr/lib/qml/org/nemomobile/calendar/.debug"
FILES:${PN} += "/usr/lib/qml/org/nemomobile/calendar/ /usr/share/dbus-1/services/org.nemomobile.calendardataservice.service"
