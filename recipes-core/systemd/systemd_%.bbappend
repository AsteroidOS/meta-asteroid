FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"
SRC_URI:append:hybris-machine = " file://50-video.rules \
                  file://65-android.rules"

do_install:append() {
    # Enables auto-login for ceres
    install -d ${D}/var/lib/systemd/linger
    touch ${D}/var/lib/systemd/linger/ceres
    sed -i "s@agetty --noclear @agetty --autologin ceres @" ${D}${systemd_system_unitdir}/getty@.service
}

do_install:append:hybris-machine() {
    # Setup udev rules for the rights of Android and graphic cards specific devices
    install -m 0644 ${WORKDIR}/50-video.rules ${D}${sysconfdir}/udev/rules.d/50-video.rules
    install -m 0644 ${WORKDIR}/65-android.rules ${D}${sysconfdir}/udev/rules.d/65-android.rules
}

PACKAGECONFIG:append = " pam"

PACKAGECONFIG:remove = "rfkill"

PACKAGECONFIG:remove = "timesyncd"

RRECOMMENDS:${PN}:remove = "udev-hwdb"

ALTERNATIVE:${PN} += "usrsbinhalt usrsbinreboot usrsbinshutdown usrsbinpoweroff"

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
