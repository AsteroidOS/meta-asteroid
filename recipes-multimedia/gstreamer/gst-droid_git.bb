SUMMARY = "Droid plugin for GStreamer"
HOMEPAGE = "https://github.com/sailfishos/gst-droid"
LICENSE = "LGPL-2.1+"
LIC_FILES_CHKSUM = "file://COPYING;md5=4fbd65380cdd255951079008b364516c"

inherit autotools pkgconfig

SRC_URI = "git://github.com/sailfishos/gst-droid.git;protocol=https \
           file://0001-Remove-references-to-mode-that-are-not-in-upstream-g.patch"
SRCREV = "0aeb90829c4a26add975d53a8a4a228bf1cd4c59"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"
B = "${S}"
DEPENDS += "gstreamer1.0 gstreamer1.0-plugins-bad gstreamer1.0-plugins-base libhybris gettext-native nemo-gst-interfaces libexif"

do_configure:prepend() {
    sed -i "s@/usr/share/droidmedia/hybris.c@${STAGING_INCDIR}/droidmedia/hybris.c@" gst-libs/gst/droid/Makefile.am gst/Makefile.am
    sed -i "s@I/usr/include/droidmedia/@I${STAGING_INCDIR}/droidmedia/@" gst/droidcamsrc/Makefile.am gst/droideglsink/Makefile.am gst/droidcodec/Makefile.am gst/Makefile.am gst-libs/gst/droid/Makefile.am
    NOCONFIGURE=1 ${S}/autogen.sh
}

FILES:${PN} += "/usr/lib/gstreamer-1.0/libgstdroid.so"
FILES:${PN}-staticdev += "/usr/lib/gstreamer-1.0/libgstdroid.a"
