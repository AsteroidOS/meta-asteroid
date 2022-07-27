SUMMARY = "Accounts management library for Qt applications"
HOMEPAGE = "https://gitlab.com/accounts-sso/libaccounts-qt"
LICENSE = "LGPL-2.1-or-later"
LIC_FILES_CHKSUM = "file://COPYING;md5=243b725d71bb5df4a1e5920b344b86ad"

SRC_URI = "git://gitlab.com/accounts-sso/libaccounts-qt.git;protocol=https;branch=master"
SRCREV = "525ec684cfa8d234f797d7e49e21c476eea04d8e"
PV = "1.16"
S = "${WORKDIR}/git"
inherit qmake5 pkgconfig

do_configure:prepend() {
    sed -i "/doc.pri/d" ${S}/accounts-qt.pro
}

do_install:append() {
    rm -r ${D}/usr/bin/
}

DEPENDS += "qtbase libaccounts-glib glib-2.0"

FILES:${PN}-dev += "/usr/lib/cmake/AccountsQt5"
