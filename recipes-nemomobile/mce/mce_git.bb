SUMMARY = "Nemomobile's MCE."
HOMEPAGE = "https://github.com/sailfishos/mce"
LICENSE = "LGPL-2.1+"
LIC_FILES_CHKSUM = "file://COPYING;md5=4fbd65380cdd255951079008b364516c"

SRC_URI = "gitsm://github.com/sailfishos/mce.git;protocol=https \
    file://0001-Double-tap-emulation-Adapts-the-state-machine-to-a-s.patch \
    file://0002-tilt-to-wake-Wake-screen-when-wrist-gesture-arrives.patch \
    file://0003-inactivity-Allow-activities-in-lockscreen-mode.-aste.patch \
    file://0004-Ambient-mode-Adapt-low-power-mode-to-allow-for-actua.patch \
    file://0005-Ambient-Mode-Wait-for-compositor-when-sending-enable.patch \
    file://0006-Ambient-Mode-Exit-ambient-mode-when-touch-is-detecte.patch \
    file://0007-powerkey-Also-suspend-on-palm-reports.patch \
    file://mce.service"
SRC_URI:append:qemux86 = " file://0001-Keep-screen-on-by-default-on-emulator.patch"
SRCREV = "51135ea73ae162ec7708415801505e10a6f3fe5f"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"

DEPENDS += "glib-2.0 libdsme libiphb systemd dbus-glib dbus libngf pkgconfig-native usb-moded"

do_install() {
    oe_runmake install DESTDIR=${D}
    install -m 0644 ${WORKDIR}/mce.service ${D}${systemd_system_unitdir}
    rm -r ${D}/var/run/
}

FILES:${PN} += " /run/mce /lib/systemd/system "
FILES:${PN}-dbg += "/usr/lib/mce/modules/.debug"
