SUMMARY = "Nemomobile's libshadowutils"
HOMEPAGE = "https://github.com/sailfishos/libshadowutils"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://COPYING;md5=c9a450b7be84eac23e6353efecb60b5b"

SRC_URI = "git://github.com/sailfishos-mirror/shadow.git;protocol=https;branch=master \
    file://0001-libshadowutils-Functions-from-Shadow-Tool-Suite-as-s.patch"
SRCREV = "cde08e422d8c179d4ba622da2290c31ec645c611"
PR = "r1"
PV = "+git${SRCPV}"

inherit cmake
