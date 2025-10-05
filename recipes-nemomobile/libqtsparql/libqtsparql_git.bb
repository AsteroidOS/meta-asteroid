SUMMARY = "Mer's libqtsparql"
HOMEPAGE = "https://github.com/sailfishos/libqtsparql"
LICENSE = "LGPL-2.1-only"
LIC_FILES_CHKSUM = "file://LICENSE.LGPL;md5=f922d7c79b72c75fe134d22f3c868337"

SRC_URI = "git://github.com/sailfishos/libqtsparql.git;protocol=https;branch=master"
SRCREV = "165a079692dab2fb41ad05b0029801a39068865d"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"
inherit qmake5

DEPENDS += "qtbase qtdeclarative"

do_configure:prepend() {
    ./configure -prefix /usr/ -no-sparql-tracker_direct -no-sparql-virtuouso
    sed -i "s@src tests examples@src@" projects.pro
    sed -i "/doc.pri/d" projects.pro
}

do_install:append() {
    sed -i "s@-L/[^ ]*@@" ${D}/usr/lib/pkgconfig/*.pc
}

B="${S}"

FILES:${PN} += "/usr/lib/qml/QtSparql/ /usr/lib/plugins/sparqldrivers/"
FILES:${PN}-dev += "/usr/share/mkspecs/features/ /usr/lib/libQt5Sparql.prl"
