SUMMARY = "Tool to convert Android sparse images"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://img2simg.cpp;beginline=1;endline=15;md5=69dd3a3cbb50842da4c61d01ee32f421"

SRC_URI = "git://github.com/AsteroidOS/android-simg2img.git;protocol=https;branch=master"
SRCREV = "25866381ea14caffec1d069d4226793b2d28a6a2"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"

do_install() {
    install -d ${D}${bindir}
    install -m 755 append2simg ${D}${bindir}/
    install -m 755 img2simg ${D}${bindir}/
    install -m 755 simg2img ${D}${bindir}/
    install -m 755 simg2simg ${D}${bindir}/
    install -m 755 simg_dump.py ${D}${bindir}/
}

DEPENDS += "zlib"

BBCLASSEXTEND = "native nativesdk"
