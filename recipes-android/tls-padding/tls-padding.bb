DESCRIPTION = "Reserve some TLS space."
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=8e3cdbf510d6bb5771a8ecbb40cd4fa3"
SRC_URI = "git://gitlab.com/ubports/development/core/hybris-support/tls-padding.git;protocol=https;branch=main \
    file://tls-padding.conf"
SRCREV = "c85ac0910effbf0197e43ba803536f2c7e289564"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"

inherit pkgconfig

EXTRA_OEMAKE = "KEEP_SYMBOLS=1"
PARALLEL_MAKE = ""
TARGET_CC_ARCH += "${LDFLAGS}"

do_install() {
    install -m 0755 -d ${D}${bindir}
    install -m 0755 ${S}/ld_preload_tls_padding.sh ${D}${bindir}
    install -d ${D}${libdir}/
    install -m 0644 ${S}/libtls-padding.so ${D}${libdir}/
    install -d ${D}${sysconfdir}/ld.so.conf.d/
    install -m 0644 ${WORKDIR}/tls-padding.conf ${D}${sysconfdir}/ld.so.conf.d/
}

FILES:${PN} += "${libdir}/libtls-padding.so"
FILES:${PN}-dev = "${includedir}"
