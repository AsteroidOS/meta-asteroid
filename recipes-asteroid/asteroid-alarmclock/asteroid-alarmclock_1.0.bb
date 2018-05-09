SUMMARY = "Asteroid's alarm clock app"
HOMEPAGE = "https://github.com/AsteroidOS/asteroid-alarmclock.git"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=84dcc94da3adb52b53ae4fa38fe49e5d"

SRC_URI = "git://github.com/AsteroidOS/asteroid-alarmclock.git;protocol=https;branch=1.0"
SRCREV = "56cd8a8c869c1fb431c22a72f907c765ac34a6ef"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"
inherit qmake5

DEPENDS += "qml-asteroid nemo-qml-plugin-alarms qttools-native"
RDEPENDS_${PN} += "nemo-qml-plugin-alarms"
FILES_${PN} += "/usr/share/translations/ /usr/lib/systemd/user/alarmpresenter.service /usr/share/dbus-1/services/com.nokia.voland.service"

do_install_append() {
    lrelease -idbased ${S}/alarmclock/i18n/asteroid-alarmclock.*.ts
    install -d ${D}/usr/share/translations/
    cp ${S}/alarmclock/i18n/asteroid-alarmclock.*.qm ${D}/usr/share/translations/
}
