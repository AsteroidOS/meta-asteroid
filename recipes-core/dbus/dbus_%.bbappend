FILESEXTRAPATHS:prepend := "${THISDIR}/dbus:"
SRC_URI += "file://0001-dbus-sysdeps-Don-t-check-suid-bit-before-accessing-e.patch \
            file://session-local.conf"

do_install:append() {
    install -d ${D}/usr/share/dbus-1/session.d/
    cp ${WORKDIR}/session-local.conf ${D}/usr/share/dbus-1/session.d/session-local.conf
}
