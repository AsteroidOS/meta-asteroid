DESCRIPTION = "Linux Firmware Loader Daemon"
DEPENDS += "udev glib-2.0"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE-APACHE;md5=7b486c2338d225a1405d979ed2c15ce8"

SRC_URI = "git://github.com/teg/firmwared;protocol=https \
           file://firmwared.service"
SRCREV = "2e6b5db43d63a5c0283a4cae9a6a20b7ad107a04"
S = "${WORKDIR}/git"

inherit autotools pkgconfig

do_configure_prepend() {
    ${S}/autogen.sh
}

do_install_append() {
    install -d ${D}/lib/systemd/system/basic.target.wants/
    cp ${WORKDIR}/firmwared.service ${D}/lib/systemd/system/
    ln -s ../firmwared.service ${D}/lib/systemd/system/basic.target.wants/firmwared.service
}

FILES_${PN} += "/lib/systemd/system/"
