SUMMARY = "QML Plugin for social on Nemo"
HOMEPAGE = "https://git.merproject.org/mer-core/nemo-qml-plugin-social/"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://src/plugin.cpp;beginline=1;endline=31;md5=f8c85a4530dff183f906f55efc59b98d"

SRC_URI = "git://git.merproject.org/mer-core/nemo-qml-plugin-social.git;protocol=https"
SRCREV = "65fe246088994084a1fc2fc0c6788f239b9ad997"
PR = "r1"
PV = "+git${SRCREV}"
S = "${WORKDIR}/git"
inherit qmake5

DEPENDS += "qtdeclarative qtbase"

FILES_${PN}-dbg += "/opt /usr/lib/qml/org/nemomobile/social/.debug"
FILES_${PN} += "/usr/lib/qml/org/nemomobile/social/"
