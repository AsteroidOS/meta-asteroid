SUMMARY = "Single Sign On framework"
HOMEPAGE = "https://gitlab.com/accounts-sso/signond"
LICENSE = "LGPL-2.1-or-later"
LIC_FILES_CHKSUM = "file://COPYING;md5=243b725d71bb5df4a1e5920b344b86ad"

# TODO: use accounts-sso/signond again when
# https://gitlab.com/accounts-sso/signond/-/merge_requests/36 is submitted
SRC_URI = "git://gitlab.com/nicolasfella/signond.git;protocol=https;branch=qt6"
SRCREV = "c8ad98249af541514ff7a81634d3295e712f1a39"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"
inherit qt6-qmake

do_configure:prepend() {
    sed -i "/doc.pri/d" ${S}/signon.pro ${S}/lib/SignOn/SignOn.pro ${S}/lib/plugins/plugins.pro
}

do_install:append() {
    if [ -d "${D}/usr/lib64/" ]; then
        mv ${D}/usr/lib64/ ${D}/usr/lib/
    fi
}

DEPENDS += "qtbase"
FILES:${PN} += "/usr/share/dbus-1/ /usr/lib/signon/"
FILES:${PN}-dev += "/usr/lib/cmake/"
