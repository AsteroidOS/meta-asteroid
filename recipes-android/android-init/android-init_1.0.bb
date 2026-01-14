DESCRIPTION = "This installs an android-init service which loads /system/bin/init with the /init.rc file which loads logd and servicemanager"
PR = "r0"
SRC_URI = "file://init.rc \
    file://android-init.service \
    file://android-boot-completed.service"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"
S = "${UNPACKDIR}"

PACKAGE_ARCH = "${MACHINE_ARCH}"

do_install() {
    install -m 0644 ${UNPACKDIR}/init.rc ${D}/init.rc

    install -d ${D}${systemd_system_unitdir}/multi-user.target.wants/
    install -m 0644 ${UNPACKDIR}/android-init.service  ${D}${systemd_system_unitdir}/
    ln -s ../android-init.service ${D}${systemd_system_unitdir}/multi-user.target.wants/android-init.service

    install -d ${D}${systemd_user_unitdir}/default.target.wants/
    install -m 0644 ${UNPACKDIR}/android-boot-completed.service  ${D}${systemd_user_unitdir}/
    if [ ! -f ${D}${systemd_user_unitdir}/default.target.wants/android-boot-completed.service ]; then
        ln -s ${systemd_user_unitdir}/android-boot-completed.service ${D}${systemd_user_unitdir}/default.target.wants/android-boot-completed.service
    fi
}

FILES:${PN} += "/init.rc ${systemd_system_unitdir} ${systemd_user_unitdir}"
