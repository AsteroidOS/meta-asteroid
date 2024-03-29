SUMMARY = "Mce Qt bindings."
HOMEPAGE = "https://github.com/sailfishos/libmce-qt"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://lib/src/qmcebatterylevel.cpp;beginline=1;endline=36;md5=7a1b79e2ca9fb0d250c13ccfe76dd0fc"

SRC_URI = "git://github.com/sailfishos/libmce-qt.git;protocol=https;branch=master"
SRCREV = "431168d7c91ab7c3cfc9d2283ab1a26f09422228"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"

DEPENDS += "qtbase qtdeclarative mce"
inherit qmake5 pkgconfig

FILES:${PN} += "/usr/lib/qml/Nemo/Mce/"
