SUMMARY = "QML Plugin for time on Nemo"
HOMEPAGE = "https://git.merproject.org/mer-core/nemo-qml-plugin-time"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://src/plugin.cpp;beginline=1;endline=31;md5=6fe870673c7cd84b28372abaa5be2f48"

SRC_URI = "git://git.merproject.org/mer-core/nemo-qml-plugin-time.git;protocol=https"
SRCREV = "d27ce76d70c4e1467c7b929803a71c3a5ec3ee14"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"
inherit qmake5

DEPENDS += "qtdeclarative timed mce"

FILES_${PN}-dbg += "/usr/lib/qml/Nemo/Time/.debug /opt/"
FILES_${PN} += "/usr/lib/qml/Nemo/Time/ "
