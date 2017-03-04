SUMMARY = "Darko Theme for MeegoTouch"
HOMEPAGE = "https://github.com/nemomobile/meegotouch-theme-darko"
LICENSE = "CC-BY-3.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=88f871534ad2268001f05f4790685ea5"

SRC_URI = "git://github.com/nemomobile/meegotouch-theme-darko;protocol=https"
SRCREV = "756f041714943d6e3c24e9ea1fc1149d83192f5a"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"

RDEPENDS_${PN} += "nemo-theme-default"

do_install() {
    mkdir -p ${D}/usr/share/themes/darko/meegotouch/icons/
    install -m 644 index.theme ${D}/usr/share/themes/darko/

    install -m 644 meegotouch/icons/* ${D}/usr/share/themes/darko/meegotouch/icons/
    install -m 644 blanco/meegotouch/icons/* ${D}/usr/share/themes/darko/meegotouch/icons

    mkdir -p ${D}/usr/share/themes/darko/meegotouch/libmeegotouchviews/style/
    install -m 644 meegotouch/libmeegotouchviews/style/* ${D}/usr/share/themes/darko/meegotouch/libmeegotouchviews/style/

    mkdir -p ${D}/usr/share/themes/darko/meegotouch/libmeegotouchhome/style/
    install -m 644 meegotouch/libmeegotouchhome/style/* ${D}/usr/share/themes/darko/meegotouch/libmeegotouchhome/style/
    install -m 644 meegotouch/libmeegotouchhome/libmeegotouchhome.conf ${D}/usr/share/themes/darko/meegotouch/libmeegotouchhome/

    mkdir -p ${D}/usr/share/themes/darko/meegotouch/meegotouchhome/style/
    install -m 644 meegotouch/meegotouchhome/style/meegotouchhome.css ${D}/usr/share/themes/darko/meegotouch/meegotouchhome/style/

    mkdir -p ${D}/usr/share/themes/base/meegotouch/icons/
    install -m 644 meegotouch/icons/icon-l-meegotouchtheme-darko.png ${D}/usr/share/themes/base/meegotouch/icons/

    mkdir -p ${D}/usr/share/sounds/darko/stereo/
    install -m 644 sounds/darko/stereo/* ${D}/usr/share/sounds/darko/stereo/
}

FILES_${PN} = "/usr/"
