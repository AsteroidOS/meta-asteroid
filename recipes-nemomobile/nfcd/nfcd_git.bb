SUMMARY = "SailfishOS NFC daemon"
HOMEPAGE = "https://github.com/sailfishos/nfcd"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=5b3f54b2e4d9f7704287bad532091824"

SRC_URI = "git://github.com/sailfishos/nfcd.git;protocol=https;branch=master \
           file://0001-Makefile-Allow-for-CC-to-be-overridden.patch \
           file://0002-Makefile-Allow-for-INSTALL_SYSTEMD_DIR-to-be-overrid.patch \
           file://0003-systemd-Allow-the-service-to-be-started-as-root.patch \
           "
SRCREV = "0cdf85c5373ea94877af64e20a2b05a80074386a"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"

EXTRA_OEMAKE = "KEEP_SYMBOLS=1 INSTALL_SYSTEMD_DIR=${D}${systemd_unitdir}/system/"

DEPENDS += "glib-2.0 libglibutil glib-2.0-native systemd libgbinder libdbusaccess file"
RDEPENDS:${PN} += "nfcd-mce-plugin"

SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE:${PN} = "nfcd.service"

do_compile:append() {
    oe_runmake release
}

do_install() {
    oe_runmake install DESTDIR=${D}
}

inherit pkgconfig
inherit systemd
