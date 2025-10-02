SUMMARY = "QML Plugin for DBus on Nemo"
HOMEPAGE = "https://github.com/sailfishos/nemo-qml-plugin-dbus"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://src/plugin/plugin.cpp;beginline=1;endline=21;md5=04fd4aa47861531d12b7453bc0ea24ee"

SRC_URI = "gitsm://github.com/sailfishos/nemo-qml-plugin-dbus.git;protocol=https;branch=master"
SRCREV = "df6e2415fe70e1844067f93b3216ca0442f17c8e"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"
inherit qmake5

DEPENDS += "dbus qtdeclarative qtbase"

FILES:${PN}-dbg += "/opt /usr/lib/qml/Nemo/DBus/.debug"
FILES:${PN} += "/usr/lib/qml/Nemo/DBus/"
