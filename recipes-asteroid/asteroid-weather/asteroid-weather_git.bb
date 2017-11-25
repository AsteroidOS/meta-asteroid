SUMMARY = "Asteroid's weather app"
HOMEPAGE = "https://github.com/AsteroidOS/asteroid-weather.git"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=84dcc94da3adb52b53ae4fa38fe49e5d"

SRC_URI = "git://github.com/AsteroidOS/asteroid-weather.git;protocol=https"
SRCREV = "${AUTOREV}"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"
inherit qmake5

DEPENDS += "qml-asteroid nemo-qml-plugin-configuration qttools-native"
RDEPENDS_${PN} += "nemo-qml-plugin-configuration"
FILES_${PN} += "/usr/share/translations/"

do_install_append() {
    lrelease -idbased ${S}/i18n/asteroid-weather.*.ts
    install -d ${D}/usr/share/translations/
    cp ${S}/i18n/asteroid-weather.*.qm ${D}/usr/share/translations/
}
