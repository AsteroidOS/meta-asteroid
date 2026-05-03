SUMMARY = "Tool for packing multiple DTB/DTBO files into a single image"
HOMEPAGE = "https://android.googlesource.com/platform/system/libufdt"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://NOTICE;md5=3f52ca43505196dea390350987d6a022"

SRC_URI = "git://android.googlesource.com/platform/system/libufdt;protocol=https;branch=main-kernel"
SRCREV = "30486c8b56ac46b2a368918f8851618488832caf"
S = "${WORKDIR}/git"
PV = "git"

BBCLASSEXTEND = "native"

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${S}/utils/src/mkdtboimg.py ${D}${bindir}/mkdtboimg
}
