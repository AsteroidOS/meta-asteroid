SUMMARY = "QML Plugin for notifications on Nemo"
HOMEPAGE = "https://github.com/sailfishos/nemo-qml-plugin-notifications"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://src/plugin/plugin.cpp;beginline=1;endline=31;md5=71911a081287caa33b542251575d913d"

SRC_URI = "git://github.com/sailfishos/nemo-qml-plugin-notifications.git;protocol=https;branch=master"
SRCREV = "84fa6a95eedb6f7d36523033ec7f45883d7c176f"
PR = "r1"
PV = "+git${SRCPV}"
inherit qmake5

DEPENDS += "qtdeclarative"

FILES:${PN}-dbg += "/opt /usr/lib/qml/Nemo/Notifications/.debug"
FILES:${PN}-dev += "/usr/lib/libnemonotifications-qt5.prl"
FILES:${PN} += "/usr/lib/qml/Nemo/Notifications/"
