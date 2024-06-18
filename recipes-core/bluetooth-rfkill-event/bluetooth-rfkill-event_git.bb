SUMMARY = "Bluetooth rfkill daemon, loads the Bluetooth firmware."
HOMEPAGE = "https://github.com/mer-hybris/bluetooth-rfkill-event"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://../COPYING;md5=22b918b77fd38d7d7651669e03bdfd10"

SRC_URI = "git://github.com/mer-hybris/bluetooth-rfkill-event.git;protocol=https;branch=master \
           file://0001-Add-support-for-using-a-custom-rfkill-device.patch;patchdir=.. \
           file://0002-Store-custom-Bluetooth-address.patch;patchdir=.. \
           file://0003-Fix-loading-the-service-file.patch;patchdir=.. \
           file://0004-Remove-sysconfig-file.patch;patchdir=.. \
           "
SRCREV = "f411db38e8f6b49403f2e9a320083630f990bcbc"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git/bluetooth-rfkill-event"

DEPENDS += "glib-2.0 bluez5"
RDEPENDS:${PN} += "rfkill bluetooth-rfkill-event-configs"

inherit pkgconfig
inherit systemd

SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE:${PN} = "bluetooth-rfkill-event.service"

do_install() {
	oe_runmake install INSTALL_ROOT=${D}
        rm -r ${D}/usr/lib/systemd/system/network.target.wants
}

FILES:${PN} += "${datadir}/libexec/bluetooth_rfkill_event/killall-wait.sh"