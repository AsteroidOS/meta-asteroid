SUMMARY = "Nemomobile's statefs-providers"
HOMEPAGE = "https://git.merproject.org/mer-core/statefs-providers"
LICENSE = "LGPL-2.1+"
LIC_FILES_CHKSUM = "file://LICENSE;md5=9d1d95673c01a94e06648bf72ecda12d"

SRC_URI = "git://git.merproject.org/mer-core/statefs-providers.git;protocol=https"
SRCREV = "c5205f324fdc6de828522e86e53e53cd1ba7e004"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"

DEPENDS += "statefs boost qtbase statefs-qt qtsensors mce kf5bluezqt"
RDEPENDS_${PN} += "statefs-loader-qt"
inherit cmake_qt5

EXTRA_OECMAKE=" -DVERSION=x.x.x -DOE_QMAKE_PATH_EXTERNAL_HOST_BINS=${STAGING_DIR_NATIVE}/usr/bin/"

FILES_${PN} = "/usr/share/statefs /usr/lib/"
FILES_${PN}-dbg = "/usr/lib/statefs/.debug/ /usr/lib/.debug/ /usr/src/"
FILES_${PN}-dev = "/usr/lib/pkgconfig/ /usr/include"
