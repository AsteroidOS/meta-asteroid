SUMMARY = "Synchronize time from a non-writable real-time clock (RTC) using a cached file."
HOMEPAGE = "https://gitlab.com/postmarketOS/swclock-offset"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1b72c0c4f0ef6806f2bc255ef3ca61c1"

SRC_URI = "git://gitlab.com/postmarketOS/swclock-offset.git;protocol=https;branch=master \
    file://swclock-offset.service"
SRCREV = "a7888660b23d722b26e86c1b31a909bd8ad84bd2"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"

SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE:${PN} = "swclock-offset.service"

do_configure[noexec] = "1"
do_compile[noexec] = "1"

do_install() {
    oe_runmake install DESTDIR=${D} PREFIX=${prefix}

    install -d ${D}${systemd_unitdir}/system
    install -m 0644 ${WORKDIR}/swclock-offset.service ${D}${systemd_unitdir}/system/
}

inherit systemd
