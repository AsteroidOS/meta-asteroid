SUMMARY = "telepathy-farstream is a GObject-based C library that uses Telepathy GLib, Farstream and GStreamer to handle the media streaming part of channels of type Call"

HOMEPAGE = "https://telepathy.freedesktop.org/wiki/Components/Telepathy-Farstream/"
LICENSE = "LGPL-2.1-or-later"
LIC_FILES_CHKSUM = "file://COPYING;md5=2071c52746eb125b27a40421186f5d80"

SRC_URI = "git://gitlab.freedesktop.org/telepathy/telepathy-farstream.git;protocol=https;branch=master \
           file://0001-Disable-introspection-and-gtk-doc.patch"
SRCREV = "cd5910078b9d8f46fa411c093895d5f73432779b"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"

DEPENDS += "glib-2.0 dbus dbus-glib telepathy-glib farstream"

EXTRA_OECONF += "--disable-Werror"

inherit autotools pkgconfig
