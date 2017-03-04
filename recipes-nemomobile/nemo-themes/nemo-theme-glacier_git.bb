SUMMARY = "Glacier Theme for Nemo"
HOMEPAGE = "https://github.com/nemomobile-ux/nemo-theme-glacier.git"
LICENSE = "CC-BY-SA-3.0"
LIC_FILES_CHKSUM = "file://cc3/LICENSE.md;md5=cf7e5cf784e962ee361c8d468cebf569"

SRC_URI = "git://github.com/nemomobile-ux/nemo-theme-glacier.git;protocol=https"
SRCREV = "bb308f61a77cd935c82f9665d0b0b3d5e7e34670"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"
inherit qmake5

DEPENDS += "qtbase-native"

do_install_append() {
    cd ${D}/usr/share/themes/glacier/meegotouch/icons/
    ln -sf icon-app-terminal.png icon-l-terminal.png
    ln -sf icon-app-settings.png icon-l-settings.png
    ln -sf icon-app-screenshot.png icon-launcher-screenshot.png
}

FILES_${PN} = "/usr/"
