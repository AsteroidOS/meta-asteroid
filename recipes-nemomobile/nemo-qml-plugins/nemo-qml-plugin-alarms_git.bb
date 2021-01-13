SUMMARY = "QML Plugin for alarms on Nemo"
HOMEPAGE = "https://git.merproject.org/mer-core/nemo-qml-plugin-alarms"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://src/plugin.cpp;beginline=1;endline=31;md5=51d0e64178c105c6066f6731ee6f40b6"

SRC_URI = "git://git.merproject.org/mer-core/nemo-qml-plugin-alarms.git;protocol=https \
        file://0001-Disable-tests.patch"
SRCREV = "2893188822726fcaaf1d70f74f64bfecd07d3b13"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"
inherit qmake5

DEPENDS += "qtdeclarative timed"

FILES_${PN}-dbg += "/opt /usr/lib/qml/Nemo/Alarms/.debug"
FILES_${PN} += "/usr/lib/qml/Nemo/Alarms/"
