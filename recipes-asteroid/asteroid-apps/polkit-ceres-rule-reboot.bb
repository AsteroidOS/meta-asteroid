DESCRIPTION = "Add rule to allow ceres user to reboot via system dbus"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-3.0-only;md5=c79ff39f19dfec6d293b95dea7b07891"

DEPENDS += "polkit"
RDEPENDS:${PN} += "polkit"
SRC_URI = "file://30-org.freedesktop.login1.rules"
S = "${UNPACKDIR}"

do_install() {
        install -m 700 -d ${D}${datadir}/polkit-1/rules.d
        chown polkitd:root ${D}/${datadir}/polkit-1/rules.d
        install -m 0755 ${UNPACKDIR}/30-org.freedesktop.login1.rules ${D}${datadir}/polkit-1/rules.d
}

FILES:${PN} += "${datadir}/polkit-1/rules.d"