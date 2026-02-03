SUMMARY = "Android media wrapper library"
HOMEPAGE = "https://github.com/sailfishos/droidmedia"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://droidmedia.h;beginline=1;endline=18;md5=0500d15dde64c5743487615931c8cc3e"

inherit meson pkgconfig

SRC_URI = "git://github.com/sailfishos/droidmedia.git;protocol=https;branch=master"
SRCREV = "5c859c50de3ff1007fb15e9b4a955a63be956804"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"