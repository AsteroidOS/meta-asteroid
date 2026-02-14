SUMMARY = "Telepathy-Qt is a Qt high-level binding for Telepathy"
HOMEPAGE = "https://telepathy.freedesktop.org/doc/telepathy-qt/"
LICENSE = "LGPL-2.1-or-later"
LIC_FILES_CHKSUM = "file://COPYING;md5=2d5025d4aa3495befef8f17206a5b0a1"

SRC_URI = "git://gitlab.freedesktop.org/telepathy/telepathy-qt.git;protocol=https;branch=master"
SRCREV = "188dece432d090809c5ad88a91cd573c5af61c09"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"

do_configure:append() {
    chmod +x ${S}/tools/*
}

EXTRA_OECMAKE += " \
    -DENABLE_EXAMPLES=OFF \
    -DENABLE_TESTS=OFF \
    "

DEPENDS += "qtbase telepathy-farstream"
inherit cmake_qt5 pkgconfig

FILES:${PN}-dev += "/usr/lib/cmake"
