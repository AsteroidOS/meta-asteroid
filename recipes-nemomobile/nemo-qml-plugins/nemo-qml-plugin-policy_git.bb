SUMMARY = "QML Plugin for media policy on Nemo"
HOMEPAGE = "https://github.com/sailfishos/nemo-qml-plugin-policy"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://src/plugin.cpp;beginline=1;endline=31;md5=bcbb827372d72ea4e42de457e3575a9d"

SRC_URI = "git://github.com/sailfishos/nemo-qml-plugin-policy.git;protocol=https;branch=master"
SRCREV = "ad01a673e8b62dfe6da9e8ed9ca8103f5666bda6"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"
inherit qmake5 pkgconfig

DEPENDS += "qtdeclarative qtbase libresourceqt"

FILES:${PN}-dbg += "/opt /usr/lib/qml/Nemo/Policy/.debug"
FILES:${PN} += "/usr/lib/qml/Nemo/Policy/"
