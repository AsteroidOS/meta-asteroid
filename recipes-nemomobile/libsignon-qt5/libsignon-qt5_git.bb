SUMMARY = "Single Sign On framework"
HOMEPAGE = "https://gitlab.com/accounts-sso/signond"
LICENSE = "LGPL-2.1-or-later"
LIC_FILES_CHKSUM = "file://COPYING;md5=243b725d71bb5df4a1e5920b344b86ad"

SRC_URI = "git://gitlab.com/accounts-sso/signond.git;protocol=https;branch=master"
SRCREV = "4c182d24f552acb69e62988624b408cb83f5158d"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"
inherit qmake5

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
