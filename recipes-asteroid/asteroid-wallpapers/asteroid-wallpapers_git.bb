SUMMARY = "Asteroid's default set of wallpapers, licensed under CC BY 2.0"
HOMEPAGE = "https://github.com/AsteroidOS/asteroid-wallpapers"
LICENSE = "CC-BY-2.0"
LIC_FILES_CHKSUM = "file://LICENSE_CCBY;md5=e5ae8a8ac3605e6baffcd72982f4703b"

SRC_URI = "git://github.com/AsteroidOS/asteroid-wallpapers;protocol=https"
SRCREV = "53d1d0d02dff0dc7213ecdb4c54e8ca9a66c36d6"
PR = "r1"
PV = "+git${SRCREV}"
S = "${WORKDIR}/git"

do_install() {
    install -d ${D}/usr/share/asteroid-launcher/wallpapers/
    cp ${S}/320x320/* ${D}/usr/share/asteroid-launcher/wallpapers/
}

FILES_${PN} = "/usr/share/asteroid-launcher/wallpapers/"
