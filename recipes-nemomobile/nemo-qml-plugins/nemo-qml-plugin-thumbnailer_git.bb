SUMMARY = "QML Plugin for thumbnails generation on Nemo"
HOMEPAGE = "https://git.merproject.org/mer-core/nemo-qml-plugin-thumbnailer"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://src/plugin.cpp;beginline=1;endline=31;md5=99bfde884fbd54d5f6958982e31a4237"

SRC_URI = "git://git.merproject.org/mer-core/nemo-qml-plugin-thumbnailer.git;protocol=https"
SRCREV = "08c0c98ff535ac44608f57e9facfbbdadf806229"
PR = "r1"
PV = "+git${SRCREV}"
S = "${WORKDIR}/git"
inherit qmake5

DEPENDS += "qtdeclarative qtbase"

FILES_${PN}-dbg += "/opt /usr/lib/qml/org/nemomobile/thumbnailer/.debug"
FILES_${PN} += "/usr/lib/qml/org/nemomobile/thumbnailer/"
