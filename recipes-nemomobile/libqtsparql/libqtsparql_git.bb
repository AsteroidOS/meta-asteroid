SUMMARY = "Mer's libqtsparql"
HOMEPAGE = "https://git.merproject.org/mer-core/libqtsparql"
LICENSE = "LGPL-2.1"
LIC_FILES_CHKSUM = "file://LICENSE.LGPL;md5=f922d7c79b72c75fe134d22f3c868337"

SRC_URI = "git://git.merproject.org/mer-core/libqtsparql.git;protocol=https"
SRCREV = "2332b2d471ffb5d7884fc45c0031c9d60127ea84"
PR = "r1"
PV = "+git${SRCREV}"
S = "${WORKDIR}/git"
inherit qmake5

DEPENDS += "qtbase qtdeclarative"

do_configure_prepend() {
    ./configure -prefix /usr/
    sed -i "s@src tests examples@src@" projects.pro
    sed -i "/doc.pri/d" projects.pro
}

do_install_append() {
    sed -i "s@-L/[^ ]*@@" ${D}/usr/lib/pkgconfig/*.pc
}

B="${S}"

FILES_${PN} += "/usr/lib/qml/QtSparql/ /usr/lib/plugins/sparqldrivers/"
FILES_${PN}-dev += "/usr/share/mkspecs/features/ /usr/lib/libQt5Sparql.prl"
