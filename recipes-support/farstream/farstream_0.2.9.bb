SUMMARY = "The Farstream (formerly Farsight) project is an effort to create a framework to deal with all known audio/video conferencing protocols"
HOMEPAGE = "https://freedesktop.org/wiki/Software/Farstream/"
LICENSE = "LGPL-2.1-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=fbc093901857fcd118f065f900982c24"

# Patches are from Debian:
# http://deb.debian.org/debian/pool/main/f/farstream-0.2/farstream-0.2_0.2.9-2.debian.tar.xz
SRC_URI = " \
    https://freedesktop.org/software/farstream/releases/farstream/farstream-${PV}.tar.gz \
    file://0001-build-Adapt-to-backwards-incompatible-change-in-GNU-Make-.patch \
    file://0002-rawudp-upnp-test-Also-build-against-new-GUPnP-1.2-library.patch \
    file://0003-Build-with-gunp-igd-1.6.patch \
    "
SRC_URI[sha256sum] = "cb7d112433cf7c2e37a8ec918fb24f0ea5cb293cfa1002488e431de26482f47b"

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
