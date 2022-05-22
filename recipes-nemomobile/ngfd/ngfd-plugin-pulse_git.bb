SUMMARY = "Nemomobile's non graphical feedback daemon's pulse plugin"
HOMEPAGE = "https://github.com/sailfishos/ngfd-plugin-pulse"
LICENSE = "LGPL-2.1-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=4fbd65380cdd255951079008b364516c"

SRC_URI = "git://github.com/sailfishos/ngfd-plugin-pulse.git;protocol=https;branch=master"
SRCREV = "277c45626720ddcb3e3e89f2262fed9ac56fabfa"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"
B = "${S}"

DEPENDS += "pulseaudio glib-2.0 libsndfile1 ngfd"

inherit cmake

FILES:${PN} += "/usr/lib/ngf/"
FILES:${PN}-dbg += "/usr/lib/ngf/.debug/"
