SUMMARY = "QML Plugin for thumbnails generation on Nemo"
HOMEPAGE = "https://git.merproject.org/mer-core/nemo-qml-plugin-thumbnailer"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://src/plugin/plugin.cpp;beginline=1;endline=31;md5=99bfde884fbd54d5f6958982e31a4237"

SRC_URI = "git://git.merproject.org/mer-core/nemo-qml-plugin-thumbnailer.git;protocol=https"
SRCREV = "7b0001877b734ddee733cd3042a3151657f478dc"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"
inherit qmake5

DEPENDS += "qtdeclarative qtbase"

FILES_${PN}-dbg += "/opt /usr/lib/qml/Nemo/Thumbnailer/.debug"
FILES_${PN} += "/usr/lib/qml/Nemo/Thumbnailer/"
