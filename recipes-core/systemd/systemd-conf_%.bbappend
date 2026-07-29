FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"
SRC_URI:append = " file://powerkey.conf"

do_install:append() {
    install -d ${D}/etc/systemd/logind.conf.d/
    install -m 0644 ${UNPACKDIR}/powerkey.conf ${D}/etc/systemd/logind.conf.d/10-powerkey.conf
}

FILES:${PN} += "/etc/systemd/logind.conf.d/"
