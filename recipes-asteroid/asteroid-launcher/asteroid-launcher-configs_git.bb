DESCRIPTION = "Provides the device specific configuration files used by asteroid-launcher."
PR = "r0"
SRC_URI = "file://default.conf \
    file://keys.kmap"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"
S = "${WORKDIR}/sources"
UNPACKDIR = "${S}"

PACKAGE_ARCH = "${MACHINE_ARCH}"

DEPENDS += "qttools-native"

do_install() {
    install -d ${D}/var/lib/environment/compositor/
    install -m 0644 ${UNPACKDIR}/default.conf ${D}/var/lib/environment/compositor/

    install -d ${D}/usr/share/qt5/keymaps/
    ${STAGING_BINDIR_NATIVE}/kmap2qmap ${UNPACKDIR}/keys.kmap ${D}/usr/share/qt5/keymaps/keys.qmap
}

FILES:${PN} += "/usr/share/qt5/keymaps/keys.qmap"

