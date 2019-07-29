SUMMARY = "Nemo mobile specific GStreamer interfaces"
HOMEPAGE = "https://git.merproject.org/mer-core/nemo-gst-interfaces/tree/master"
LICENSE = "LGPL-2.1+"
LIC_FILES_CHKSUM = "file://COPYING;md5=4fbd65380cdd255951079008b364516c"

SRC_URI = "git://git.merproject.org/mer-core/nemo-gst-interfaces.git;protocol=https \
           file://0001-NemoGstBufferOrientationMeta-Define-a-default-init-f.patch"
SRCREV = "d6ce2383b1c3e8f2d38297f29b3dc6fffd2b899e"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"
DEPENDS += "gstreamer1.0-plugins-base"

inherit autotools pkgconfig
