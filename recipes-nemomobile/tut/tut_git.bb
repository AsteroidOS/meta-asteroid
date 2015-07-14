SUMMARY = "TUT is a small and portable unit test framework for C++."
HOMEPAGE = "https://github.com/nemomobile/tut"
LICENSE = "LGPL-2.1+"
LIC_FILES_CHKSUM = "file://COPYING;md5=1ed345ec14e0abcb47bf8689dd00eea0"

SRC_URI = "git://github.com/nemomobile/tut;protocol=https"
SRCREV = "${AUTOREV}"
PR = "r1"
PV = "+git${SRCREV}"
S = "${WORKDIR}/git"

inherit waf

do_configure() {
    ./waf configure --prefix=$prefix --version=0.0.3
}
