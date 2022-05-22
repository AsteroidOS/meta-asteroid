SUMMARY = "Telepathy-Qt is a Qt high-level binding for Telepathy"
HOMEPAGE = "https://telepathy.freedesktop.org/doc/telepathy-qt/"
LICENSE = "LGPL-2.1+"
LIC_FILES_CHKSUM = "file://COPYING;md5=2d5025d4aa3495befef8f17206a5b0a1"

SRC_URI = "git://anongit.freedesktop.org/git/telepathy/telepathy-qt.git;protocol=https;branch=master \
           file://0001-Don-t-require-QtGui.patch \
           file://0002-Don-t-require-python.patch \
           file://0003-Disable-examples-compilation.patch \
           file://0004-Disable-tests-compilation.patch"
SRCREV = "744b64e59f1eaae86de1eaeda603d779af99b4a0"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"

do_configure:append() {
    chmod +x ${S}/tools/*
}

DEPENDS += "qtbase telepathy-farstream"
inherit cmake_qt5

FILES:${PN}-dev += "/usr/lib/cmake"
