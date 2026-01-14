SUMMARY = "QML Plugin for alarms on Nemo"
HOMEPAGE = "https://github.com/sailfishos/nemo-qml-plugin-alarms"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://src/plugin.cpp;beginline=1;endline=31;md5=51d0e64178c105c6066f6731ee6f40b6"

SRC_URI = "git://github.com/sailfishos/nemo-qml-plugin-alarms.git;protocol=https;branch=master \
        file://0001-Disable-tests.patch"
SRCREV = "2893188822726fcaaf1d70f74f64bfecd07d3b13"
PR = "r1"
PV = "+git${SRCPV}"
inherit qmake5 pkgconfig

DEPENDS += "qtdeclarative timed"

FILES:${PN}-dbg += "/opt /usr/lib/qml/Nemo/Alarms/.debug"
FILES:${PN} += "/usr/lib/qml/Nemo/Alarms/"
