DESCRIPTION = "Daemon backend to control LCD functions"
HOMEPAGE = "https://github.com/LecrisUT/lcd-tools.git"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=84dcc94da3adb52b53ae4fa38fe49e5d"


SRC_URI = "git://github.com/LecrisUT/lcd-tools.git;protocol=https"
SRCREV = "${AUTOREV}"
PR = "r0"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"
DEPENDS = "libhybris"
inherit cmake_qt5 pkgconfig
PACKAGE_ARCH = "${MACHINE_ARCH}"
COMPATIBLE_MACHINE = "catfish"

do_install:append() {
    install -d ${D}/etc/systemd/system/timers.target.wants/
    cp ${S}/lcd-sync-time.service ${D}/etc/systemd/system/
    cp ${S}/lcd-sync-time.timer ${D}/etc/systemd/system/
    ln -s ../lcd-sync-time.timer ${D}/etc/systemd/system/timers.target.wants/lcd-sync-time.timer
}

