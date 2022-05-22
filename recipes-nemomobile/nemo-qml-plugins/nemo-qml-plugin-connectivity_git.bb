SUMMARY = "QML Plugin for connectivity on Nemo"
HOMEPAGE = "https://github.com/sailfishos/nemo-qml-plugin-connectivity/"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://src/plugin/plugin.cpp;beginline=1;endline=31;md5=a286bacf410e770064c78ac9470af1a2"

SRC_URI = "git://github.com/sailfishos/nemo-qml-plugin-connectivity.git;protocol=https;branch=master"
SRCREV = "f3707cbd1890fdce077db145c431e53e4160dc8b"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"
inherit qmake5

DEPENDS += "qtdeclarative qtbase libconnman-qt5 qofonoext"

FILES:${PN}-dbg += "/opt /usr/lib/qml/Nemo/Connectivity/.debug"
FILES:${PN} += "/usr/lib/qml/Nemo/Connectivity/"
