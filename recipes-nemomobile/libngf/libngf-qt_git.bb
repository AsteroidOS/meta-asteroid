SUMMARY = "Nemomobile's libngf-qt"
HOMEPAGE = "https://github.com/sailfishos/libngf-qt"
LICENSE = "LGPL-2.1-or-later"
LIC_FILES_CHKSUM = "file://COPYING;md5=4fbd65380cdd255951079008b364516c"

SRC_URI = "git://github.com/sailfishos/libngf-qt.git;protocol=https;branch=master \
           file://0001-Disable-tests.patch \
           "
SRCREV = "6e6ef504e3e4097d8528253cebfdf8b5764f04d5"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"

DEPENDS += " qtbase qtdeclarative libngf qtfeedback dbus"
inherit qt6-qmake

do_install:append() {
    mv ${D}/include/* ${D}/usr/include/
    rmdir ${D}/include/
}

FILES:${PN} += "/usr/lib/qml/Nemo/Ngf /usr/lib/plugins/feedback"
FILES:${PN}-dbg += "/opt /usr/lib/qml/Nemo/Ngf/.debug/"
