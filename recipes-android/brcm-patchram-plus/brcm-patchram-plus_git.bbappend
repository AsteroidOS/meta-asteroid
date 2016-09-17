FILESEXTRAPATHS_prepend := "${THISDIR}/brcm-patchram-plus:"
SRC_URI += "file://patchram.service"
LICENSE = "BSD"

PACKAGE_ARCH = "${MACHINE_ARCH}"

do_install_append() {
    install -d ${D}/lib/systemd/system/multi-user.target.wants/
    cp ${WORKDIR}/patchram.service ${D}/lib/systemd/system/
    ln -s ../patchram.service ${D}/lib/systemd/system/multi-user.target.wants/patchram.service
}

FILES_${PN} += "/lib/systemd/system/"
RDEPENDS_${PN} += "rfkill"
