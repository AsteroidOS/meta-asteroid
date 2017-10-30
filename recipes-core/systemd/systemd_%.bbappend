FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
SRC_URI_append = " file://50-video.rules \
                  file://65-android.rules \
                  file://dbus.service \
                  file://dbus.socket \
                  file://dbus.conf \
                  file://logind.conf"

do_install_append() {
    # Setup udev rules for the rights of Android and graphic cards specific devices
    install -m 0644 ${WORKDIR}/50-video.rules ${D}${sysconfdir}/udev/rules.d/50-video.rules
    install -m 0644 ${WORKDIR}/65-android.rules ${D}${sysconfdir}/udev/rules.d/65-android.rules

    # Enables auto-login for ceres
    install -d ${D}/var/lib/systemd/linger
    touch ${D}/var/lib/systemd/linger/ceres
    sed -i "s@agetty --noclear @agetty --autologin ceres @" ${D}/lib/systemd/system/getty@.service

    # In current systemd versions we have to take care ourselves of the dbus user service, it should be handled in the next versions
    install -d ${D}/usr/lib/systemd/user/
    install -d ${D}/home/ceres/.config/systemd/user/default.target.wants/
    install -m 0644 ${WORKDIR}/dbus.socket ${D}/usr/lib/systemd/user/dbus.socket
    install -m 0644 ${WORKDIR}/dbus.service ${D}/usr/lib/systemd/user/dbus.service
    if [ ! -f ${D}/home/ceres/.config/systemd/user/default.target.wants/dbus.socket ]; then
        ln -s /usr/lib/systemd/user/dbus.socket ${D}/home/ceres/.config/systemd/user/default.target.wants/dbus.socket
        ln -s /usr/lib/systemd/user/dbus.service ${D}/home/ceres/.config/systemd/user/default.target.wants/dbus.service
    fi
    install -d ${D}/etc/systemd/system/user@.service.d/
    install -m 0644 ${WORKDIR}/dbus.conf ${D}/etc/systemd/system/user@.service.d/dbus.conf

    install -m 0644 ${WORKDIR}/logind.conf ${D}/etc/systemd/logind.conf
}

FILES_${PN} += "/home/ceres/.config/systemd/user/default.target.wants/"

PACKAGECONFIG_append += "pam"

RRECOMMENDS_${PN}_remove = "udev-hwdb"

ALTERNATIVE_${PN} += "usrsbinhalt usrsbinreboot usrsbinshutdown usrsbinpoweroff"

ALTERNATIVE_TARGET[usrsbinhalt] = "${base_bindir}/systemctl"
ALTERNATIVE_LINK_NAME[usrsbinhalt] = "${sbindir}/halt"
ALTERNATIVE_PRIORITY[usrsbinhalt] ?= "300"

ALTERNATIVE_TARGET[usrsbinreboot] = "${base_bindir}/systemctl"
ALTERNATIVE_LINK_NAME[usrsbinreboot] = "${sbindir}/reboot"
ALTERNATIVE_PRIORITY[usrsbinreboot] ?= "300"

ALTERNATIVE_TARGET[usrsbinshutdown] = "${base_bindir}/systemctl"
ALTERNATIVE_LINK_NAME[usrsbinshutdown] = "${sbindir}/shutdown"
ALTERNATIVE_PRIORITY[usrsbinshutdown] ?= "300"

ALTERNATIVE_TARGET[usrsbinpoweroff] = "${base_bindir}/systemctl"
ALTERNATIVE_LINK_NAME[usrsbinpoweroff] = "${sbindir}/poweroff"
ALTERNATIVE_PRIORITY[usrsbinpoweroff] ?= "300"
