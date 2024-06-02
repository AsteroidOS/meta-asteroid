SUMMARY = "Synchronize time from a non-writable real-time clock (RTC) using a cached file."
HOMEPAGE = "https://gitlab.com/postmarketOS/swclock-offset"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1b72c0c4f0ef6806f2bc255ef3ca61c1"

SRC_URI = "git://gitlab.com/postmarketOS/swclock-offset.git;protocol=https;branch=master"
SRCREV = "0.2.2"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"

SYSTEMD_SERVICE:${PN} = "swclock-offset-boot.service swclock-offset-shutdown.service"

do_configure[noexec] = "1"
do_compile[noexec] = "1"

do_install() {
    oe_runmake install DESTDIR=${D} PREFIX=${prefix}

    oe_runmake install_systemd DESTDIR=${D}/${prefix}
}

inherit systemd
