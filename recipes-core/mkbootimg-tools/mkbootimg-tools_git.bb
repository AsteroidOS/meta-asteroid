SUMMARY = "A tool to read/write/update android boot images"
HOMEPAGE = "https://github.com/xiaolu/mkbootimg_tools"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://mkboot;beginline=1;endline=14;md5=7b23e8b2786c0da7fb7ff74d45637d54"

SRC_URI = "git://github.com/xiaolu/mkbootimg_tools;protocol=https;branch=master"
SRCREV = "df5b4ab37854e72e124d8108cbfb5a1b88ee3c63"
S = "${WORKDIR}/git"
PV = "git"

BBCLASSEXTEND = "native"

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${S}/mkboot ${D}${bindir}
    install -m 0755 ${S}/mkbootimg ${D}${bindir}
}

