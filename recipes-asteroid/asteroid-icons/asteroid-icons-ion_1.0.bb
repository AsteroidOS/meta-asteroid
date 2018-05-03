SUMMARY = "Asteroid's default set of icons, based on Ion Icons"
HOMEPAGE = "https://github.com/AsteroidOS/asteroid-icons-ion"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=92e02b7236a0635eaf1478f8041b0602"

SRC_URI = "git://github.com/AsteroidOS/asteroid-icons-ion;protocol=https;branch=1.0"
SRCREV = "fd44a89a9f91b2e1b849b2cc33653ed3de957aea"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"

do_install() {
    install -d ${D}/usr/share/icons/asteroid/
    cp ${S}/src/* ${D}/usr/share/icons/asteroid/
}

FILES_${PN} = "/usr/share/icons/asteroid/"
