SUMMARY = "Asteroid's default set of wallpapers, licensed under CC BY 2.0"
HOMEPAGE = "https://github.com/AsteroidOS/asteroid-wallpapers"
LICENSE = "CC-BY-2.0"
LIC_FILES_CHKSUM = "file://LICENSE_CCBY;md5=e5ae8a8ac3605e6baffcd72982f4703b"

SRC_URI = "git://github.com/AsteroidOS/asteroid-wallpapers;protocol=https;branch=master"
SRCREV = "${AUTOREV}"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"

do_install() {
    install -d ${D}/usr/share/asteroid-launcher/wallpapers/
    find ${S} -mindepth 1 -maxdepth 1 -type d -not -empty -not -name ".*" -exec cp -R {} ${D}/usr/share/asteroid-launcher/wallpapers/ \;
}

FILES:${PN} = "/usr/share/asteroid-launcher/wallpapers/"
