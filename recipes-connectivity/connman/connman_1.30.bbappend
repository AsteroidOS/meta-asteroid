FILESEXTRAPATHS_prepend := "${THISDIR}/connman:"
SRC_URI += " file://settings "

do_install_append() {
    install -d ${D}/var/lib/connman/
    cp ${WORKDIR}/settings ${D}/var/lib/connman/settings
}
