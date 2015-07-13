SUMMARY = "A light version of meegotouch, pulling in useful parts without requiring the full heavy library."
HOMEPAGE = "https://github.com/nemomobile/mlite.git"
LICENSE = "LGPL-2.1+"
LIC_FILES_CHKSUM = "file://src/mnotification.cpp;beginline=1;endline=18;md5=5dd5d73b0225b3099a82e6ad93283ea1"

SRC_URI = "git://github.com/nemomobile/mlite.git;protocol=https"
SRCREV = "${AUTOREV}"
PR = "r1"
PV = "+git${SRCREV}"
S = "${WORKDIR}/git"

DEPENDS += " qtbase glib-2.0"
inherit qmake5
B = "${WORKDIR}/git" 
# Out of dir build breaks mlite5.pc installation

do_install_append() {
    cd src/
    cp *.h MDConfGroup MNotificationGroup MRemoteAction MExport MDesktopEntry MNotification MGConfItem  ${D}/usr/include/mlite5/
}

FILES_${PN}-dbg += "/opt"
