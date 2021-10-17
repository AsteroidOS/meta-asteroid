SUMMARY = "Nemomobile's MCE."
HOMEPAGE = "https://github.com/sailfishos/mce"
LICENSE = "LGPL-2.1+"
LIC_FILES_CHKSUM = "file://COPYING;md5=4fbd65380cdd255951079008b364516c"

SRC_URI = "git://github.com/AsteroidOS/mce.git;protocol=https \
    file://mce.service"
SRC_URI_append_qemux86 = " file://0001-Keep-screen-on-by-default-on-emulator.patch"
SRCREV = "${AUTOREV}"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"

DEPENDS += "glib-2.0 libdsme libiphb systemd dbus-glib dbus libngf pkgconfig-native"

do_install() {
    oe_runmake install DESTDIR=${D}
    install -m 0644 ${WORKDIR}/mce.service ${D}${systemd_system_unitdir}
    rm -r ${D}/var/run/
}

FILES_${PN} += " /run/mce /lib/systemd/system "
FILES_${PN}-dbg += "/usr/lib/mce/modules/.debug"
