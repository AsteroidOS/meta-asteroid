SUMMARY = "usb_moded Qt bindings."
HOMEPAGE = "https://git.merproject.org/mer-core/libusb-moded-qt"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://src/qusbmoded.cpp;beginline=1;endline=32;md5=ffd9306b0b4c1289cd519527ddbc8d5a"

SRC_URI = "git://git.merproject.org/mer-core/libusb-moded-qt.git;protocol=https \
    file://0001-src.pro-Make-sure-com.meego.usb_moded.xml-is-correct.patch \
    file://usb-moded-qt5.pc"
SRCREV = "0544b73373bd0a9ec21ea05d1f8e4de22ba3e3fa"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"

DEPENDS += "qtbase usb-moded"
inherit qmake5

do_install_append() {
    mv ${D}/include ${D}/usr/
    cp ../usb-moded-qt5.pc ${D}/usr/lib/pkgconfig/
}
