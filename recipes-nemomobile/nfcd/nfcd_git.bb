SUMMARY = "SailfishOS NFC daemon"
HOMEPAGE = "https://github.com/sailfishos/nfcd"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=f96e17185b6c75073ad970a61adc7ede"

SRC_URI = "git://github.com/sailfishos/nfcd.git;protocol=https;branch=master \
           file://0001-Makefile-Allow-for-CC-to-be-overridden.patch \
           file://0002-Makefile-Allow-for-INSTALL_SYSTEMD_DIR-to-be-overrid.patch \
           file://0003-systemd-Allow-the-service-to-be-started-as-root.patch \
           "
SRCREV = "0355e7f9b66f311a7dd99e0d02800d5ef5e44ce2"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"

EXTRA_OEMAKE = "KEEP_SYMBOLS=1 INSTALL_SYSTEMD_DIR=${D}${systemd_unitdir}/system/"

DEPENDS += "glib-2.0 libglibutil glib-2.0-native systemd libgbinder libdbusaccess file"
RDEPENDS:${PN} += "nfcd-mce-plugin"

SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE:${PN} = "nfcd.service"
SYSTEMD_AUTO_ENABLE:${PN} = "disable"

do_compile:append() {
    oe_runmake release
}

do_install() {
    oe_runmake install DESTDIR=${D}
}

inherit pkgconfig
inherit systemd
