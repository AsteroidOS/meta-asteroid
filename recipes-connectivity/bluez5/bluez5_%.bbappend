FILESEXTRAPATHS:prepend := "${THISDIR}/bluez5:"
SRC_URI += "file://main.conf \
            file://bluetooth.service \
            file://bluetooth.conf \
            file://input.conf \
            file://0001-Advertise-hostname-in-BLE-ad-payload-to-have-a-recog.patch"

do_install:append() {
    install -d ${D}/etc/bluetooth/
    cp ${UNPACKDIR}/main.conf ${D}/etc/bluetooth/main.conf
    cp ${UNPACKDIR}/input.conf ${D}/etc/bluetooth/input.conf

    install -d ${D}${systemd_system_unitdir}
    cp ${UNPACKDIR}/bluetooth.service ${D}${systemd_system_unitdir}/bluetooth.service

    install -d ${D}/etc/dbus-1/system.d/
    cp ${UNPACKDIR}/bluetooth.conf ${D}/etc/dbus-1/system.d/
}

