SUMMARY = "QML Plugin for time on Nemo"
HOMEPAGE = "https://github.com/sailfishos/nemo-qml-plugin-time"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE.BSD;md5=caa037e0975ee5862b72644673e7590c"

SRC_URI = "git://github.com/sailfishos/nemo-qml-plugin-time.git;protocol=https;branch=master"
SRCREV = "5605fe6644937e94c41a7cdfc2bfc72a8cf4f588"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"
inherit qmake5

DEPENDS += "qtdeclarative timed mce"

FILES:${PN}-dbg += "/usr/lib/qml/Nemo/Time/.debug /opt/"
FILES:${PN} += "/usr/lib/qml/Nemo/Time/ "
