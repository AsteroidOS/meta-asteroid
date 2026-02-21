SUMMARY = " Userspace reference for net/qrtr in the Linux kernel."
HOMEPAGE = "https://github.com/andersson/qrtr"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=15329706fbfcb5fc5edcc1bc7c139da5"

SRC_URI = "git://github.com/andersson/qrtr.git;protocol=https;branch=master \
           file://0001-Makefile-Allow-for-prefix-override.patch \
           "
SRCREV = "d0d471c96e7d112fac6f48bd11f9e8ce209c04d2"
PR = "r1"
PV = "+git${SRCPV}"

DEPENDS += "glib-2.0 systemd"

inherit pkgconfig
inherit systemd

SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE:${PN} = "qrtr-ns.service"

do_install() {
    oe_runmake install DESTDIR=${D} prefix=${prefix} servicedir=${systemd_system_unitdir}
}
