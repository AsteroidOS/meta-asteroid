SUMMARY = "usb_moded Qt bindings."
HOMEPAGE = "https://github.com/sailfishos/libusb-moded-qt"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://src/qusbmoded.cpp;beginline=1;endline=32;md5=ffd9306b0b4c1289cd519527ddbc8d5a"

SRC_URI = "git://github.com/sailfishos/libusb-moded-qt.git;protocol=https;branch=master \
    file://0001-src.pro-Make-sure-com.meego.usb_moded.xml-is-correct.patch \
    file://usb-moded-qt5.pc"
SRCREV = "10f2bcb86e9c116ae94da668d997c09c0966388c"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"

DEPENDS += "qtbase usb-moded"
inherit qt6-qmake pkgconfig

do_install:append() {
    mv ${D}/include ${D}/usr/
    install -m 644 -D ${UNPACKDIR}/usb-moded-qt5.pc ${D}/usr/lib/pkgconfig/
}
