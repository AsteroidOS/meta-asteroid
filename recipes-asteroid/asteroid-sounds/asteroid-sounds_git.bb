SUMMARY = "Default set of sounds for AsteroidOS under CC0"
HOMEPAGE = "https://github.com/AsteroidOS/asteroid-sounds"
LICENSE = "CC0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2c1c00f9d3ed9e24fa69b932b7e7aff2"

SRC_URI = "git://github.com/AsteroidOS/asteroid-sounds;protocol=https;branch=master"
SRCREV = "${AUTOREV}"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"

do_install() {
    install -d ${D}/usr/share/sounds/
    cp ${S}/src/* ${D}/usr/share/sounds/
}

FILES:${PN} = "/usr/share/sounds/"
