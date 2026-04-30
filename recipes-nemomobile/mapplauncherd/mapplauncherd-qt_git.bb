SUMMARY = "Qt plugin for mapplauncherd"
HOMEPAGE = "https://github.com/sailfishos/mapplauncherd-qt"
LICENSE = "LGPL-2.1-only"
LIC_FILES_CHKSUM = "file://LICENSE.LGPL21;md5=4fbd65380cdd255951079008b364516c"

# TODO: use sailfishos/mapplaunchard-qt when Qt6 support is merged
SRC_URI = "git://github.com/neochapay/mapplauncherd-qt.git;protocol=https;branch=qt6 \
           file://booster-qt6.service"
SRCREV = "956e42079a1970c7393752488c2169356f6fc8db"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"
inherit qt6-qmake pkgconfig

# Out-of-source build is broken:
# sed: can't read pkgconfig/*.pc: No such file or directory
B = "${S}"

DEPENDS += "qtdeclarative qtbase mapplauncherd glib-2.0"
RDEPENDS:${PN} += "mapplauncherd"

do_configure:prepend() {
    sed -i "s@INCLUDEPATH += /usr/include/applauncherd@INCLUDEPATH += ${STAGING_INCDIR}/applauncherd@" ${S}/qtbooster/qtbooster.pro
    cp ${UNPACKDIR}/booster-qt6.service ${S}/data/booster-qt6.service
}

do_install:append() {
    rm ${D}/usr/lib/systemd/user/booster-qt6-signal.service
    install -d ${D}/usr/lib/systemd/user/default.target.wants/
    if [ ! -f ${D}/usr/lib/systemd/user/default.target.wants/booster-qt6.service ]; then
        ln -s /usr/lib/systemd/user/booster-qt6.service ${D}/usr/lib/systemd/user/default.target.wants/booster-qt6.service
    fi
}

FILES:${PN} += "/usr/lib/systemd/user /usr/libexec/mapplauncherd /usr/lib/systemd/user/default.target.wants/"
FILES:${PN}-dev += "/usr/share/mkspecs/features"
FILES:${PN}-dbg += "/usr/libexec/mapplauncherd/.debug"
