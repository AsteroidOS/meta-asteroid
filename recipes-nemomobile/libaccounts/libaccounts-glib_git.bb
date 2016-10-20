SUMMARY = "GLib-based client library for the accounts database"
HOMEPAGE = "https://gitlab.com/accounts-sso/libaccounts-glib"
LICENSE = "LGPL-2.1+"
LIC_FILES_CHKSUM = "file://COPYING;md5=243b725d71bb5df4a1e5920b344b86ad"

SRC_URI = "git://gitlab.com/accounts-sso/libaccounts-glib.git;protocol=https"

SRCREV = "8d14b10652b2fe6c25d8ad8334e2d5023d254313"
PR = "r1"
PV = "+git${SRCREV}"
S = "${WORKDIR}/git"

EXTRA_OECONF = "--disable-static --disable-gtk-doc --enable-introspection=no --disable-man"

do_configure_prepend() {
    gtkdocize
}

DEPENDS += "glib-2.0"
inherit autotools pkgconfig
B = "${S}"

DEPENDS += "libcheck libxml2 sqlite3"

FILES_${PN} += "/usr/share/dbus-1 /usr/share/backup-framework /usr/share/xml/accounts/schema/dtd"
FILES_${PN}-dev += "/usr/share/vala/vapi /usr/lib/python2.7/dist-packages/gi/overrides/"
