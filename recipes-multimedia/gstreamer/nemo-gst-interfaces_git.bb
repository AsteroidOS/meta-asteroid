SUMMARY = "Nemo mobile specific GStreamer interfaces"
HOMEPAGE = "https://github.com/sailfishos/nemo-gst-interfaces/tree/master"
LICENSE = "LGPL-2.1+"
LIC_FILES_CHKSUM = "file://COPYING;md5=4fbd65380cdd255951079008b364516c"

SRC_URI = "git://github.com/sailfishos/nemo-gst-interfaces.git;protocol=https"
SRCREV = "c1deaea7b52bbd12cea56c4ada69eba17cb602a8"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"
DEPENDS += "gstreamer1.0-plugins-base"

inherit autotools pkgconfig
