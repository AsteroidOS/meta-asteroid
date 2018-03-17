SUMMARY = "Nemomobile's non graphical feedback daemon's hybris plugin"
HOMEPAGE = "https://github.com/mer-hybris/ngfd-plugin-droid-vibrator"
LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://COPYING;md5=4fbd65380cdd255951079008b364516c"

SRC_URI = "git://github.com/mer-hybris/ngfd-plugin-droid-vibrator.git;protocol=https"
SRCREV = "d841e43dac31bebca3763001ac0ed958271aeb18"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"
B = "${S}"

DEPENDS += "ngfd libhybris"

inherit cmake

FILES_${PN} += "/usr/lib/ngf/ /usr/share/ngfd/plugins.d/"
FILES_${PN}-dbg += "/usr/lib/ngf/.debug/"
