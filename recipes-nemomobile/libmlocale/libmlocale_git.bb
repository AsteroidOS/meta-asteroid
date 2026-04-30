SUMMARY = "Meego Locale library"
HOMEPAGE = "https://github.com/sailfishos/libmlocale"
LICENSE = "LGPL-2.1-or-later"
LIC_FILES_CHKSUM = "file://LICENSE.LGPL;md5=7635eef25dff78f483059bf21a20686d"

SRC_URI = "git://github.com/sailfishos/libmlocale.git;protocol=https;branch=master"
SRCREV = "e187e54582584ac476d3b74b54d147362eb3bb85"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"

DEPENDS += "qtbase icu-native qttools-native"
inherit qt6-cmake

FILES:${PN}-dev += "/usr/share/mkspecs/ /usr/lib/libmlocale5.prl"
FILES:${PN}-dbg += "/usr/lib/libmlocale-benchmarks5 /usr/share/libmlocale-benchmarks5"
FILES:${PN} += "/usr/share/mlocale5"
