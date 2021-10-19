SUMMARY = "A light version of meegotouch, pulling in useful parts without requiring the full heavy library."
HOMEPAGE = "https://github.com/sailfishos/mlite"
LICENSE = "LGPL-2.1+"
LIC_FILES_CHKSUM = "file://src/mnotification.cpp;beginline=1;endline=18;md5=5dd5d73b0225b3099a82e6ad93283ea1"

SRC_URI = "git://github.com/sailfishos/mlite.git;protocol=https \
           file://0001-MDesktopEntry-Allow-dynamic-locale-switch-by-disabli.patch"
SRCREV = "16dbe04def90ad6e347c80c2b4e81443b03571b1"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"

DEPENDS += "qtbase glib-2.0 dconf"
inherit qmake5
B = "${WORKDIR}/git" 
# Out of dir build breaks mlite5.pc installation

do_configure:prepend() {
    sed -i "/tests/d" ${S}/mlite.pro
}

do_install:append() {
    cd src/
    cp *.h MDConfGroup MNotificationGroup MRemoteAction MExport MDesktopEntry MNotification MGConfItem  ${D}/usr/include/mlite5/
}

FILES:${PN}-dbg += "/opt"
