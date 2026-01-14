DESCRIPTION = "Provides the device specific configuration files used by bluetooth-rfkill-daemon"
PR = "r0"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"
S = "${UNPACKDIR}/sources"

PACKAGE_ARCH = "${MACHINE_ARCH}"

do_install() {
    # Copy Bluetoth device configuration files.
    install -d ${D}${datadir}/bluetooth-rfkill-event/
    install -m 0644 ${UNPACKDIR}/*.conf ${D}${datadir}/bluetooth-rfkill-event/

    # The config file is always required as it contains the instructions on how to start bluetooth-rfkill-event
    install -d ${D}${sysconfdir}/sysconfig
    install -m 0644 ${UNPACKDIR}/bluetooth-rfkill-event ${D}${sysconfdir}/sysconfig
}

FILES:${PN} += "${datadir}/bluetooth-rfkill-event/*"
