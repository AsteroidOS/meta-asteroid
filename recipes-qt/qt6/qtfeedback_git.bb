DESCRIPTION = "Qt Tactile Feedback"
LICENSE = "GPL-3.0-only & LGPL-3.0-only"
LIC_FILES_CHKSUM = " \
    file://LICENSE.GPL;md5=d32239bcb673463ab874e80d47fae504 \
    file://LICENSE.LGPL;md5=4193e7f1d47a858f6b7c0f1ee66161de \
"
FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"
SRC_URI = "git://github.com/sailfishos/qtfeedback.git;protocol=https;branch=mer-master"
SRCREV = "2cd40d1deca20f883107215cb826fd47c408a5cb"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"

DEPENDS += "qtbase qtdeclarative"

inherit qt6-qmake

FILES:${PN} += "${OE_QMAKE_PATH_PLUGINS} /usr/lib/qml /usr/lib/libQt5Feedback.prl"
FILES:${PN}-dev += " \
    /usr/lib/mkspecs \
    /usr/lib/libQt6*.prl \
    "

