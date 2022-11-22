SUMMARY = "SailfishOS D-Bus access control library"
HOMEPAGE = "https://github.com/sailfishos/libdbusaccess"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3c402472f78e29b699385e25fd89b4a9"

SRC_URI = "git://github.com/sailfishos/libdbusaccess.git;protocol=https;branch=master"
SRCREV = "a311a847c4b6c5bd154858dec63bd5103d11cf63"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"

DEPENDS += "glib-2.0 libglibutil glib-2.0-native systemd libgbinder bison-native"

EXTRA_OEMAKE = "KEEP_SYMBOLS=1"

do_install() {
	oe_runmake install DESTDIR=${D}
	oe_runmake install-dev DESTDIR=${D}
}

inherit pkgconfig
inherit systemd
