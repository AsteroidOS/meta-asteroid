SUMMARY = "Nemo mobile specific GStreamer interfaces"
HOMEPAGE = "https://github.com/sailfishos/nemo-gst-interfaces/tree/master"
LICENSE = "LGPL-2.1-or-later"
LIC_FILES_CHKSUM = "file://COPYING;md5=4fbd65380cdd255951079008b364516c"

SRC_URI = "git://github.com/sailfishos/nemo-gst-interfaces.git;protocol=https;branch=master"
SRCREV = "f5e90300ab0e2cfea1739392cc47c7b62f9c1700"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"
DEPENDS += "gstreamer1.0-plugins-base"

inherit autotools pkgconfig
