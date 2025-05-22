SUMMARY = "GLib-based client library for the accounts database"
HOMEPAGE = "https://gitlab.com/accounts-sso/libaccounts-glib"
LICENSE = "LGPL-2.1-or-later"
LIC_FILES_CHKSUM = "file://COPYING;md5=243b725d71bb5df4a1e5920b344b86ad"

inherit meson pkgconfig vala

SRC_URI = "git://gitlab.com/accounts-sso/libaccounts-glib.git;protocol=https;branch=master \
        file://0001-meson-Disable-docs-and-tests.patch"

SRCREV = "26c54322304e9df598b2ba67427433a2e68b823e"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"

EXTRA_OEMESON = "-Dpy-overrides-dir=/usr/lib/python3.8/dist-packages/gi/overrides/"

do_install:append() {
    rm -r ${D}/usr/share/gettext/
    rm -r ${D}/usr/lib/girepository-1.0/
}

DEPENDS += "glib-2.0 glib-2.0-native vala-native python3-pygobject-native gobject-introspection qemu-native"

DEPENDS += "libcheck libxml2 sqlite3"

FILES:${PN} += "/usr/share/dbus-1 /usr/share/backup-framework /usr/share/xml/accounts/schema/dtd"
FILES:${PN}-dev += "/usr/share/vala/vapi /usr/lib/python3.8/dist-packages/gi/overrides/"
