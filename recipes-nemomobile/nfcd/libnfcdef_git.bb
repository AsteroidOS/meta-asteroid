SUMMARY = "Library for parsing and building NFC Data Exchange Format (NDEF) messages"
HOMEPAGE = "https://github.com/sailfishos/libnfcdef"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=079790c65d0b2c41b0eee3221c6b3f4a"

SRC_URI = "git://github.com/sailfishos/libnfcdef.git;protocol=https;branch=master"
SRCREV = "6af3f74a830d5cfe57e146d35ed34a858f14f69c"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"

EXTRA_OEMAKE = "KEEP_SYMBOLS=1 INSTALL_SYSTEMD_DIR=${D}${systemd_unitdir}/system/"

DEPENDS += "glib-2.0 libglibutil glib-2.0-native"

do_compile:append() {
    oe_runmake release
}

do_install() {
    oe_runmake install DESTDIR=${D}
}

inherit pkgconfig
