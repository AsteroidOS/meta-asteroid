SUMMARY = "Qt Library for oFono"
HOMEPAGE = "https://github.com/nemomobile/libqofono"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://README;endline=3;md5=8a15bce3921d1238d9a9f23828612947"

SECTION = "qt/lib"

BRANCH = "master"
PV = "0.4+gitr${SRCPV}"
SRCREV = "d9a860322f9a5dfc9a052ad4c3d26517f6a17ad6"

inherit qmake5 pkgconfig

DEPENDS += "qtbase qtxmlpatterns qtdeclarative"
RDEPENDS_${PN} = "ofono"

SRC_URI = "git://github.com/nemomobile/${BPN}.git"
S = "${WORKDIR}/git"

FILES_${PN}-dev += "/usr/share/qt5"
FILES_${PN}-dbg += "/opt /usr/lib/libqofono-qt5/tests /usr/lib/qt5/qml/MeeGo/QOfono/.debug/"
FILES_${PN} += "/usr/lib/qt5 "
