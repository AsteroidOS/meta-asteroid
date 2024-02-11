FILESEXTRAPATHS:prepend := "${THISDIR}/ofono:"
SRC_URI = "git://github.com/rilmodem/ofono;protocol=https;branch=master \
           file://ofono.service \
           file://ofono \
           file://use-python3.patch \
           file://0001-Makefile.am-Fixes-include-paths.patch"
SRCREV = "efc9c0a85d32706bc088e449e847be41dcc73b3d"

S = "${WORKDIR}/git"

DEPENDS += "c-ares"

EXTRA_OECONF:remove = "--enable-external-ell"

do_install:append() {
    install -d ${D}${systemd_system_unitdir}
    cp ${WORKDIR}/ofono.service ${D}${systemd_system_unitdir}/ofono.service
}
