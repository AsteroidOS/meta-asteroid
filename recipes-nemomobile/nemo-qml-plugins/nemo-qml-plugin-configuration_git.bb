SUMMARY = "QML Plugin for configuration on Nemo"
HOMEPAGE = "https://github.com/sailfishos/nemo-qml-plugin-configuration"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://src/plugin.cpp;beginline=1;endline=30;md5=c9e59c313a1a503510332399ae73d430"

SRC_URI = "git://github.com/sailfishos/nemo-qml-plugin-configuration.git;protocol=https;branch=master"
SRCREV = "b8ff8957f7ed9d2e3fceffc782434f2609768686"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"
inherit qmake5 pkgconfig

DEPENDS += "qtdeclarative mlite"

FILES:${PN}-dbg += "/opt /usr/lib/qml/Nemo/Configuration/.debug"
FILES:${PN} += "/usr/lib/qml/Nemo/Configuration/"
