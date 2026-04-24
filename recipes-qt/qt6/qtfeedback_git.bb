DESCRIPTION = "Qt Tactile Feedback"
LICENSE = "GPL-2.0-only & GPL-3.0-only & LGPL-3.0-only"
LIC_FILES_CHKSUM = " \
    file://LICENSE.GPL2;md5=b234ee4d69f5fce4486a80fdaf4a4263 \
    file://LICENSE.GPL3;md5=d32239bcb673463ab874e80d47fae504 \
    file://LICENSE.LGPL3;md5=e6a600fd5e1d9cbde2d983680233ad02 \
"
FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"
SRC_URI = "git://github.com/qt/qtfeedback.git;protocol=https;branch=master"
SRCREV = "a14bd0bb1373cde86e09e3619fb9dc70f34c71f2"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"

DEPENDS += "qtbase qtdeclarative"

inherit qmake5

FILES:${PN} += "${OE_QMAKE_PATH_PLUGINS} /usr/lib/qml /usr/lib/libQt5Feedback.prl"
FILES:${PN}-dev += " \
    /usr/lib/mkspecs \
    /usr/lib/libQt5Contacts.prl \
    /usr/lib/libQt5Organizer.prl \
    /usr/lib/libQt5Versit.prl \
    /usr/lib/libQt5VersitOrganizer.prl \
    "

