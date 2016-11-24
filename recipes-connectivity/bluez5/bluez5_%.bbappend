FILESEXTRAPATHS_prepend := "${THISDIR}/bluez5:"
SRC_URI += "file://main.conf \
            file://bluetooth.service \
            file://bluetooth.conf \
            file://advertise-name.patch"

do_install_append() {
    install -d ${D}/etc/bluetooth/
    cp ${WORKDIR}/main.conf ${D}/etc/bluetooth/main.conf

    install -d ${D}/lib/systemd/system/
    cp ${WORKDIR}/bluetooth.service ${D}/lib/systemd/system/bluetooth.service

    install -d ${D}/etc/dbus-1/system.d/
    cp ${WORKDIR}/bluetooth.conf ${D}/etc/dbus-1/system.d/
}

PACKAGECONFIG_append += "experimental"
