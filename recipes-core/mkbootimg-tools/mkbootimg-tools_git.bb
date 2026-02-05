SUMMARY = "Tools to write Android boot images"
HOMEPAGE = "https://github.com/xiaolu/mkbootimg_tools & https://android.googlesource.com/platform/system/tools/mkbootimg"
LICENSE = "Apache-2.0"
SRC_URI = "git://github.com/xiaolu/mkbootimg_tools.git;protocol=https;branch=master;name=old;destsuffix=git/old \
           git://android.googlesource.com/platform/system/tools/mkbootimg.git;protocol=https;branch=main;name=aosp;destsuffix=git/aosp"
LIC_FILES_CHKSUM_old = "file://mkboot;beginline=1;endline=14;md5=7b23e8b2786c0da7fb7ff74d45637d54"
LIC_FILES_CHKSUM_aosp = "file://mkbootimg.py;beginline=3;endline=15;md5=81fd84b0a4fa565c3c651a81d026addc"
SRCREV_old = "df5b4ab37854e72e124d8108cbfb5a1b88ee3c63"
SRCREV_aosp = "d2bb0af5ba6d3198a3e99529c97eda1be0b5a093"
SRCREV_FORMAT = "old_aosp"
S = "${WORKDIR}/git"
PV = "git"

BBCLASSEXTEND = "native"

do_install() {
    install -d ${D}${bindir}/gki
    install -m 0755 ${S}/old/mkboot ${D}${bindir}
    install -m 0755 ${S}/aosp/mkbootimg.py ${D}${bindir}
    install -m 0755 ${S}/aosp/gki/certify_bootimg.py ${S}/aosp/gki/generate_gki_certificate.py ${D}${bindir}/gki
}