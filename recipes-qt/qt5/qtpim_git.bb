DESCRIPTION = "Qt Personal Information Management"
LICENSE = "GPL-2.0-only & GPL-3.0-only"
LIC_FILES_CHKSUM = " \
    file://LICENSE.GPL2;md5=b234ee4d69f5fce4486a80fdaf4a4263 \
    file://LICENSE.GPL3;md5=d32239bcb673463ab874e80d47fae504 \
"
FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"
# Patch backports a commit needed by qtcontacts-sqlite,
# which was added after the Qt6 transition.
SRC_URI = "git://github.com/qt/qtpim.git;protocol=https;branch=dev \
    file://0001-Enforce-detail-access-constraints-in-contact-operati.patch"
# Last rev before Qt6 it seems
SRCREV = "f9a8f0fc914c040d48bbd0ef52d7a68eea175a98"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"

DEPENDS += "qtbase qtdeclarative"

inherit qmake5

FILES:${PN} += "${OE_QMAKE_PATH_PLUGINS} /usr/lib/qml"
FILES:${PN}-dev += " \
    /usr/lib/mkspecs \
    /usr/lib/libQt5Contacts.prl \
    /usr/lib/libQt5Organizer.prl \
    /usr/lib/libQt5Versit.prl \
    /usr/lib/libQt5VersitOrganizer.prl \
    "
