FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
SRC_URI_append = "file://50-video.rules \
                  file://65-android.rules \
                  file://dbus.service \
                  file://dbus.socket \
                  file://dbus.conf"

do_install_append() {
    # Setup udev rules for the rights of Android and graphic cards specific devices
    install -m 0644 ${WORKDIR}/50-video.rules ${D}${sysconfdir}/udev/rules.d/50-video.rules
    install -m 0644 ${WORKDIR}/65-android.rules ${D}${sysconfdir}/udev/rules.d/65-android.rules

    # Enables auto-login for ceres
    sed -i "s@agetty --noclear @agetty --autologin ceres @" ${D}/lib/systemd/system/getty@.service
   
    # In current systemd versions we have to take care ourselves of the dbus user service, it should be handled in the next versions
    install -d ${D}/usr/lib/systemd/user/default.target.wants/
    install -m 0644 ${WORKDIR}/dbus.socket ${D}/usr/lib/systemd/user/dbus.socket
    install -m 0644 ${WORKDIR}/dbus.service ${D}/usr/lib/systemd/user/dbus.service
    ln -s ../dbus.socket ${D}/usr/lib/systemd/user/default.target.wants/dbus.socket
    ln -s ../dbus.service ${D}/usr/lib/systemd/user/default.target.wants/dbus.service
    install -d ${D}/etc/systemd/system/user@.service.d/
    install -m 0644 ${WORKDIR}/dbus.conf ${D}/etc/systemd/system/user@.service.d/dbus.conf
}

PACKAGECONFIG_append += "pam"
