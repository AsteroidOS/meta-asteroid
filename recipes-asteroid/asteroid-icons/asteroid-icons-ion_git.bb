SUMMARY = "Asteroid's default set of icons, based on Ion Icons"
HOMEPAGE = "https://github.com/AsteroidOS/asteroid-icons-ion"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=92e02b7236a0635eaf1478f8041b0602"

SRC_URI = "git://github.com/AsteroidOS/asteroid-icons-ion;protocol=https;branch=master"
SRCREV = "7941cd491296b79941cbdad0d4b72bd34810c5dc"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"

do_install() {
    install -d ${D}/usr/share/icons/asteroid/
    cp ${S}/src/* ${D}/usr/share/icons/asteroid/
}

FILES:${PN} = "/usr/share/icons/asteroid/"
