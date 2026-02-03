SUMMARY = "QML Plugin for thumbnails generation on Nemo"
HOMEPAGE = "https://github.com/sailfishos/nemo-qml-plugin-thumbnailer"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://src/plugin/plugin.cpp;beginline=1;endline=31;md5=99bfde884fbd54d5f6958982e31a4237"

SRC_URI = "git://github.com/sailfishos/nemo-qml-plugin-thumbnailer.git;protocol=https;branch=master"
SRCREV = "f16bff8f45ce0d1087c981db60e58ebcda89ed54"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"
inherit qmake5

DEPENDS += "qtdeclarative qtbase"

FILES:${PN}-dbg += "/opt /usr/lib/qml/Nemo/Thumbnailer/.debug"
FILES:${PN} += "/usr/lib/qml/Nemo/Thumbnailer/"
FILES:${PN} += "/usr/lib/libnemothumbnailer-qt5.prl"
FILES:${PN} += "/usr/lib/oneshot.d/remove-obsolete-nemothumbs-cache-dir"
