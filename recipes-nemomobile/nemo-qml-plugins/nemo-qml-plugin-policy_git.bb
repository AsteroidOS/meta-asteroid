SUMMARY = "QML Plugin for media policy on Nemo"
HOMEPAGE = "https://git.merproject.org/mer-core/nemo-qml-plugin-policy"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://src/plugin.cpp;beginline=1;endline=31;md5=bcbb827372d72ea4e42de457e3575a9d"

SRC_URI = "git://git.merproject.org/mer-core/nemo-qml-plugin-policy.git;protocol=https"
SRCREV = "b2d5230f20b9f120940455fdd17bb8c4f91c8750"
PR = "r1"
PV = "+git${SRCREV}"
S = "${WORKDIR}/git"
inherit qmake5

DEPENDS += "qtdeclarative qtbase libresourceqt"

FILES_${PN}-dbg += "/opt /usr/lib/qt5/qml/org/nemomobile/policy/.debug"
FILES_${PN} += "/usr/lib/qt5/qml/org/nemomobile/policy/"
