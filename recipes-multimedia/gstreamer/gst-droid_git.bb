SUMMARY = "Droid plugin for GStreamer"
HOMEPAGE = "https://github.com/sailfishos/gst-droid"
LICENSE = "LGPL-2.1-or-later"
LIC_FILES_CHKSUM = "file://COPYING;md5=4fbd65380cdd255951079008b364516c"

inherit meson pkgconfig

SRC_URI = "git://github.com/sailfishos/gst-droid.git;protocol=https;branch=master \
           file://0001-Remove-references-to-mode-that-are-not-in-upstream-g.patch"
SRCREV = "cf2d5f9652364af471cac7d7f04388a7bab9448a"
PR = "r1"
PV = "+git${SRCPV}"

DEPENDS += "gstreamer1.0 gstreamer1.0-plugins-bad gstreamer1.0-plugins-base droidmedia gettext-native nemo-gst-interfaces libexif"

FILES:${PN} += "/usr/lib/gstreamer-1.0/libgstdroid.so"
FILES:${PN}-staticdev += "/usr/lib/gstreamer-1.0/libgstdroid.a"
