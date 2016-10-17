SUMMARY = "Asteroid's default set of wallpapers, licensed under CC BY 2.0"
HOMEPAGE = "https://github.com/AsteroidOS/asteroid-wallpapers"
LICENSE = "CC-BY-2.0"
LIC_FILES_CHKSUM = "file://LICENSE_CCBY;md5=e5ae8a8ac3605e6baffcd72982f4703b"

SRC_URI = "git://github.com/AsteroidOS/asteroid-wallpapers;protocol=https"
SRCREV = "5639cd3acdf62d0092daf3b3c3a0d465607ce424"
PR = "r1"
PV = "+git${SRCREV}"
S = "${WORKDIR}/git"

do_install() {
    install -d ${D}/usr/share/asteroid-launcher/wallpapers/
    cp ${S}/320x320/* ${D}/usr/share/asteroid-launcher/wallpapers/
}

FILES_${PN} = "/usr/share/asteroid-launcher/wallpapers/"
