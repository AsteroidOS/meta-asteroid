SUMMARY = "Synchronize time from a non-writable real-time clock (RTC) using a cached file."
HOMEPAGE = "https://gitlab.com/postmarketOS/swclock-offset"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1b72c0c4f0ef6806f2bc255ef3ca61c1"

SRC_URI = "git://gitlab.com/postmarketOS/swclock-offset.git;protocol=https;branch=master"
SRCREV = "6a4e4dcee814c7cfc22e0f69a6dc510086cb7abf"
PR = "r1"
PV = "+git${SRCPV}"

SYSTEMD_SERVICE:${PN} = "swclock-offset-boot.service swclock-offset-shutdown.service"

do_configure[noexec] = "1"
do_compile[noexec] = "1"

do_install() {
    oe_runmake install DESTDIR=${D}

    # Remove OpenRC init files
    for d in swclock-offset-boot swclock-offset-shutdown; do
        rm ${D}/${sysconfdir}/init.d/$d
    done
}

inherit systemd
