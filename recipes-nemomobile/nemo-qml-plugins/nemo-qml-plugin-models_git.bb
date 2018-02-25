SUMMARY = "QML Plugin for models on Nemo"
HOMEPAGE = "https://git.merproject.org/mer-core/nemo-qml-plugin-models"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://src/plugin/plugin.cpp;beginline=1;endline=31;md5=95b47fdc8bb7e842db36790ec722350a"

SRC_URI = "git://git.merproject.org/mer-core/nemo-qml-plugin-models.git;protocol=https"
SRCREV = "242c95ba87fe5cecfe37de40c96a2cced124572d"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"
inherit qmake5

DEPENDS += "qtdeclarative timed libmlocale"

FILES_${PN}-dev += "/usr/lib/libnemomodels-qt5.prl"
FILES_${PN}-dbg += "/opt /usr/lib/qml/org/nemomobile/models/.debug"
FILES_${PN} += "/usr/lib/qml/org/nemomobile/models/"
