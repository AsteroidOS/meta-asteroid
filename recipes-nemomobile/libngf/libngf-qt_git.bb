SUMMARY = "Nemomobile's libngf-qt"
HOMEPAGE = "https://git.merproject.org/mer-core/libngf-qt"
LICENSE = "LGPL-2.1+"
LIC_FILES_CHKSUM = "file://COPYING;md5=4fbd65380cdd255951079008b364516c"

SRC_URI = "git://git.merproject.org/mer-core/libngf-qt.git;protocol=https"
SRCREV = "43cadce94add865795d8aa92da958356cc12d291"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"

DEPENDS += " qtbase qtdeclarative libngf dbus"
inherit qmake5

do_install_append() {
    mv ${D}/lib/* ${D}/usr/lib/
    mv ${D}/include/* ${D}/usr/include/
    rmdir ${D}/include/ ${D}/lib/
}

FILES_${PN} += "/usr/lib/qml/org/nemomobile/ngf"
FILES_${PN}-dbg += "/opt /usr/lib/qml/org/nemomobile/ngf/.debug/"
