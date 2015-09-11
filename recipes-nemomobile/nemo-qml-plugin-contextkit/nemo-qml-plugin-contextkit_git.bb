SUMMARY = "QML Plugin for contextkit on Nemo"
HOMEPAGE = "https://github.com/nemomobile/nemo-qml-plugin-contextkit.git"
LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://src/plugin.cpp;beginline=1;endline=23;md5=bc596f90d6ca301d84447f4d365b9243"

SRC_URI = "git://github.com/nemomobile/nemo-qml-plugin-contextkit.git;protocol=https"
SRCREV = "${AUTOREV}"
PR = "r1"
PV = "+git${SRCREV}"
inherit cmake_qt5
S = "${WORKDIR}/git"
B = "${S}"
EXTRA_OECMAKE+="-DUSEQT=5"

DEPENDS += "qtquickcontrols-nemo statefs-qt"
RDEPENDS_${PN} += "qtquickcontrols-qmlplugins"
FILES_${PN}-dbg += "/usr/lib/qt5/qml/org/freedesktop/contextkit/.debug/"
FILES_${PN} += "/usr/lib/qt5/qml/org/freedesktop/contextkit"
