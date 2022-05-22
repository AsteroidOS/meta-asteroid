SUMMARY = "Nemomobile's time daemon's time zone data"
HOMEPAGE = "https://github.com/sailfishos/tzdata-timed"
LICENSE = "PD"
LIC_FILES_CHKSUM = "file://legacy/copyright;md5=b103f1aabbbf321a0b6cf5056bca002e"

SRC_URI = "git://github.com/sailfishos/tzdata-timed.git;protocol=https;branch=master \
           file://0001-Fixes-build-and-avoid-md5sum-mismatch-with-GMT-timez.patch"
SRCREV = "5b8b301e6ea7ab55e46f67b3b0f3350241812852"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"
B = "${S}"

DEPENDS = "pcre-native"

do_configure:append() {
	if [ ! -x /usr/sbin/zic ] && [ -x /usr/bin/zic ]; then
		sed -i "s,/usr/sbin/zic,/usr/bin/zic," "${S}/scripts/zone-generate.sh" "${S}/scripts/zone-list.sh"
	fi
}

do_install() {
    export INSTALL_ROOT=${D}
    oe_runmake install
}
