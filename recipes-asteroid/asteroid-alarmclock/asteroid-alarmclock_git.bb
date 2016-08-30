SUMMARY = "Asteroid's alarm clock app"
HOMEPAGE = "https://github.com/AsteroidOS/asteroid-alarmclock.git"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=84dcc94da3adb52b53ae4fa38fe49e5d"

SRC_URI = "git://github.com/AsteroidOS/asteroid-alarmclock.git;protocol=https"
SRCREV = "${AUTOREV}"
PR = "r1"
PV = "+git${SRCREV}"
S = "${WORKDIR}/git"
inherit qmake5

DEPENDS += "qml-asteroid mapplauncherd-booster-qtcomponents nemo-qml-plugin-alarms"
RDEPENDS_${PN} += "nemo-qml-plugin-alarms"
FILES_${PN} += "/usr/share/translations/ /usr/lib/systemd/user/open-alarm.service /usr/share/dbus-1/services/com.nokia.voland.service"

do_install_append() {
    lrelease ${S}/asteroid-alarmclock.*.ts
    install -d ${D}/usr/share/translations/
    cp ${S}/asteroid-alarmclock.*.qm ${D}/usr/share/translations/
}
