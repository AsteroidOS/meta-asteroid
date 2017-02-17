SUMMARY = "Nemomobile's non graphical feedback daemon's hybris plugin"
HOMEPAGE = "https://github.com/mer-hybris/ngfd-plugin-droid-vibrator"
LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://COPYING;md5=4fbd65380cdd255951079008b364516c"

SRC_URI = "git://github.com/mer-hybris/ngfd-plugin-droid-vibrator.git;protocol=https"
SRCREV = "f24783d57914ffccb8ea2a2bb207864be3e0e24b"
PR = "r1"
PV = "+git${SRCREV}"
S = "${WORKDIR}/git"
B = "${S}"

DEPENDS += "ngfd"

inherit cmake

FILES_${PN} += "/usr/lib/ngf/"
FILES_${PN}-dbg += "/usr/lib/ngf/.debug/"
