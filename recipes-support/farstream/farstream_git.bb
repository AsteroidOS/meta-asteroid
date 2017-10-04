SUMMARY = "The Farstream (formerly Farsight) project is an effort to create a framework to deal with all known audio/video conferencing protocols"
HOMEPAGE = "https://freedesktop.org/wiki/Software/Farstream/"
LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://COPYING;md5=fbc093901857fcd118f065f900982c24"

SRC_URI = "https://freedesktop.org/software/farstream/releases/farstream/farstream-0.2.8.tar.gz"

SRC_URI[md5sum] = "a40d4c4bd0812c270069b9f97d74009b"
SRC_URI[sha256sum] = "2b3b9c6b4f64ace8c83e03d1da5c5a2884c1cae10b35471072b574201ab38908"

S = "${WORKDIR}/farstream-0.2.8/"

DEPENDS += "libnice glib-2.0-native"

inherit autotools pkgconfig

EXTRA_OECONF = " \
    --disable-debug \
    --disable-gtk-doc \
    --enable-introspection=no \
"
