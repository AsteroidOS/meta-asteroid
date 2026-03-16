SUMMARY = "Qt plugin for mapplauncherd"
HOMEPAGE = "https://github.com/sailfishos/mapplauncherd-qt"
LICENSE = "LGPL-2.1-only"
LIC_FILES_CHKSUM = "file://qtbooster/qtbooster.cpp;beginline=1;endline=18;md5=fb70bd5bb640878875111d8161fa303c"

SRC_URI = "git://github.com/sailfishos/mapplauncherd-qt.git;protocol=https;branch=master \
           file://0001-mdeclarativecache5-Share-same-mdeclarativecache_pre_.patch \
           file://0002-qdeclarative5-boostable-Compile-apps-as-shared-libra.patch \
           file://booster-qt5.service"
SRCREV = "1ff776d787e3c95424a9925097658ef99a6221ba"
PR = "r1"
PV = "+git${SRCPV}"
inherit qmake5 pkgconfig

DEPENDS += "qtdeclarative qtbase mapplauncherd glib-2.0"
RDEPENDS:${PN} += "mapplauncherd"

do_configure:prepend() {
    sed -i "s@INCLUDEPATH += /usr/include/applauncherd@INCLUDEPATH += ${STAGING_INCDIR}/applauncherd@" ${S}/qtbooster/qtbooster.pro
    cp ${UNPACKDIR}/booster-qt5.service ${S}/data/booster-qt5.service
}

do_install:append() {
    rm ${D}/usr/lib/systemd/user/booster-qt5-signal.service
    install -d ${D}/usr/lib/systemd/user/default.target.wants/
    if [ ! -f ${D}/usr/lib/systemd/user/default.target.wants/booster-qt5.service ]; then
        ln -s /usr/lib/systemd/user/booster-qt5.service ${D}/usr/lib/systemd/user/default.target.wants/booster-qt5.service
    fi
}

FILES:${PN} += "/usr/lib/systemd/user /usr/libexec/mapplauncherd /usr/lib/systemd/user/default.target.wants/"
FILES:${PN}-dev += "/usr/share/mkspecs/features"
FILES:${PN}-dbg += "/usr/libexec/mapplauncherd/.debug"
