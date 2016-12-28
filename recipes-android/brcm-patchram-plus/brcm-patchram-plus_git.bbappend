FILESEXTRAPATHS_prepend := "${THISDIR}/brcm-patchram-plus:"
SRC_URI += "file://patchram.service"
LICENSE = "BSD"

SRC_URI = "git://github.com/AsteroidOS/brcm-patchram-plus.git;protocol=https"
S = "${WORKDIR}/git/"
SRCREV = "c8fbd5f45392c4bf3c12cec7e3f59c2b79bd7dfc"

PACKAGE_ARCH = "${MACHINE_ARCH}"

do_install_append() {
    install -d ${D}/lib/systemd/system/multi-user.target.wants/
    cp ${WORKDIR}/patchram.service ${D}/lib/systemd/system/
    ln -s ../patchram.service ${D}/lib/systemd/system/multi-user.target.wants/patchram.service
}

FILES_${PN} += "/lib/systemd/system/"
RDEPENDS_${PN} += "rfkill"
