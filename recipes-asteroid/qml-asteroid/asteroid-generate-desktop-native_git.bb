SUMMARY = "Desktop file generation for AsteroidOS apps"
HOMEPAGE = "https://github.com/AsteroidOS/qml-asteroid.git"
LICENSE = "LGPL-2.1-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=1702a92c723f09e3fab3583b165a8d90"

SRC_URI = "git://github.com/AsteroidOS/qml-asteroid.git;protocol=https;branch=2.0"
SRCREV = "537e9dea64ee83ee5bd0301712ca314785d74e92"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"

inherit native

do_install() {
    install -d ${D}/${bindir}
    install -m 755 ${S}/generate-desktop.sh ${D}/${bindir}/asteroid-generate-desktop
}
