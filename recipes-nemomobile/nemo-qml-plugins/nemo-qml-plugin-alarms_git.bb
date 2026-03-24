SUMMARY = "QML Plugin for alarms on Nemo"
HOMEPAGE = "https://github.com/sailfishos/nemo-qml-plugin-alarms"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE.BSD;md5=caa037e0975ee5862b72644673e7590c"

SRC_URI = "git://github.com/sailfishos/nemo-qml-plugin-alarms.git;protocol=https;branch=master \
        file://0001-Disable-tests.patch"
SRCREV = "4377d1e31a56c763ba3e2d61137f97529281c1bd"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"

inherit qmake5 pkgconfig

DEPENDS += "qtdeclarative timed"

FILES:${PN}-dbg += "/opt /usr/lib/qml/Nemo/Alarms/.debug"
FILES:${PN} += "/usr/lib/qml/Nemo/Alarms/"
