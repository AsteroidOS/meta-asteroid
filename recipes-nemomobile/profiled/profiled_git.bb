SUMMARY = "Daemon for device profile handling."
HOMEPAGE = "https://github.com/sailfishos/profiled"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://mainloop.c;beginline=1;endline=35;md5=5c3ca83e642104421900fdd3ecb1176e"

SRC_URI = "git://github.com/sailfishos/profiled.git;protocol=https;branch=master \
    file://0001-Fixes-build.patch"
SRCREV = "bf70ccf650330f1e2bc23b689e51015bb034b77d"
PR = "r1"
PV = "+git${SRCPV}"

DEPENDS += "glib-2.0 dbus dbus-glib pkgconfig-native"

do_compile:prepend() {
    export CFLAGS="-std=c11 $CFLAGS"
}

do_install() {
    ROOT=${D} make install
}

FILES:${PN} += "/usr/share/dbus-1/services/profiled.service /usr/lib/systemd/user/profiled.service"
