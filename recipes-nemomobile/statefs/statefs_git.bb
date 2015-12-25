SUMMARY = "Plugin-based filesystem to access and change the state of the system "
HOMEPAGE = "http://nemomobile.github.io/statefs/"
LICENSE = "LGPL-2.1+"
LIC_FILES_CHKSUM = "file://LICENSE;md5=f16c63ad20517dd81888a9ee32c4a0d4"

SRC_URI = "git://github.com/nemomobile/statefs;protocol=https"
SRCREV = "06e6d91e45cacc43f05ba739aec4ffc1163d2cf6"
PR = "r1"
PV = "+git${SRCREV}"
S = "${WORKDIR}/git"

DEPENDS += "boost fuse cor"
EXTRA_OECMAKE=" -DVERSION=0.3.0"

inherit cmake

B = "${WORKDIR}/git"

do_configure_prepend() {
    sed -i "/examples/d" CMakeLists.txt
}

FILES_${PN} += "/usr/lib/systemd"
FILES_${PN}-dbg += "/opt/"
