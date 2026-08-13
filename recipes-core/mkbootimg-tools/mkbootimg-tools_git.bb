SUMMARY = "Tools to write Android boot images"
HOMEPAGE = "https://android.googlesource.com/platform/system/tools/mkbootimg"
LICENSE = "Apache-2.0"
SRC_URI = "git://android.googlesource.com/platform/system/tools/mkbootimg.git;protocol=https;branch=main;destsuffix=git/aosp"
LIC_FILES_CHKSUM = "file://aosp/mkbootimg.py;beginline=3;endline=15;md5=4b298fb007f09b49f4fd3c8bf859805e"
SRCREV = "d2bb0af5ba6d3198a3e99529c97eda1be0b5a093"
S = "${WORKDIR}/git"
PV = "git"

BBCLASSEXTEND = "native"

do_install() {
    install -d ${D}${bindir}/gki
    install -m 0755 ${S}/aosp/mkbootimg.py ${D}${bindir}/mkbootimg
    install -m 0755 ${S}/aosp/gki/certify_bootimg.py ${S}/aosp/gki/generate_gki_certificate.py ${D}${bindir}/gki
}
