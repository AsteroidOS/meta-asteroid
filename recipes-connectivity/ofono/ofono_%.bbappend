FILESEXTRAPATHS:prepend := "${THISDIR}/ofono:"
SRC_URI = "git://github.com/rilmodem/ofono;protocol=https;branch=master \
           file://ofono.service \
           file://ofono \
           file://use-python3.patch \
           file://0001-Makefile.am-Fixes-include-paths.patch"
SRCREV = "efc9c0a85d32706bc088e449e847be41dcc73b3d"

LIC_FILES_CHKSUM = "file://COPYING;md5=eb723b61539feef013de476e68b5c50a \
                    file://src/ofono.h;beginline=1;endline=20;md5=3ce17d5978ef3445def265b98899c2ee"

DEPENDS += "c-ares"

EXTRA_OECONF:remove = "--enable-external-ell"

do_install:append() {
    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${UNPACKDIR}/ofono.service ${D}${systemd_system_unitdir}/ofono.service
}
