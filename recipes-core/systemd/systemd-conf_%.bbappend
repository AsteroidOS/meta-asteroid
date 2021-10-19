FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"
SRC_URI:append = " file://logind.conf"

do_install:append() {
    install -d ${D}/etc/systemd/
    install -m 0644 ${WORKDIR}/logind.conf ${D}/etc/systemd/logind.conf
}

FILES:${PN} += "/etc/systemd/logind.conf"