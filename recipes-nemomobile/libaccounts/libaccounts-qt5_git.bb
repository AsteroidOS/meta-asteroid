SUMMARY = "Accounts management library for Qt applications"
HOMEPAGE = "https://gitlab.com/accounts-sso/libaccounts-qt"
LICENSE = "LGPL-2.1+"
LIC_FILES_CHKSUM = "file://COPYING;md5=243b725d71bb5df4a1e5920b344b86ad"

SRC_URI = "git://gitlab.com/accounts-sso/libaccounts-qt.git;protocol=https"
SRCREV = "f4d8af8dffb461a0eff9f03925fe6dbab9f1c1d2"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"
inherit qmake5

do_configure:prepend() {
    sed -i "/doc.pri/d" ${S}/accounts-qt.pro
}

do_install:append() {
    rm -r ${D}/usr/bin/
}

DEPENDS += "qtbase libaccounts-glib "

FILES:${PN}-dev += "/usr/lib/cmake/AccountsQt5"
