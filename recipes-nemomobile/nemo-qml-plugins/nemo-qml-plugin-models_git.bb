SUMMARY = "QML Plugin for models on Nemo"
HOMEPAGE = "https://github.com/sailfishos/nemo-qml-plugin-models"
LICENSE = "BSD-3-Clause & LGPL-2.0-only"
LIC_FILES_CHKSUM = " \
        file://LICENSE.BSD;md5=caa037e0975ee5862b72644673e7590c \
        file://LICENSE.LGPL;md5=5f30f0716dfdd0d91eb439ebec522ec2 \
        "

SRC_URI = "git://github.com/sailfishos/nemo-qml-plugin-models.git;protocol=https;branch=master"
SRCREV = "175c003d307bdde997d143e0034b7ff6e2dfe7cf"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"
inherit qmake5 pkgconfig

DEPENDS += "qtdeclarative timed libmlocale"

FILES:${PN}-dev += "/usr/lib/libnemomodels-qt5.prl"
FILES:${PN}-dbg += "/opt /usr/lib/qml/org/nemomobile/models/.debug"
FILES:${PN} += "/usr/lib/qml/org/nemomobile/models/"
