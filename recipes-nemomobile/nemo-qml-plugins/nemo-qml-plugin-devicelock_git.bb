SUMMARY = "QML Plugin for devicelock on Nemo"
HOMEPAGE = "https://github.com/sailfishos/nemo-qml-plugin-devicelock.git"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://src/plugin/plugin.cpp;beginline=1;endline=31;md5=7abcb4ac64856fce624f8f11084f659f"

SRC_URI = "git://github.com/sailfishos/nemo-qml-plugin-devicelock.git;protocol=https;branch=master"
SRCREV = "bf74b74ab286dbdd05106349d27c4a0a5fcb4678"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"
inherit qmake5 pkgconfig

B = "${S}"

DEPENDS += "qtdeclarative nemo-keepalive nemo-qml-plugin-dbus mlite dbus"

FILES:${PN} += "/usr/lib/qml/org/nemomobile/devicelock/ /usr/lib/systemd/system/"
FILES:${PN}-dev += "/usr/share/mkspecs"
FILES:${PN}-dbg += "/opt /usr/lib/qml/org/nemomobile/devicelock/.debug"
