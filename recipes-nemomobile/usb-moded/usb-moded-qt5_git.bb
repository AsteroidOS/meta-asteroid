SUMMARY = "usb_moded Qt bindings."
HOMEPAGE = "https://github.com/nemomobile/libusb-moded-qt"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://src/qusbmoded.cpp;beginline=1;endline=32;md5=ad12d596c12a6a1ba1d75376dc1f199a"

SRC_URI = "git://github.com/nemomobile/libusb-moded-qt;protocol=https"
SRCREV = "0a4b8ffe0cd775cce7a2366c8363d29d617b8e60"
PR = "r1"
PV = "+git${SRCREV}"
S = "${WORKDIR}/git"

DEPENDS += "qtbase usb-moded"
inherit qmake5

do_install_append() {
    mv ${D}/include ${D}/usr/
}
