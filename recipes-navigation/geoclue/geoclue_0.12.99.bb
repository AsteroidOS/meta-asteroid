SUMMARY = "The Geolocation Service"
DESCRIPTION = "Geoclue is a D-Bus service that provides location information. \
The primary goal of the Geoclue project is to make creating location-aware applications \
as simple as possible, while the secondary goal is to ensure that no application \
can access location information without explicit permission from user."
LICENSE = "LGPL-2.0-only"
SECTION = "console/network"

LIC_FILES_CHKSUM = "file://COPYING;md5=149a9c1e8e40b7453ce8c62ed489f481"

DEPENDS = "glib-2.0 dbus dbus-glib libxml2 libxslt-native dbus-glib-native python3-six-native"

inherit autotools gsettings pkgconfig gtk-doc

SRC_URI = "http://freedesktop.org/~hadess/geoclue-0.12.99.tar.gz \
           file://0001-Remove-hardcoded-CFLAGS-that-collide-with-Yocto-OE-C.patch"

SRC_URI[md5sum] = "779245045bfeeec4853da8baaa3a18e6"
SRC_URI[sha256sum] = "fe396c91cb52de4219281f4d9223156338fc03670d34700281e86d1399b80a72"

B = "${S}"

# Without this line, package is delcared a library and named libgeoclue*
AUTO_LIBNAME_PKGS = ""

FILES:${PN} += " \
    ${datadir}/dbus-1/services \
    ${datadir}/geoclue-providers \
    ${datadir}/GConf/gsettings/geoclue \
"
