SUMMARY = "TUT is a small and portable unit test framework for C++."
HOMEPAGE = "https://github.com/sailfishos/tut"
LICENSE = "LGPL-2.1+"
LIC_FILES_CHKSUM = "file://COPYING;md5=1ed345ec14e0abcb47bf8689dd00eea0"

SRC_URI = "git://github.com/sailfishos/tut.git;protocol=https"
SRCREV = "70d36f056fb84ac902b0e240151e58412c5a30f1"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"

inherit waf

WAF_PYTHON = "/usr/bin/python2"

do_configure() {
    ${WAF_PYTHON} ${S}/waf configure --destdir=${B} -b ${B} --prefix=$prefix --version=0.0.3
}
