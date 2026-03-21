SUMMARY = "Nemomobile's time daemon's time zone data"
HOMEPAGE = "https://github.com/sailfishos/tzdata-timed"
LICENSE = "PD"
LIC_FILES_CHKSUM = "file://legacy/copyright;md5=b103f1aabbbf321a0b6cf5056bca002e"

SRC_URI = "git://github.com/sailfishos/tzdata-timed.git;protocol=https;branch=master"
SRCREV = "6e1ad52d5a0c45a555f0eab0a3a197a4cefa5a89"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"
B = "${S}"

do_configure:append() {
	if [ ! -x /usr/sbin/zic ] && [ -x /usr/bin/zic ]; then
		sed -i "s,/usr/sbin/zic,/usr/bin/zic," "${S}/scripts/zone-generate.sh" "${S}/scripts/zone-list.sh"
	fi
}

do_install() {
    export DESTDIR=${D}
    oe_runmake install
}
