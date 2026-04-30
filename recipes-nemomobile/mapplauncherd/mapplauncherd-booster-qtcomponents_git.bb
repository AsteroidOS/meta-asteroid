SUMMARY = "QtComponents plugin for mapplauncherd"
HOMEPAGE = "https://github.com/sailfishos/mapplauncherd-booster-qtcomponents"
LICENSE = "LGPL-2.1-only"
LIC_FILES_CHKSUM = "file://src/qmlbooster.cpp;beginline=1;endline=18;md5=7e2bc276f949feb1d8229e665a6a2559"

SRC_URI = "git://github.com/sailfishos/mapplauncherd-booster-qtcomponents.git;protocol=https;branch=master \
          file://0001-Fix-build-with-Qt6.patch \
          "
SRCREV = "6c0faf11b5e9f0572898a451d41613a8f7ea39c4"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"
inherit qt6-qmake

DEPENDS += "mapplauncherd mapplauncherd-qt qtdeclarative qtbase"
RDEPENDS:${PN} += "mapplauncherd"

do_configure:prepend() {
    sed -i "s@INCLUDEPATH += /usr/include/applauncherd/@INCLUDEPATH += ${STAGING_INCDIR}/applauncherd ${STAGING_INCDIR}/mdeclarativecache6/@" ${S}/booster-qtcomponents.pro
}

do_install:append() {
    install -d ${D}/usr/lib/systemd/user/default.target.wants/
    if [ ! -f ${D}/usr/lib/systemd/user/default.target.wants/booster-qtcomponents-qt6.service ]; then
        ln -s /usr/lib/systemd/user/booster-qtcomponents-qt6.service ${D}/usr/lib/systemd/user/default.target.wants/booster-qtcomponents-qt6.service
    fi

    install -d ${D}/var/lib/environment/mapplauncherd
    echo "QT_QPA_PLATFORM=wayland-egl" > ${D}/var/lib/environment/mapplauncherd/qtcomponents-qt6.conf
    echo "QT_IM_MODULE=qtvirtualkeyboard" >> ${D}/var/lib/environment/mapplauncherd/qtcomponents-qt6.conf
}

FILES:${PN} += "/usr/libexec/mapplauncherd/ /usr/lib/systemd/user /usr/share/booster-qtcomponents-qt6 /usr/lib/systemd/user/default.target.wants/"
FILES:${PN}-dbg += "/usr/libexec/mapplauncherd/.debug"
