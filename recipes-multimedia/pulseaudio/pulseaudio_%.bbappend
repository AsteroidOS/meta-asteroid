RDEPENDS:pulseaudio-server:append = " pulseaudio-modules-nemo pulseaudio-module-dbus-protocol pulseaudio-module-match pulseaudio-module-switch-on-connect pulseaudio-module-bluetooth-discover pulseaudio-module-bluetooth-policy pulseaudio-module-bluez5-discover pulseaudio-module-bluez5-device "
RDEPENDS:pulseaudio-server:append:hybris-machine = " pulseaudio-modules-droid "

FILESEXTRAPATHS:prepend := "${THISDIR}/pulseaudio:"
SRC_URI += "file://1002-build-Install-pulsecore-headers.patch \
            file://mainvolume-listening-time-notifier.conf \
            file://nemo-pulseaudio-parameters \
            file://x-maemo-stream-restore.table \
            file://x-maemo-restore.table \
            file://x-maemo-match.table \
            file://x-maemo-route.table \
            file://stream-restore.table \
            file://client.conf \
            file://default.pa"

do_install:append() {
    install -d ${D}/usr/lib/systemd/user/default.target.wants/
    if [ ! -f ${D}/usr/lib/systemd/user/default.target.wants/pulseaudio.service ]; then
        ln -s /usr/lib/systemd/user/pulseaudio.service ${D}/usr/lib/systemd/user/default.target.wants/pulseaudio.service
    fi

    mkdir ${D}/etc/pulse/client.conf.d/
    install -m 0644 ${UNPACKDIR}/default.pa ${D}/etc/pulse/default.pa
    install -m 0644 ${UNPACKDIR}/client.conf ${D}/etc/pulse/client.conf
    install -m 0644 ${UNPACKDIR}/stream-restore.table ${D}/etc/pulse/stream-restore.table
    install -m 0644 ${UNPACKDIR}/x-maemo-match.table ${D}/etc/pulse/x-maemo-match.table
    install -m 0644 ${UNPACKDIR}/x-maemo-route.table ${D}/etc/pulse/x-maemo-route.table
    install -m 0644 ${UNPACKDIR}/x-maemo-restore.table ${D}/etc/pulse/x-maemo-restore.table
    install -m 0644 ${UNPACKDIR}/x-maemo-stream-restore.table ${D}/etc/pulse/x-maemo-stream-restore.table
    install -m 0644 ${UNPACKDIR}/mainvolume-listening-time-notifier.conf ${D}/etc/pulse/mainvolume-listening-time-notifier.conf

    install -d ${D}/var/lib/
    cp -r ${UNPACKDIR}/nemo-pulseaudio-parameters ${D}/var/lib/nemo-pulseaudio-parameters
}

FILES:${PN}-server += "/usr/lib/systemd/user/default.target.wants/ /var/lib/nemo-pulseaudio-parameters"
