SUMMARY = "QML Plugin for configuration on Nemo"
HOMEPAGE = "https://git.merproject.org/mer-core/nemo-qml-plugin-configuration"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://src/plugin.cpp;beginline=1;endline=30;md5=c9e59c313a1a503510332399ae73d430"

SRC_URI = "git://git.merproject.org/mer-core/nemo-qml-plugin-configuration.git;protocol=https"
SRCREV = "363eed570ed2dcd6e7c0c4c62db170a77472497e"
PR = "r1"
PV = "+git${SRCREV}"
S = "${WORKDIR}/git"
inherit qmake5

DEPENDS += "qtquickcontrols-nemo mlite"
RDEPENDS_${PN} += "qtquickcontrols-qmlplugins"

FILES_${PN}-dbg += "/opt /usr/lib/qt5/qml/org/nemomobile/configuration/.debug"
FILES_${PN} += "/usr/lib/qt5/qml/org/nemomobile/configuration/"
