SUMMARY = "QML Plugin for notifications on Nemo"
HOMEPAGE = "https://github.com/sailfishos/nemo-qml-plugin-notifications"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b2ea859fa337fbb664575a8061833d99"

SRC_URI = "git://github.com/sailfishos/nemo-qml-plugin-notifications.git;protocol=https;branch=master \
           file://0001-Fix-qdusxml2cpp-search-path.patch \
           "
SRCREV = "d4d0a0ce8257b90293b8df469830f0e288faeeae"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"
inherit qmake5

DEPENDS += "qtdeclarative"

FILES:${PN}-dbg += "/opt /usr/lib/qml/Nemo/Notifications/.debug"
FILES:${PN}-dev += "/usr/lib/libnemonotifications-qt5.prl"
FILES:${PN} += "/usr/lib/qml/Nemo/Notifications/"
