SUMMARY = "QtComponents plugin for mapplauncherd"
HOMEPAGE = "https://git.merproject.org/mer-core/mapplauncherd-booster-qtcomponents"
LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://src/qmlbooster.cpp;beginline=1;endline=18;md5=7e2bc276f949feb1d8229e665a6a2559"

SRC_URI = "git://git.merproject.org/mer-core/mapplauncherd-booster-qtcomponents.git;protocol=https"
SRCREV = "1f9706fb9001cd350e4f6bcefbdb12d036af2ae2"
PR = "r1"
PV = "+git${SRCREV}"
S = "${WORKDIR}/git"
inherit qmake5

DEPENDS += "mapplauncherd mapplauncherd-qt qtdeclarative qtbase"

do_configure_prepend() {
    sed -i "s@INCLUDEPATH += /usr/include/applauncherd/@INCLUDEPATH += ${STAGING_INCDIR}/applauncherd ${STAGING_INCDIR}/mdeclarativecache5/@" ${S}/booster-qtcomponents.pro
    sed -i "s@LIBS += -lapplauncherd@LIBS += -lapplauncherd -lmdeclarativecache5@" ${S}/booster-qtcomponents.pro
}

FILES_${PN} += "/usr/libexec/mapplauncherd/ /usr/lib/systemd/user /usr/share/booster-qtcomponents-qt5"
FILES_${PN}-dbg += "/usr/libexec/mapplauncherd/.debug"
