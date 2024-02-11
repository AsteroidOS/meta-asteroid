DESCRIPTION = "Linux Firmware Loader Daemon"
DEPENDS += "udev glib-2.0"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE-APACHE;md5=7b486c2338d225a1405d979ed2c15ce8"

SRC_URI = "git://github.com/teg/firmwared;protocol=https;branch=master \
           file://firmwared.service"
SRCREV = "2e6b5db43d63a5c0283a4cae9a6a20b7ad107a04"
S = "${WORKDIR}/git"

inherit autotools pkgconfig

do_configure:prepend() {
    ${S}/autogen.sh
}

do_install:append() {
    install -d ${D}${systemd_system_unitdir}/basic.target.wants/
    cp ${WORKDIR}/firmwared.service ${D}${systemd_system_unitdir}/
    ln -s ../firmwared.service ${D}${systemd_system_unitdir}/basic.target.wants/firmwared.service
}

FILES:${PN} += "${systemd_system_unitdir}"
