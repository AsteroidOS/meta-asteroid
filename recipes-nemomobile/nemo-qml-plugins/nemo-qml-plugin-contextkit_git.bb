SUMMARY = "QML Plugin for contextkit on Nemo"
HOMEPAGE = "https://github.com/sailfishos/nemo-qml-plugin-contextkit"
LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://src/plugin.cpp;beginline=1;endline=23;md5=bc596f90d6ca301d84447f4d365b9243"

SRC_URI = "git://github.com/sailfishos/nemo-qml-plugin-contextkit.git;protocol=https"
SRCREV = "4a39923bdad9eaac76960d3a064567317edbc1d5"
PR = "r1"
PV = "+git${SRCPV}"
inherit cmake_qt5
S = "${WORKDIR}/git"
B = "${S}"
EXTRA_OECMAKE+="-DUSEQT=5"

DEPENDS += "qtdeclarative statefs-qt"

do_configure:prepend() {
    sed -i "s@DESTINATION lib/qt5/qml/@DESTINATION lib/qml/@" src/CMakeLists.txt
}

FILES:${PN}-dbg += "/usr/lib/qml/org/freedesktop/contextkit/.debug/"
FILES:${PN} += "/usr/lib/qml/org/freedesktop/contextkit"
