SUMMARY = "Asteroid's default set of wallpapers, licensed under CC BY 2.0"
HOMEPAGE = "https://github.com/AsteroidOS/asteroid-wallpapers"
LICENSE = "CC-BY-2.0"
LIC_FILES_CHKSUM = "file://LICENSE_CCBY;md5=e5ae8a8ac3605e6baffcd72982f4703b"

SRC_URI = "git://github.com/AsteroidOS/asteroid-wallpapers;protocol=https;branch=1.0"
SRCREV = "716b6c12915da3b3c858efb9041cd097aa868090"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"

do_install() {
    install -d ${D}/usr/share/asteroid-launcher/wallpapers/
    cp ${S}/480x480/* ${D}/usr/share/asteroid-launcher/wallpapers/
}

FILES_${PN} = "/usr/share/asteroid-launcher/wallpapers/"
