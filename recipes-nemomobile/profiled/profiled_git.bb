SUMMARY = "Daemon for device profile handling."
HOMEPAGE = "https://git.merproject.org/mer-core/profiled"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://mainloop.c;beginline=1;endline=35;md5=5c3ca83e642104421900fdd3ecb1176e"

SRC_URI = "git://git.merproject.org/mer-core/profiled.git;protocol=https \
    file://0001-Fixes-build.patch"
SRCREV = "71f6fbe6f3845365627923c40569bbd078ab8b19"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"

DEPENDS += "glib-2.0 dbus dbus-glib"
B = "${WORKDIR}/git" 

do_compile_prepend() {
    export CFLAGS="-std=c11 $CFLAGS"
}

do_install() {
    ROOT=${D} make install
}

FILES_${PN} += "/usr/share/dbus-1/services/profiled.service"
