SUMMARY = "Android media wrapper library"
HOMEPAGE = "https://github.com/sailfishos/droidmedia"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://droidmedia.h;beginline=1;endline=18;md5=0500d15dde64c5743487615931c8cc3e"

inherit meson pkgconfig

SRC_URI = "git://github.com/sailfishos/droidmedia.git;protocol=https;branch=master"
SRCREV = "8829b9dcd3b67ea6ea75a5fe17c408d79fb17bc5"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"