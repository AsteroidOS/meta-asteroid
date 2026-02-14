SUMMARY = "QtComponents plugin for mapplauncherd"
HOMEPAGE = "https://github.com/sailfishos/mapplauncherd-booster-qtcomponents"
LICENSE = "LGPL-2.1-only"
LIC_FILES_CHKSUM = "file://src/qmlbooster.cpp;beginline=1;endline=18;md5=7e2bc276f949feb1d8229e665a6a2559"

SRC_URI = "git://github.com/sailfishos/mapplauncherd-booster-qtcomponents.git;protocol=https;branch=master \
          file://booster-qtcomponents-qt5.service \
          file://preload.qml"
SRCREV = "6c0faf11b5e9f0572898a451d41613a8f7ea39c4"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"
inherit qmake5

DEPENDS += "mapplauncherd mapplauncherd-qt qtdeclarative qtbase"
RDEPENDS:${PN} += "mapplauncherd"

do_configure:prepend() {
    sed -i "s@INCLUDEPATH += /usr/include/applauncherd/@INCLUDEPATH += ${STAGING_INCDIR}/applauncherd ${STAGING_INCDIR}/mdeclarativecache5/@" ${S}/booster-qtcomponents.pro
    sed -i "s@LIBS += -lapplauncherd@LIBS += -lapplauncherd -lmdeclarativecache5@" ${S}/booster-qtcomponents.pro
    cp ${UNPACKDIR}/booster-qtcomponents-qt5.service ${S}/data/booster-qtcomponents-qt5.service
    cp ${UNPACKDIR}/preload.qml ${S}/qml-qt5/preload.qml
}

do_install:append() {
    install -d ${D}/usr/lib/systemd/user/default.target.wants/
    if [ ! -f ${D}/usr/lib/systemd/user/default.target.wants/booster-qtcomponents-qt5.service ]; then
        ln -s /usr/lib/systemd/user/booster-qtcomponents-qt5.service ${D}/usr/lib/systemd/user/default.target.wants/booster-qtcomponents-qt5.service
    fi

    install -d ${D}/var/lib/environment/mapplauncherd
    echo "QT_QPA_PLATFORM=wayland-egl" > ${D}/var/lib/environment/mapplauncherd/qtcomponents-qt5.conf
    echo "QT_IM_MODULE=qtvirtualkeyboard" >> ${D}/var/lib/environment/mapplauncherd/qtcomponents-qt5.conf
}

FILES:${PN} += "/usr/libexec/mapplauncherd/ /usr/lib/systemd/user /usr/share/booster-qtcomponents-qt5 /usr/lib/systemd/user/default.target.wants/"
FILES:${PN}-dbg += "/usr/libexec/mapplauncherd/.debug"
