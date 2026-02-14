SUMMARY = "SailfishOS D-Bus access control library"
HOMEPAGE = "https://github.com/sailfishos/libdbusaccess"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=80264d9978170503c3f7b5e5eac1ccf1"

SRC_URI = "git://github.com/sailfishos/libdbusaccess.git;protocol=https;branch=master"
SRCREV = "7ff3b963fe549187179298191a8ba9f7a4261fd5"
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
