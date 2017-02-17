SUMMARY = "Nemomobile's time daemon's time zone data"
HOMEPAGE = "https://git.merproject.org/mer-core/tzdata-timed"
LICENSE = "PD"
LIC_FILES_CHKSUM = "file://legacy/copyright;md5=b103f1aabbbf321a0b6cf5056bca002e"

SRC_URI = "git://git.merproject.org/mer-core/tzdata-timed.git;protocol=https \
           file://0001-Fixes-build-and-avoid-md5sum-mismatch-with-GMT-timez.patch"
SRCREV = "5b8b301e6ea7ab55e46f67b3b0f3350241812852"
PR = "r1"
PV = "+git${SRCREV}"
S = "${WORKDIR}/git"
B = "${S}"

do_configure_append() {
	if [ ! -x /usr/sbin/zic ] && [ -x /usr/bin/zic ]; then
		sed -i "s,/usr/sbin/zic,/usr/bin/zic," "${S}/scripts/zone-generate.sh" "${S}/scripts/zone-list.sh"
	fi
}

do_install() {
    export INSTALL_ROOT=${D}
    oe_runmake install
}
