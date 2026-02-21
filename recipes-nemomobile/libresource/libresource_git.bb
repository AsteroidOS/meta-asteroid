SUMMARY = "Nemomobile's libresource"
HOMEPAGE = "https://github.com/sailfishos/libresource"
LICENSE = "LGPL-2.1-or-later"
LIC_FILES_CHKSUM = "file://COPYING;md5=4fbd65380cdd255951079008b364516c"

SRC_URI = "gitsm://github.com/sailfishos/libresource.git;protocol=https;branch=master"
SRCREV = "52746ef8216a1c1b4eed21763ba3fca824fab864"
PR = "r1"
PV = "+git${SRCPV}"

do_compile:prepend() {
    sed -i "s@\$(top_builddir)/src/libresource.la@libresource.la@g" src/Makefile
}

DEPENDS += " glib-2.0 dbus-glib dbus libcheck"

inherit autotools pkgconfig

B = "${S}"
