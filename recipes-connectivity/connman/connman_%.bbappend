FILESEXTRAPATHS_prepend := "${THISDIR}/connman:"
SRC_URI += "file://settings \
            file://connman-dbus.conf"

do_install_append() {
    install -d ${D}/var/lib/connman/
    cp ${WORKDIR}/settings ${D}/var/lib/connman/settings
    install -d ${D}/etc/dbus-1/system.d/
    cp ${WORKDIR}/connman-dbus.conf ${D}/etc/dbus-1/system.d/connman.conf
}
