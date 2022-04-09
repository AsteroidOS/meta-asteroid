DESCRIPTION = "Daemon backend to control LCD functions"
HOMEPAGE = "https://github.com/AsteroidOS/lcd-tools.git"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"


SRC_URI = "git://github.com/AsteroidOS/lcd-tools.git;branch=main;protocol=https"
SRCREV = "${AUTOREV}"
PR = "r0"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"
DEPENDS = "libhybris cli11"
inherit cmake pkgconfig
PACKAGE_ARCH = "${MACHINE_ARCH}"
COMPATIBLE_MACHINE = "catfish"

do_install:append() {
    install -d ${D}/etc/systemd/system/timers.target.wants/
    ln -s ../lcd-sync-time.timer ${D}/etc/systemd/system/timers.target.wants/lcd-sync-time.timer
}

