SUMMARY = "Asteroid's weather app"
HOMEPAGE = "https://github.com/AsteroidOS/asteroid-weather.git"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=84dcc94da3adb52b53ae4fa38fe49e5d"

SRC_URI = "git://github.com/AsteroidOS/asteroid-weather.git;protocol=https"
SRCREV = "25fb0641dda27740a6bb433eab50ef255a18990f"
PR = "r1"
PV = "+git${SRCREV}"
S = "${WORKDIR}/git"
inherit qmake5

DEPENDS += "qml-asteroid mapplauncherd-booster-qtcomponents nemo-qml-plugin-configuration"
RDEPENDS_${PN} += "nemo-qml-plugin-configuration"
FILES_${PN} += "/usr/share/translations/ /usr/lib/fonts"

do_install_append() {
    lrelease ${S}/asteroid-weather.*.ts
    install -d ${D}/usr/share/translations/
    cp ${S}/asteroid-weather.*.qm ${D}/usr/share/translations/
}
