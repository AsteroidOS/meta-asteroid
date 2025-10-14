SUMMARY = "QML Plugin for connectivity on Nemo"
HOMEPAGE = "https://github.com/sailfishos/nemo-qml-plugin-connectivity/"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://src/plugin/plugin.cpp;beginline=1;endline=31;md5=a286bacf410e770064c78ac9470af1a2"

SRC_URI = "git://github.com/sailfishos/nemo-qml-plugin-connectivity.git;protocol=https;branch=master"
SRCREV = "850fb727d111b11312bc7943a433ee0eb05baa3a"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"
inherit qmake5 pkgconfig

DEPENDS += "qtdeclarative qtbase libconnman-qt5 qofonoext"

FILES:${PN}-dbg += "/opt /usr/lib/qml/Nemo/Connectivity/.debug"
FILES:${PN} += "/usr/lib/qml/Nemo/Connectivity/"
