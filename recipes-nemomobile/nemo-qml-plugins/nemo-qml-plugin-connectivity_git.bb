SUMMARY = "QML Plugin for connectivity on Nemo"
HOMEPAGE = "https://git.merproject.org/mer-core/nemo-qml-plugin-connectivity/"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://src/plugin.cpp;beginline=1;endline=31;md5=a286bacf410e770064c78ac9470af1a2"

SRC_URI = "git://git.merproject.org/mer-core/nemo-qml-plugin-connectivity.git;protocol=https"
SRCREV = "0162280a13dc09914b8f8a644a7b43d4670bf486"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"
inherit qmake5

DEPENDS += "qtdeclarative qtbase libconnman-qt5"

FILES_${PN}-dbg += "/opt /usr/lib/qml/org/nemomobile/connectivity/.debug"
FILES_${PN} += "/usr/lib/qml/org/nemomobile/connectivity/"
