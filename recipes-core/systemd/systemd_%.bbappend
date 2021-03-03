FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
SRC_URI_append = " file://50-video.rules \
                  file://65-android.rules"

do_install_append() {
    # Setup udev rules for the rights of Android and graphic cards specific devices
    install -m 0644 ${WORKDIR}/50-video.rules ${D}${sysconfdir}/udev/rules.d/50-video.rules
    install -m 0644 ${WORKDIR}/65-android.rules ${D}${sysconfdir}/udev/rules.d/65-android.rules

    # Enables auto-login for ceres
    install -d ${D}/var/lib/systemd/linger
    touch ${D}/var/lib/systemd/linger/ceres
    sed -i "s@agetty --noclear @agetty --autologin ceres @" ${D}/lib/systemd/system/getty@.service
}

PACKAGECONFIG_append += "pam"

PACKAGECONFIG_remove = "rfkill"

PACKAGECONFIG_remove = "timesyncd"

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
