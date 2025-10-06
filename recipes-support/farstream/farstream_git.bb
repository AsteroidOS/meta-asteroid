SUMMARY = "The Farstream (formerly Farsight) project is an effort to create a framework to deal with all known audio/video conferencing protocols"
HOMEPAGE = "https://freedesktop.org/wiki/Software/Farstream/"
LICENSE = "LGPL-2.1-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=fbc093901857fcd118f065f900982c24"

# Latest release does not build
SRC_URI = "gitsm://gitlab.freedesktop.org/farstream/farstream.git;protocol=https;branch=master"
SRCREV = "7aef14654b44e08a7969c024725678d0d09d8d6c"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"

# TODO: Massage build system to remove gtk-doc dependency
DEPENDS += "libnice glib-2.0-native gstreamer1.0 gstreamer1.0-plugins-base gtk-doc-native"

inherit autotools pkgconfig

EXTRA_OECONF = " \
    --disable-debug \
    --disable-gtk-doc \
    --disable-gtk-doc-html \
    --enable-introspection=no \
"

FILES:${PN} += "/usr/lib/farstream-0.2/ /usr/lib/gstreamer-1.0/"
