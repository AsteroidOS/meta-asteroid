FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
DESCRIPTION = "System specific changes for the Qt Quick Scene Graph."
LICENSE = "LGPL-2.1 & GPL-3.0"
LIC_FILES_CHKSUM = " \
    file://LICENSE.GPL;md5=d32239bcb673463ab874e80d47fae504 \
    file://LICENSE.LGPL;md5=4193e7f1d47a858f6b7c0f1ee66161de \
"

PV = "5.8.0+git${SRCPV}"
SRCREV = "13394b94c6c406fafdd7a95edc12938efeb4d66a"

DEPENDS = "qtbase libhybris qtwayland virtual/android-headers qtdeclarative"

SRC_URI = "git://github.com/sailfishos/qtscenegraph-adaptation.git;protocol=https"
S = "${WORKDIR}/git"

inherit qmake5

EXTRA_QMAKEVARS_PRE += "CONFIG+=surfaceformat CONFIG+=programbinary CONFIG+=hybristexture"

FILES_${PN} += "${OE_QMAKE_PATH_PLUGINS}"

