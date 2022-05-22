SUMMARY = "Nemomobile's libshadowutils"
HOMEPAGE = "https://github.com/sailfishos/libshadowutils"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://COPYING;md5=08c553a87d4e51bbed50b20e0adcaede"

SRC_URI = "git://github.com/sailfishos/libshadowutils.git;protocol=https;branch=master"
SRCREV = "c26249a780a81281a0ecdf44ffa8b37a13185966"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"

inherit cmake
