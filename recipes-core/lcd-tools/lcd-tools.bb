DESCRIPTION = "Daemon backend to control LCD functions"
HOMEPAGE = "https://github.com/AsteroidOS/lcd-tools.git"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"

SRC_URI = "git://github.com/AsteroidOS/lcd-tools.git;branch=main;protocol=https"
SRCREV = "964a4134ec60081ce441050a98f5bc863fb2e777"
PR = "r0"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"
DEPENDS = "libhybris cli11 mlite qtbase"
inherit cmake_qt5 pkgconfig
PACKAGE_ARCH = "${MACHINE_ARCH}"

do_install:append() {
    install -d ${D}/usr/lib/systemd/user/
    install -d ${D}/usr/lib/systemd/user/default.target.wants/
    ln -s /usr/lib/systemd/user/lcd-sync-time.timer ${D}/usr/lib/systemd/user/default.target.wants/lcd-sync-time.timer
    ln -s /usr/lib/systemd/user/lcd-session-restart.service ${D}/usr/lib/systemd/user/default.target.wants/lcd-session-restart.service
}

FILES:${PN} += "/usr/lib/systemd/user/"
