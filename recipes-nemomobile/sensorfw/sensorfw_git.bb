SUMMARY = "Nemomobile's sensorfw"
HOMEPAGE = "https://github.com/mer-packages/sensorfw"
LICENSE = "LGPL-2.1+"
LIC_FILES_CHKSUM = "file://COPYING;md5=2d5025d4aa3495befef8f17206a5b0a1"

SRC_URI = "git://github.com/mer-packages/sensorfw.git;protocol=https"
SRCREV = "2b23afac95e071d3e24435481654d5f540552355"
PR = "r1"
PV = "+git${SRCREV}"
S = "${WORKDIR}/git"

inherit qmake5

do_configure_prepend() {
    sed -i '/include( doc\/doc.pri )/d' ../git/sensorfw.pro
}

DEPENDS += "qtbase"

FILES_${PN} += "/usr/lib/sensord-qt5/*.so /usr/lib/sensord-qt5/testing/*.so"
FILES_${PN}-dbg += "/usr/share/sensorfw-tests/ /usr/lib/sensord-qt5/.debug/ /usr/lib/sensord-qt5/testing/.debug/"
FILES_${PN}-dev += "/usr/share/qt5/mkspecs/"
