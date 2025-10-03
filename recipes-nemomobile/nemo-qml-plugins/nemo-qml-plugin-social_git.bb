SUMMARY = "QML Plugin for social on Nemo"
HOMEPAGE = "https://github.com/sailfishos/nemo-qml-plugin-social/"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE.BSD;md5=caa037e0975ee5862b72644673e7590c"

SRC_URI = "git://github.com/sailfishos/nemo-qml-plugin-social.git;protocol=https;branch=master"
SRCREV = "b36c021a0385fa088f3d0f7916d61fbf028841bf"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"
inherit qmake5

DEPENDS += "qtdeclarative qtbase"

FILES:${PN}-dbg += "/opt /usr/lib/qml/org/nemomobile/social/.debug"
FILES:${PN} += "/usr/lib/qml/org/nemomobile/social/"
