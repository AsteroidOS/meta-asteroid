SUMMARY = "Qt wrapper for BlueZ 5 DBus API, with partial support for BlueZ 4 backends"
HOMEPAGE = "https://github.com/sailfishos/kf5bluezqt"
LICENSE = "LGPL-2.1+"
LIC_FILES_CHKSUM = "file://bluez-qt/COPYING.LIB;md5=4fbd65380cdd255951079008b364516c"

SRC_URI = "git://github.com/sailfishos/kf5bluezqt.git;protocol=https"
SRCREV = "65c7154e93bf302639e30c5a8ab6a2a4d6e36e40"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"

DEPENDS += "qtbase qtdeclarative"
inherit qmake5

do_configure_prepend() {
    export EXTRA_QMAKEVARS_PRE="${EXTRA_QMAKEVARS_PRE} KF5BLUEZQT_BLUEZ_VERSION=5"
    sed -i "s@-L\$\$PWD/../@-L${B}/bluez-qt/src/@" ../git/bluez-qt/src/imports/imports.pro
}

FILES_${PN} += "${libdir}/qml/org/kde/bluezqt"
