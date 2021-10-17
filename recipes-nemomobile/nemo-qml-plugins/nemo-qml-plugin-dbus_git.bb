SUMMARY = "QML Plugin for DBus on Nemo"
HOMEPAGE = "https://github.com/sailfishos/nemo-qml-plugin-dbus"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://src/plugin/plugin.cpp;beginline=1;endline=31;md5=4f66b392565d1dd726d4c892676d96fd"

SRC_URI = "git://github.com/sailfishos/nemo-qml-plugin-dbus.git;protocol=https"
SRCREV = "6a36739d206af45a481ff14676b9e1d48fed0376"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"
inherit qmake5

DEPENDS += "dbus qtdeclarative qtbase"

FILES_${PN}-dbg += "/opt /usr/lib/qml/Nemo/DBus/.debug"
FILES_${PN} += "/usr/lib/qml/Nemo/DBus/"
