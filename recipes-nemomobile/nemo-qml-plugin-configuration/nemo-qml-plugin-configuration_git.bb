SUMMARY = "QML Plugin for configuration on Nemo"
HOMEPAGE = "https://github.com/nemomobile/nemo-qml-plugin-configuration.git"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://src/plugin.cpp;beginline=1;endline=30;md5=c9e59c313a1a503510332399ae73d430"

SRC_URI = "git://github.com/nemomobile/nemo-qml-plugin-configuration.git;protocol=https"
SRCREV = "${AUTOREV}"
PR = "r1"
PV = "+git${SRCREV}"
S = "${WORKDIR}/git"
inherit qmake5

DEPENDS += "qtquickcontrols-nemo mlite"
RDEPENDS_${PN} += "qtquickcontrols-qmlplugins"

FILES_${PN}-dbg += "/opt /usr/lib/qt5/qml/org/nemomobile/configuration/.debug"
FILES_${PN} += "/usr/lib/qt5/qml/org/nemomobile/configuration/"
