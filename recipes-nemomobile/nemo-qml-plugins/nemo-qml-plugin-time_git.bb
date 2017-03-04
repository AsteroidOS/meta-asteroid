SUMMARY = "QML Plugin for time on Nemo"
HOMEPAGE = "https://git.merproject.org/mer-core/nemo-qml-plugin-time"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://src/plugin.cpp;beginline=1;endline=31;md5=6fe870673c7cd84b28372abaa5be2f48"

SRC_URI = "git://git.merproject.org/mer-core/nemo-qml-plugin-time.git;protocol=https"
SRCREV = "f8bfe5da480aeabb02a3575ca6f3f420ba13f34f"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"
inherit qmake5

DEPENDS += "qtdeclarative timed"

FILES_${PN}-dbg += "/usr/lib/qml/org/nemomobile/time/.debug /opt/"
FILES_${PN} += "/usr/lib/qml/org/nemomobile/time/ "
