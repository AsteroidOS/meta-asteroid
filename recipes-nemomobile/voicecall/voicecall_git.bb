SUMMARY = "voicecall is a daemon (and QML plugin) for implementing dialer UIs"
HOMEPAGE = "https://github.com/sailfishos/voicecall"
LICENSE = "LGPL-2.1-or-later"
LIC_FILES_CHKSUM = "file://plugins/providers/ofono/src/ofonovoicecallhandler.cpp;beginline=1;endline=20;md5=7f57bb9f2a19d976f63ad5deb007d7a2"

SRC_URI = "git://github.com/sailfishos/voicecall.git;protocol=https;branch=master \
           file://0001-Fixes-build.patch"
SRCREV = "aa8876d6b0969a4e2d0bd9565e87967142b84792"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"

DEPENDS += "qtbase mapplauncherd-qt libresourceqt nemo-qml-plugin-devicelock qtmultimedia libngf-qt libqofono telepathy-qt"
inherit qmake5

B = "${S}"

FILES:${PN} += "/usr/lib/systemd /usr/lib/qml/org/nemomobile/voicecall/"
