SUMMARY = "Nemomobile's qt5-feedback-haptics-droid-vibrator"
HOMEPAGE = "https://github.com/mer-hybris/qt5-feedback-haptics-droid-vibrator"
LICENSE = "LGPL-2.1+"
LIC_FILES_CHKSUM = "file://qfeedback.cpp;beginline=1;endline=41;md5=e4a4c22a3d930e7d0019854e1fd35b29"

SRC_URI = "git://github.com/mer-hybris/qt5-feedback-haptics-droid-vibrator;protocol=https \
           file://0001-Fixes-build-with-OE.patch \
           file://droid-vibrator.ini"
SRCREV = "e70cdbfdca7a6d87793604b6aed8231728f30c64"
PR = "r1"
PV = "+git${SRCREV}"
S = "${WORKDIR}/git"

DEPENDS += "qtfeedback libprofile-qt"
inherit qmake5

do_configure_prepend() {
    cp ${WORKDIR}/droid-vibrator.ini ${S}/droid-vibrator.ini
    sed -i "s@I/usr/include/profile-qt5@I${STAGING_INCDIR}/profile-qt5@" ${S}/droid-vibrator.pro
}

FILES_${PN} += "/usr/lib/plugins/feedback/"
FILES_${PN}-dbg += "/usr/lib/plugins/feedback/.debug/"
