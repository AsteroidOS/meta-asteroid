DESCRIPTION = "Provides the device specific configuration files used by asteroid-launcher."
PR = "r0"
SRC_URI = "file://00-default.conf \
    file://10-platform.conf \
    file://10-platform-hybris.conf \
    file://20-device.conf \
    file://keys.kmap"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"
S = "${WORKDIR}/sources"
UNPACKDIR = "${S}"

PACKAGE_ARCH = "${MACHINE_ARCH}"

DEPENDS += "qttools-native"

# The compositor environment is merged from three orthogonal drop-ins (systemd
# reads them in name order): 00-default.conf is shared by every device,
# 10-platform.conf selects the QPA platform, and machines override the
# placeholder 20-device.conf with their port specifics via FILESEXTRAPATHS.
do_install() {
    install -d ${D}/var/lib/environment/compositor/
    install -m 0644 ${UNPACKDIR}/00-default.conf ${D}/var/lib/environment/compositor/
    install -m 0644 ${UNPACKDIR}/10-platform.conf ${D}/var/lib/environment/compositor/
    install -m 0644 ${UNPACKDIR}/20-device.conf ${D}/var/lib/environment/compositor/

    install -d ${D}/usr/share/qt6/keymaps/
    ${STAGING_BINDIR_NATIVE}/kmap2qmap ${UNPACKDIR}/keys.kmap ${D}/usr/share/qt6/keymaps/keys.qmap
}

# libhybris watches render through hwcomposer instead of the eglfs default.
do_install:append:hybris-machine() {
    install -m 0644 ${UNPACKDIR}/10-platform-hybris.conf ${D}/var/lib/environment/compositor/10-platform.conf
}

FILES:${PN} += "/usr/share/qt6/keymaps/keys.qmap"
