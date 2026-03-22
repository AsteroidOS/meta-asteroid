SUMMARY = "Desktop file generation for AsteroidOS apps"
HOMEPAGE = "https://github.com/AsteroidOS/qml-asteroid.git"
LICENSE = "LGPL-2.1-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=1702a92c723f09e3fab3583b165a8d90"

SRC_URI = "git://github.com/AsteroidOS/qml-asteroid.git;protocol=https;branch=2.0"
SRCREV = "bbd14a66047627fe39943307ce303a2fc893ba5f"
PR = "r1"
S = "${WORKDIR}/git"

inherit native

do_install() {
    install -d ${D}/${bindir}
    install -m 755 ${S}/generate-desktop.sh ${D}/${bindir}/asteroid-generate-desktop
}
