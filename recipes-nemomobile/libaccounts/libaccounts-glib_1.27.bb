SUMMARY = "GLib-based client library for the accounts database"
HOMEPAGE = "https://gitlab.com/accounts-sso/libaccounts-glib"
LICENSE = "LGPL-2.1-or-later"
LIC_FILES_CHKSUM = "file://COPYING;md5=243b725d71bb5df4a1e5920b344b86ad"

inherit meson pkgconfig vala gobject-introspection gettext

SRC_URI = "git://gitlab.com/accounts-sso/libaccounts-glib.git;protocol=https;branch=master \
           file://0001-Add-some-meson-options-introspection-docs-tests-to-p.patch \
           "

SRCREV = "26c54322304e9df598b2ba67427433a2e68b823e"
S = "${WORKDIR}/git"

EXTRA_OEMESON = "-Dpy-overrides-dir=${libdir}/python${PYTHON_BASEVERSION}/dist-packages/gi/overrides/ -Ddocs=false -Dtests=false"

DEPENDS += "glib-2.0 glib-2.0-native python3-pygobject-native"
DEPENDS += "libcheck libxml2 sqlite3"

FILES:${PN} += " \
                ${datadir}/dbus-1 \
                ${datadir}/xml/accounts/schema/dtd \
                "
FILES:${PN}-dev += " \
                ${datadir}/vala/vapi \
                ${datadir}/gettext/its \
                ${libdir}/python${PYTHON_BASEVERSION}/dist-packages/gi/overrides/ \
                "
