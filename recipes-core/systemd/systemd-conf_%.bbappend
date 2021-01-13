FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
SRC_URI_append = " file://logind.conf"

do_install_append() {
    install -d ${D}/etc/systemd/
    install -m 0644 ${WORKDIR}/logind.conf ${D}/etc/systemd/logind.conf
}

FILES_${PN} += "/etc/systemd/logind.conf"