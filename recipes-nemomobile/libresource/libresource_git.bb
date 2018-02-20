SUMMARY = "Nemomobile's libresource"
HOMEPAGE = "https://git.merproject.org/mer-core/libresource"
LICENSE = "LGPL-2.1+"
LIC_FILES_CHKSUM = "file://COPYING;md5=4fbd65380cdd255951079008b364516c"

SRC_URI = "git://git.merproject.org/mer-core/libresource.git;protocol=https"
SRCREV = "0af1cea2bf457a911baa7cd65ee1e32747df3011"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"

do_compile_prepend() {
    sed -i "s@\$(top_builddir)/src/libresource.la@libresource.la@g" src/Makefile
}

DEPENDS += " glib-2.0 dbus-glib dbus libcheck"
inherit autotools pkgconfig
