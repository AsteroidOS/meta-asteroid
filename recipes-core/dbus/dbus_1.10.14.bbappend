FILESEXTRAPATHS_prepend := "${THISDIR}/dbus:"
SRC_URI += "file://0001-dbus-sysdeps-Don-t-check-suid-bit-before-accessing-e.patch \
            file://session-local.conf"

do_install_append() {
    cp ${WORKDIR}/session-local.conf ${D}/usr/share/dbus-1/session.d/session-local.conf
}
