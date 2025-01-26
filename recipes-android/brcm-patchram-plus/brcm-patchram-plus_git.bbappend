FILESEXTRAPATHS:prepend := "${THISDIR}/brcm-patchram-plus:"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://COPYING;md5=afced5e0f9e7326a4866806c80685307"

SRC_URI = "git://github.com/AsteroidOS/brcm-patchram-plus.git;protocol=https;branch=master"
S = "${WORKDIR}/git"
SRCREV = "15bd6638dd6d3a37d22dbc18059f6d9eb885f057"

PACKAGE_ARCH = "${MACHINE_ARCH}"

do_install:append() {
    if [ -f ${UNPACKDIR}/patchram.service ] ; then
        install -d ${D}${systemd_system_unitdir}/multi-user.target.wants/
        cp ${UNPACKDIR}/patchram.service ${D}${systemd_system_unitdir}/
        ln -s ../patchram.service ${D}${systemd_system_unitdir}/multi-user.target.wants/patchram.service
    fi
}

FILES:${PN} += "${systemd_system_unitdir}"
RDEPENDS:${PN} += "rfkill"
