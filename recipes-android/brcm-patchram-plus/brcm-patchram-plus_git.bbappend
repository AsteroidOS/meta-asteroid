FILESEXTRAPATHS:prepend := "${THISDIR}/brcm-patchram-plus:"
SRC_URI:append= " file://patchram.service"
LICENSE = "Apache-2.0"

SRC_URI = "git://github.com/AsteroidOS/brcm-patchram-plus.git;protocol=https;branch=master"
S = "${WORKDIR}/git"
SRCREV = "94fb127e614b19a9a95561b8c1a0716e2e1e6293"

PACKAGE_ARCH = "${MACHINE_ARCH}"

do_install:append() {
    install -d ${D}/lib/systemd/system/multi-user.target.wants/
    cp ${WORKDIR}/patchram.service ${D}/lib/systemd/system/
    ln -s ../patchram.service ${D}/lib/systemd/system/multi-user.target.wants/patchram.service
}

FILES:${PN} += "/lib/systemd/system/"
RDEPENDS:${PN} += "rfkill"
