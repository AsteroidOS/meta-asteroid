SUMMARY = "Daemon and tool for watch coprocessors, second displays and hands"
HOMEPAGE = "https://github.com/MagneFire/asteroid-coprocessor"
LICENSE = "GPL-3.0-only & GPL-3.0-or-later"
LIC_FILES_CHKSUM = "file://LICENSE;md5=84dcc94da3adb52b53ae4fa38fe49e5d"

SRC_URI = "git://github.com/MagneFire/asteroid-coprocessor.git;protocol=https;branch=main"
SRCREV = "7b5c80a6534ca996e751a2d2c19ae90b35c70690"
PV = "1.0.0+git"

inherit qt6-cmake pkgconfig

DEPENDS += "qtbase libhybris mlite libgbinder"
PACKAGE_ARCH = "${MACHINE_ARCH}"

do_install:append() {
    install -d ${D}${systemd_user_unitdir}/default.target.wants ${D}${systemd_user_unitdir}/timers.target.wants
    ln -sf ../asteroid-coprocd.service ${D}${systemd_user_unitdir}/default.target.wants/
    ln -sf ../asteroid-coproc-sync-time.timer ${D}${systemd_user_unitdir}/timers.target.wants/
}

FILES:${PN} += "${systemd_user_unitdir} ${datadir}/dbus-1/services"
