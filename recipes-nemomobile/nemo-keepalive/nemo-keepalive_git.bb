SUMMARY = "Keeps the system from automatically blanking the display"
HOMEPAGE = "https://github.com/sailfishos/nemo-keepalive"
LICENSE = "LGPL-2.1-only"
LIC_FILES_CHKSUM = "file://license.lgpl;md5=4fbd65380cdd255951079008b364516c"

SRC_URI = "git://github.com/sailfishos/nemo-keepalive.git;protocol=https;branch=master \
        file://0001-Disable-tests.patch"
SRCREV = "12a1528bacd20e0a07e9bbcbc287b08641986265"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"
inherit qmake5

DEPENDS += "libiphb qtbase mce glib-2.0 qtdeclarative"

FILES:${PN}-dbg += "/opt /usr/share/ /usr/lib/qml/org/nemomobile/keepalive/.debug/ /usr/bin/"
FILES:${PN} += "/usr/lib/"
