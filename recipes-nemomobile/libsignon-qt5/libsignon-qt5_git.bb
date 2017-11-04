SUMMARY = "Single Sign On framework"
HOMEPAGE = "https://gitlab.com/accounts-sso/signond"
LICENSE = "LGPL-2.1+"
LIC_FILES_CHKSUM = "file://COPYING;md5=243b725d71bb5df4a1e5920b344b86ad"

SRC_URI = "git://gitlab.com/accounts-sso/signond.git;protocol=https"
SRCREV = "440587278e2cd5cb268e9d95fbf45d18849fd879"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"
inherit qmake5

do_configure_prepend() {
    sed -i "/doc.pri/d" ${S}/signon.pro ${S}/lib/SignOn/SignOn.pro ${S}/lib/plugins/plugins.pro
}

do_install_append() {
    if [ -d "${D}/usr/lib64/" ]; then
        mv ${D}/usr/lib64/ ${D}/usr/lib/
    fi
}

DEPENDS += "qtbase"
FILES_${PN} += "/usr/share/dbus-1/ /usr/lib/signon/"
FILES_${PN}-dev += "/usr/lib/cmake/"
