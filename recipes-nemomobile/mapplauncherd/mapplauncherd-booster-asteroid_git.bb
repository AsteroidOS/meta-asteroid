SUMMARY = "QML Asteroid plugin for mapplauncherd"
HOMEPAGE = "https://github.com/AsteroidOS/mapplauncherd-booster-asteroid"
LICENSE = "LGPL-2.1-only"
LIC_FILES_CHKSUM = "file://src/qmlbooster.cpp;beginline=1;endline=18;md5=7e2bc276f949feb1d8229e665a6a2559"

SRC_URI = "git://github.com/AsteroidOS/mapplauncherd-booster-asteroid.git;protocol=https;branch=main"
SRCREV = "40f3ce8e479678b4fdb275982dc53bd0835ea884"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"
inherit qt6-qmake

DEPENDS += "mapplauncherd mapplauncherd-qt qtdeclarative qtbase"
RDEPENDS:${PN} += "mapplauncherd"

do_configure:prepend() {
    sed -i "s@INCLUDEPATH += /usr/include/applauncherd/@INCLUDEPATH += ${STAGING_INCDIR}/applauncherd ${STAGING_INCDIR}/mdeclarativecache6/@" ${S}/booster-asteroid.pro
}

do_install:append() {
    install -d ${D}/usr/lib/systemd/user/default.target.wants/
    if [ ! -f ${D}/usr/lib/systemd/user/default.target.wants/booster-asteroid-qt6.service ]; then
        ln -s /usr/lib/systemd/user/booster-asteroid-qt6.service ${D}/usr/lib/systemd/user/default.target.wants/booster-asteroid-qt6.service
    fi

    install -d ${D}/var/lib/environment/mapplauncherd
    echo "QT_QPA_PLATFORM=wayland-egl" > ${D}/var/lib/environment/mapplauncherd/asteroid-qt6.conf
    echo "QT_IM_MODULE=qtvirtualkeyboard" >> ${D}/var/lib/environment/mapplauncherd/asteroid-qt6.conf
}

FILES:${PN} += "/usr/libexec/mapplauncherd/ /usr/lib/systemd/user /usr/share/booster-asteroid-qt6 /usr/lib/systemd/user/default.target.wants/"
FILES:${PN}-dbg += "/usr/libexec/mapplauncherd/.debug"
