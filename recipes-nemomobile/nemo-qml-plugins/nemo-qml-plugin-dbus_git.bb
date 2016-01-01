SUMMARY = "QML Plugin for DBus on Nemo"
HOMEPAGE = "https://git.merproject.org/mer-core/nemo-qml-plugin-dbus"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://src/plugin.cpp;beginline=1;endline=31;md5=4f66b392565d1dd726d4c892676d96fd"

SRC_URI = "git://git.merproject.org/mer-core/nemo-qml-plugin-dbus.git;protocol=https"
SRCREV = "c4d98477aaea95d7cbbf0414ed7aeb802942737f"
PR = "r1"
PV = "+git${SRCREV}"
S = "${WORKDIR}/git"
inherit qmake5

DEPENDS += "dbus qtdeclarative qtbase"

FILES_${PN}-dbg += "/opt /usr/lib/qml/org/nemomobile/dbus/.debug"
FILES_${PN} += "/usr/lib/qml/org/nemomobile/dbus/"
