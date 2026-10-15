SUMMARY = "Set the kernel time zone from the system time zone"
DESCRIPTION = "systemd leaves the kernel time zone at UTC on boot. Android HALs read it \
through bionic's gettimeofday(), so set it at boot and on time zone and clock changes."
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-3.0-only;md5=c79ff39f19dfec6d293b95dea7b07891"

SRC_URI = "file://kernel-timezone.c \
           file://kernel-timezone.service \
           file://kernel-timezone.timer \
           "

S = "${UNPACKDIR}"

inherit systemd

SYSTEMD_SERVICE:${PN} = "kernel-timezone.service kernel-timezone.timer"

do_compile() {
    ${CC} ${CFLAGS} ${LDFLAGS} -o kernel-timezone kernel-timezone.c
}

do_install() {
    install -D -m 0755 kernel-timezone ${D}${sbindir}/kernel-timezone
    install -D -m 0644 kernel-timezone.service ${D}${systemd_system_unitdir}/kernel-timezone.service
    install -m 0644 kernel-timezone.timer ${D}${systemd_system_unitdir}/kernel-timezone.timer
}
