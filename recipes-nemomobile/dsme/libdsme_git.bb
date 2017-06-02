SUMMARY = "Nemomobile's libdsme."
HOMEPAGE = "https://git.merproject.org/mer-core/libdsme"
LICENSE = "LGPL-2.1+"
LIC_FILES_CHKSUM = "file://COPYING;md5=2d5025d4aa3495befef8f17206a5b0a1"

DEPENDS += " glib-2.0 libcheck pkgconfig-native"

SRC_URI = "git://git.merproject.org/mer-core/libdsme.git;protocol=https \
    file://001-Allows-custom-cflags.patch \
"
SRCREV = "826915f91a5f94fe3385a2b1d2b04092fbf5c4d9"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"

do_compile_prepend () {
    export CFLAGS="$CFLAGS -fPIC"
}

do_install() {
	oe_runmake install DESTDIR=${D}
}

do_install_append() {
    cd ${D}/usr/lib/

    # Fix broken symlinks
    rm libdsme.so libdsme_dbus_if.so libthermalmanager_dbus_if.so
    ln -s libdsme.so.0.3.0 libdsme.so
    ln -s libdsme.so.0.3.0 libdsme.so.0
    ln -s libdsme.so.0.3.0 libdsme.so.0.3
    ln -s libdsme_dbus_if.so.0.3.0 libdsme_dbus_if.so
    ln -s libdsme_dbus_if.so.0.3.0 libdsme_dbus_if.so.0
    ln -s libdsme_dbus_if.so.0.3.0 libdsme_dbus_if.so.0.3
    ln -s libthermalmanager_dbus_if.so.0.3.0 libthermalmanager_dbus_if.so
    ln -s libthermalmanager_dbus_if.so.0.3.0 libthermalmanager_dbus_if.so.0
    ln -s libthermalmanager_dbus_if.so.0.3.0 libthermalmanager_dbus_if.so.0.3
}

FILES_${PN}-dbg += "/opt"
