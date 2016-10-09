SUMMARY = "Accounts management library for Qt applications"
HOMEPAGE = "https://gitlab.com/accounts-sso/libaccounts-qt"
LICENSE = "LGPL-2.1+"
LIC_FILES_CHKSUM = "file://COPYING;md5=243b725d71bb5df4a1e5920b344b86ad"

SRC_URI = "git://gitlab.com/accounts-sso/libaccounts-qt.git;protocol=https"
SRCREV = "5b272ae218ccdf1f67f4eed92e2cdbe21c56ceb8"
PR = "r1"
PV = "+git${SRCREV}"
S = "${WORKDIR}/git"
inherit qmake5

do_configure_prepend() {
    sed -i "/doc.pri/d" ${S}/accounts-qt.pro
}

do_install_append() {
    rm -r ${D}/usr/bin/
}

DEPENDS += "qtbase libaccounts-glib "

FILES_${PN}-dev += "/usr/lib/cmake/AccountsQt5"
