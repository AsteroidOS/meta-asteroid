SUMMARY = "QML Plugin for social on Nemo"
HOMEPAGE = "https://github.com/sailfishos/nemo-qml-plugin-social/"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://src/plugin.cpp;beginline=1;endline=31;md5=f8c85a4530dff183f906f55efc59b98d"

SRC_URI = "git://github.com/sailfishos/nemo-qml-plugin-social.git;protocol=https;branch=master"
SRCREV = "1fb5b87badd487651ad4664207683d628e55919c"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"
inherit qmake5

DEPENDS += "qtdeclarative qtbase"

FILES:${PN}-dbg += "/opt /usr/lib/qml/org/nemomobile/social/.debug"
FILES:${PN} += "/usr/lib/qml/org/nemomobile/social/"
