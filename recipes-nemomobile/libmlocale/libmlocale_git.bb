SUMMARY = "Meego Locale library"
HOMEPAGE = "https://github.com/sailfishos/libmlocale"
LICENSE = "LGPL-2.1-or-later"
LIC_FILES_CHKSUM = "file://LICENSE.LGPL;md5=7635eef25dff78f483059bf21a20686d"

SRC_URI = "git://github.com/sailfishos/libmlocale.git;protocol=https;branch=master \
           file://0001-Allow-for-deprecated-functions.patch \
           file://0002-Disable-tests-and-doc.patch \
           file://0003-configure-Use-a-usr-prefix-by-default.patch \
           file://0004-Do-not-check-for-icu.patch \
           "
SRCREV = "335e27ec57ef6e17ae10d3b0918ff662a3653d05"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"

do_configure:prepend() {
    ${S}/configure
}

DEPENDS += "qtbase icu-native qttools-native"
inherit qmake5

FILES:${PN}-dev += "/usr/share/mkspecs/ /usr/lib/libmlocale5.prl"
FILES:${PN}-dbg += "/usr/lib/libmlocale-benchmarks5 /usr/share/libmlocale-benchmarks5"
FILES:${PN} += "/usr/share/mlocale5"
