SUMMARY = "QML Plugin for connectivity on Nemo"
HOMEPAGE = "https://git.merproject.org/mer-core/nemo-qml-plugin-connectivity/"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://src/plugin.cpp;beginline=1;endline=31;md5=a286bacf410e770064c78ac9470af1a2"

SRC_URI = "git://git.merproject.org/mer-core/nemo-qml-plugin-connectivity.git;protocol=https"
SRCREV = "f3707cbd1890fdce077db145c431e53e4160dc8b"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"
inherit qmake5

DEPENDS += "qtdeclarative qtbase libconnman-qt5 qofonoext"

FILES_${PN}-dbg += "/opt /usr/lib/qml/Nemo/Connectivity/.debug"
FILES_${PN} += "/usr/lib/qml/Nemo/Connectivity/"
