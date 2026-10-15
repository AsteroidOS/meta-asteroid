SUMMARY = "Desktop file generation for AsteroidOS apps"
HOMEPAGE = "https://github.com/AsteroidOS/qml-asteroid.git"
LICENSE = "LGPL-2.1-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=1702a92c723f09e3fab3583b165a8d90"

SRC_URI = "git://github.com/AsteroidOS/qml-asteroid.git;protocol=https;branch=master"
SRCREV = "c1905485d4aa22f964273e93a62ef23c27a7754b"
PV = "2.0+65+git"
PE = "1"
PR = "r1"

inherit native

do_install() {
    install -d ${D}/${bindir}
    install -m 755 ${S}/generate-desktop.sh ${D}/${bindir}/asteroid-generate-desktop
}
