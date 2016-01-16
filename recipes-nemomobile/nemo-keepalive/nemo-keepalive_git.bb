SUMMARY = "Keeps the system from automatically blanking the display"
HOMEPAGE = "https://git.merproject.org/mer-core/nemo-keepalive"
LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://license.lgpl;md5=4fbd65380cdd255951079008b364516c"

SRC_URI = "git://git.merproject.org/mer-core/nemo-keepalive.git;protocol=https"
SRCREV = "ba0768371c7d822871048865eb2753461b0d9bb6"
PR = "r1"
PV = "+git${SRCREV}"
S = "${WORKDIR}/git"
inherit qmake5

DEPENDS += "libiphb qtbase mce glib-2.0 qtdeclarative"

FILES_${PN}-dbg += "/opt /usr/share/ /usr/lib/qml/org/nemomobile/keepalive/.debug/"
FILES_${PN} += "/usr/lib/"
