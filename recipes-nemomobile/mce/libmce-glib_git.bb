SUMMARY = "Mce glib bindings."
HOMEPAGE = "https://github.com/sailfishos/libmce-glib"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e8bb33b697424420fc8b5633344bdf0f"

SRC_URI = "git://github.com/sailfishos/libmce-glib.git;protocol=https;branch=master"
SRCREV = "49cff7f515979777d137cbb6a78076a50fdb99f2"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"

DEPENDS += "glib-2.0 glib-2.0-native libglibutil mcedevel"

EXTRA_OEMAKE = "KEEP_SYMBOLS=1"

do_install() {
	oe_runmake install-dev DESTDIR=${D}
}

inherit pkgconfig
