SUMMARY = "QML Plugin for alarms on Nemo"
HOMEPAGE = "https://github.com/nemomobile/nemo-qml-plugin-alarms"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://src/plugin.cpp;beginline=1;endline=31;md5=51d0e64178c105c6066f6731ee6f40b6"

SRC_URI = "git://github.com/nemomobile/nemo-qml-plugin-alarms;protocol=https"
SRCREV = "c501f5480f896e3a3b4eb8c1f57cad08f71a242b"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"
inherit qmake5

DEPENDS += "qtdeclarative timed"

FILES_${PN}-dbg += "/opt /usr/lib/qml/org/nemomobile/alarms/.debug"
FILES_${PN} += "/usr/lib/qml/org/nemomobile/alarms/"
