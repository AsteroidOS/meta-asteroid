SUMMARY = "Nemomobile's non graphical feedback daemon's hybris plugin"
HOMEPAGE = "https://github.com/mer-hybris/ngfd-plugin-droid-vibrator"
LICENSE = "LGPL-2.1-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=4fbd65380cdd255951079008b364516c"
PACKAGE_ARCH = "${MACHINE_ARCH}"

FILESEXTRAPATHS:append := "${THISDIR}/${PN}:"
SRC_URI = "git://github.com/mer-hybris/ngfd-plugin-droid-vibrator.git;protocol=https;branch=master \
           file://50-droid-vibrator.ini"
SRCREV = "569c3d835c0f93b1c03112aad7f8ed57e1592985"
PR = "r1"
PV = "+git${SRCPV}"
B = "${S}"

DEPENDS += "ngfd libhybris virtual/android-headers"

do_install:append () {
    install -d ${D}/usr/share/ngfd/plugins.d/
    cp ${UNPACKDIR}/50-droid-vibrator.ini ${D}/usr/share/ngfd/plugins.d/
}

inherit cmake pkgconfig

FILES:${PN} += "/usr/lib/ngf/ /usr/share/ngfd/plugins.d/"
FILES:${PN}-dbg += "/usr/lib/ngf/.debug/"
