SUMMARY = "Asteroid's launcher based on lipstick"
HOMEPAGE = "https://github.com/Asteroid-Project/asteroid-launcher"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=8a2d6d8e97bb7e7654de49c1af93557f"

SRC_URI = "git://github.com/Asteroid-Project/asteroid-launcher.git;protocol=https"
SRCREV = "${AUTOREV}"
PR = "r1"
PV = "+git${SRCREV}"
S = "${WORKDIR}/git"
inherit qmake5

DEPENDS += "lipstick"
RDEPENDS_${PN} += "qtquickcontrols-qmlplugins"
