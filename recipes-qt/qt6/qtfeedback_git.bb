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

do_install:append() {
    # qt6-qmake.bbclass strips STAGING_DIR from .prl files but leaves the
    # QMAKE_PRL_BUILD_DIR line, which embeds TMPDIR (buildpaths QA). Drop it
    # like qt6-cmake.bbclass does. QTBUG-105877
    find ${D} \( -name "*.pri" -or -name "*.prl" \) -exec \
        sed -i -e '/QMAKE_PRL_BUILD_DIR/d' \
               -e '\|${WORKDIR}|d' {} \;
}

FILES:${PN} += "${OE_QMAKE_PATH_PLUGINS} /usr/lib/qml /usr/lib/libQt5Feedback.prl"
FILES:${PN}-dev += " \
    /usr/lib/mkspecs \
    /usr/lib/libQt6*.prl \
    "

