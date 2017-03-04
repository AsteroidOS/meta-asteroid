SUMMARY = "Nemomobile's non graphical feedback daemon's pulse plugin"
HOMEPAGE = "https://git.merproject.org/mer-core/ngfd-plugin-pulse"
LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://COPYING;md5=4fbd65380cdd255951079008b364516c"

SRC_URI = "git://git.merproject.org/mer-core/ngfd-plugin-pulse.git;protocol=https"
SRCREV = "277c45626720ddcb3e3e89f2262fed9ac56fabfa"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"
B = "${S}"

DEPENDS += "pulseaudio glib-2.0 libsndfile1 ngfd"

inherit cmake

FILES_${PN} += "/usr/lib/ngf/"
FILES_${PN}-dbg += "/usr/lib/ngf/.debug/"
