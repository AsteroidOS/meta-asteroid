SUMMARY = "Asteroid's IP over BLE connectivity daemon."
HOMEPAGE = "https://github.com/AsteroidOS/asteroid-tap2ble"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=84dcc94da3adb52b53ae4fa38fe49e5d"

SRC_URI = "git://github.com/AsteroidOS/asteroid-tap2ble.git;protocol=https;branch=main"
SRCREV_FORMAT = "${SRCNAME}"
SRCREV = "${AUTOREV}"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"
inherit cmake_qt5 pkgconfig

DEPENDS += "qtbase"

FILES:${PN} += "/usr/bin/ /usr/lib/systemd/system/"

do_install:append() {
    install -d ${D}/usr/lib/systemd/system/
    install -d ${D}/usr/lib/systemd/system/default.target.wants/
    cp ${S}/asteroid-tap2ble.service ${D}/usr/lib/systemd/system/
    if [ ! -f ${D}/usr/lib/systemd/system/default.target.wants/asteroid-tap2ble.service ]; then
        ln -s /usr/lib/systemd/system/asteroid-tap2ble.service ${D}/usr/lib/systemd/system/default.target.wants/asteroid-tap2ble.service
    fi
}

