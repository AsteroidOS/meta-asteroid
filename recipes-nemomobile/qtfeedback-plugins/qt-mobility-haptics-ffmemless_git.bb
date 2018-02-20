SUMMARY = "Nemomobile's qt-mobility-haptics-ffmemless"
HOMEPAGE = "https://git.merproject.org/mer-core/qt-mobility-haptics-ffmemless"
LICENSE = "LGPL-2.1+"
LIC_FILES_CHKSUM = "file://qfeedback.cpp;beginline=1;endline=38;md5=a8726eef46a2a09f5773ba508cad12a2"

SRC_URI = "git://git.merproject.org/mer-core/qt-mobility-haptics-ffmemless.git;protocol=https"
SRCREV = "d7ea915d2fb42a38967861fbbf6153077f4cedd8"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"

DEPENDS += "qtfeedback libprofile-qt"
inherit qmake5

do_configure_prepend() {
    sed -i "s@I/usr/include/profile-qt5@I${STAGING_INCDIR}/profile-qt5@" ${S}/ffmemless.pro
}

FILES_${PN} += "/usr/lib/plugins/feedback/"
FILES_${PN}-dbg += "/usr/lib/plugins/feedback/.debug/"
