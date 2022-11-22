SUMMARY = "nfcd plugin for mce-based device state tracking.."
HOMEPAGE = "https://github.com/mer-hybris/nfcd-mce-plugin.git"
LICENSE = "LGPL-2.1-or-later"
LIC_FILES_CHKSUM = "file://LICENSE;md5=bfbedcf6cc318e76a7b5ecb7d72ecaa0"

SRC_URI = "git://github.com/mer-hybris/nfcd-mce-plugin.git;protocol=https;branch=master"
SRCREV = "87e762e063f9c645762ee7e4bb6f9d1df80a052b"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"

DEPENDS = "libnciplugin libmce-glib"

do_install() {
    oe_runmake install DESTDIR=${D}
}

inherit pkgconfig

FILES:${PN} += "${libdir}/nfcd/plugins/mce.so"