FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"
DESCRIPTION = "System specific changes for the Qt Quick Scene Graph."
LICENSE = "LGPL-2.1-only & GPL-3.0-only"
LIC_FILES_CHKSUM = " \
    file://LICENSE.GPL;md5=d32239bcb673463ab874e80d47fae504 \
    file://LICENSE.LGPL;md5=4193e7f1d47a858f6b7c0f1ee66161de \
"

PV = "5.8.0+git${SRCPV}"
SRCREV = "13394b94c6c406fafdd7a95edc12938efeb4d66a"

DEPENDS = "qtbase libhybris qtwayland virtual/android-headers qtdeclarative"

SRC_URI = "git://github.com/sailfishos/qtscenegraph-adaptation.git;protocol=https;branch=master \
        file://0001-customcontext-Adapt-for-Qt-5.8.patch \
        file://0002-Fix-build-for-Qt-5.8.patch \
        file://0003-Fix-build-on-Qt-5.10.patch \
        file://0004-context-make-it-compatible-with-Qt-5.14.patch"
S = "${WORKDIR}/git"

inherit qmake5

EXTRA_QMAKEVARS_PRE += "CONFIG+=surfaceformat CONFIG+=programbinary CONFIG+=hybristexture"

FILES:${PN} += "${OE_QMAKE_PATH_PLUGINS}"

