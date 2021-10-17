SUMMARY = "Meego Locale library"
HOMEPAGE = "https://github.com/sailfishos/libmlocale"
LICENSE = "LGPL-2.1+"
LIC_FILES_CHKSUM = "file://LICENSE.LGPL;md5=7635eef25dff78f483059bf21a20686d"

SRC_URI = "git://github.com/sailfishos/libmlocale.git;protocol=https \
           file://0001-Allow-for-deprecated-functions.patch \
           file://0002-Disable-tests-and-doc.patch \
           file://0003-configure-Use-a-usr-prefix-by-default.patch"
SRCREV = "5de5b558d05ce8fa1486dcf3ee76a13f4754cf03"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"

do_configure_prepend() {
    ../git/configure
}

DEPENDS += "qtbase icu-native qttools-native"
inherit qmake5

FILES_${PN}-dev += "/usr/share/mkspecs/ /usr/lib/libmlocale5.prl"
FILES_${PN}-dbg += "/usr/lib/libmlocale-benchmarks5 /usr/share/libmlocale-benchmarks5"
FILES_${PN} += "/usr/share/mlocale5"
