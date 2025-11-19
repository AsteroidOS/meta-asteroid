SUMMARY = "Mer's libqtsparql"
HOMEPAGE = "https://github.com/sailfishos/libqtsparql"
LICENSE = "LGPL-2.1-only"
LIC_FILES_CHKSUM = "file://LICENSE.LGPL;md5=f922d7c79b72c75fe134d22f3c868337"

SRC_URI = "git://github.com/sailfishos/libqtsparql.git;protocol=https;branch=master"
SRCREV = "2332b2d471ffb5d7884fc45c0031c9d60127ea84"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"
inherit qmake5

EXTRA_QMAKEVARS_PRE += "QMAKE_CFLAGS_ISYSTEM="

DEPENDS += "qtbase qtdeclarative"

do_configure:prepend() {
    ./configure -prefix /usr/
    sed -i "s@src tests examples@src@" projects.pro
    sed -i "/doc.pri/d" projects.pro
    export QT_SELECT=5
}

do_install:append() {
    sed -i "s@-L/[^ ]*@@" ${D}/usr/lib/pkgconfig/*.pc
}

B = "${S}"

FILES:${PN} += "/usr/lib/qml/QtSparql/ /usr/lib/plugins/sparqldrivers/"
FILES:${PN}-dev += "/usr/share/mkspecs/features/ /usr/lib/libQt5Sparql.prl"
