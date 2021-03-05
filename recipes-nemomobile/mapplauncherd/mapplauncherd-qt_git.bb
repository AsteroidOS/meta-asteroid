SUMMARY = "Qt plugin for mapplauncherd"
HOMEPAGE = "https://git.merproject.org/mer-core/mapplauncherd-qt"
LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://qtbooster/qtbooster.cpp;beginline=1;endline=18;md5=fb70bd5bb640878875111d8161fa303c"

SRC_URI = "git://git.merproject.org/mer-core/mapplauncherd-qt.git;protocol=https \
           file://0001-mdeclarativecache5-Share-same-mdeclarativecache_pre_.patch \
           file://0002-qdeclarative5-boostable-Compile-apps-as-shared-libra.patch \
           file://booster-qt5.service"
SRCREV = "1ff776d787e3c95424a9925097658ef99a6221ba"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"
inherit qmake5

DEPENDS += "qtdeclarative qtbase mapplauncherd"
RDEPENDS_${PN} += "mapplauncherd"

do_configure_prepend() {
    sed -i "s@INCLUDEPATH += /usr/include/applauncherd@INCLUDEPATH += ${STAGING_INCDIR}/applauncherd@" ${S}/qtbooster/qtbooster.pro
    cp ${WORKDIR}/booster-qt5.service ${S}/data/booster-qt5.service
}

do_install_append() {
    rm ${D}/usr/lib/systemd/user/booster-qt5-signal.service
    install -d ${D}/usr/lib/systemd/user/default.target.wants/
    if [ ! -f ${D}/usr/lib/systemd/user/default.target.wants/booster-qt5.service ]; then
        ln -s /usr/lib/systemd/user/booster-qt5.service ${D}/usr/lib/systemd/user/default.target.wants/booster-qt5.service
    fi
}

FILES_${PN} += "/usr/lib/systemd/user /usr/libexec/mapplauncherd /usr/lib/systemd/user/default.target.wants/"
FILES_${PN}-dev += "/usr/share/mkspecs/features"
FILES_${PN}-dbg += "/usr/libexec/mapplauncherd/.debug"
