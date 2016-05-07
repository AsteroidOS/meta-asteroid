FILESEXTRAPATHS_prepend := "${THISDIR}/bluez5:"
SRC_URI += "file://main.conf \
            file://bluetooth.service"

do_install_append() {
    install -d ${D}/etc/bluetooth/
    cp ${WORKDIR}/main.conf ${D}/etc/bluetooth/main.conf
    install -d ${D}/lib/systemd/system/
    cp ${WORKDIR}/bluetooth.service ${D}/lib/systemd/system/bluetooth.service
}

PACKAGECONFIG_append += "experimental"
