FILESEXTRAPATHS_prepend := "${THISDIR}/brcm-patchram-plus:"
SRC_URI += "file://patchram.service \
            file://patchram.sh"
LICENSE = "BSD"

PACKAGE_ARCH = "${MACHINE_ARCH}"

do_install_append() {
    install -d ${D}/lib/systemd/system/multi-user.target.wants/
    cp ${WORKDIR}/patchram.service ${D}/lib/systemd/system/
    ln -s ../patchram.service ${D}/lib/systemd/system/multi-user.target.wants/patchram.service

    install -d ${D}/usr/bin/
    cp ${WORKDIR}/patchram.sh ${D}/usr/bin/
    chmod +x ${D}/usr/bin/patchram.sh
}

FILES_${PN} += "/lib/systemd/system/"
RDEPENDS_${PN} += "rfkill bash"
