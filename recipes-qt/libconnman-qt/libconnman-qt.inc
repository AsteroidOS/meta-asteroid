DESCRIPTION = "Qt Library for ConnMan"
HOMEPAGE = "https://github.com/nemomobile/libconnman-qt"
SECTION = "qt/lib"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://libconnman-qt/clockmodel.h;endline=8;md5=ea9f724050803f15d2d900ce3c5dac88"
SRCREV = "80ac184d859ea90c026403f5a520644945a5081a"
PV = "1.0.50+git${SRCPV}"

SRC_URI = "git://github.com/nemomobile/libconnman-qt.git;branch=master"

S = "${WORKDIR}/git"

inherit pkgconfig

DEPENDS += "qtbase qtdeclarative"
RDEPENDS_${PN} = "connman"

FILES_${PN}-dbg += "/usr/lib/qt5/qml/MeeGo/Connman/.debug"
FILES_${PN}-dev += "/usr/lib/libconnman-qt5.prl"
FILES_${PN} += "/usr/lib/qt5/qml/MeeGo/Connman"
