DESCRIPTION = "Provides the device specific configuration files used by asteroid-launcher."
PR = "r0"
SRC_URI = "file://default.conf \
    file://keys.kmap"
SRC_URI:append:qemux86 = " file://qemu.conf file://kms-qemu.json"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"
S = "${WORKDIR}"

PACKAGE_ARCH = "${MACHINE_ARCH}"

DEPENDS += "qttools-native"

do_install() {
    install -d ${D}/var/lib/environment/compositor/
    install -m 0644 ${WORKDIR}/default.conf ${D}/var/lib/environment/compositor/
    if [ -f ${WORKDIR}/qemu.conf ] ; then
        # Overwrite the default config.
        install -m 0644 ${WORKDIR}/qemu.conf ${D}/var/lib/environment/compositor/default.conf
        install -m 0644 ${WORKDIR}/kms-qemu.conf ${D}/var/lib/environment/compositor/
    fi

    install -d ${D}/usr/share/qt5/keymaps/
    ${STAGING_BINDIR_NATIVE}/kmap2qmap ${WORKDIR}/keys.kmap ${D}/usr/share/qt5/keymaps/keys.qmap
}

FILES:${PN} += "/usr/share/qt5/keymaps/keys.qmap"

