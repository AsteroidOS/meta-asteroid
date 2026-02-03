SUMMARY = "Mce Qt bindings."
HOMEPAGE = "https://github.com/sailfishos/libmce-qt"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://lib/src/qmcebatterylevel.cpp;beginline=1;endline=36;md5=7a1b79e2ca9fb0d250c13ccfe76dd0fc"

SRC_URI = "git://github.com/sailfishos/libmce-qt.git;protocol=https;branch=master"
SRCREV = "7fb63aa8258fd96bf121fa4f28c03aa43f7dc703"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"

DEPENDS += "qtbase qtdeclarative mce"
inherit qmake5 pkgconfig

FILES:${PN} += "/usr/lib/qml/Nemo/Mce/"
