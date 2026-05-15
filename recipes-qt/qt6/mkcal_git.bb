SUMMARY = "Mer's fork of KCal"
HOMEPAGE = "https://github.com/sailfishos/mkcal"
LICENSE = "LGPL-2.0-only"
LIC_FILES_CHKSUM = "file://LICENSE.LGPL2;md5=5f30f0716dfdd0d91eb439ebec522ec2"

SRC_URI = "git://github.com/sailfishos/mkcal.git;protocol=https;branch=master"
SRCREV = "4687242710462999b4f55fd82104e2aee53f9fdf"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"
inherit qt6-cmake pkgconfig

DEPENDS += "extra-cmake-modules qtbase kcalendarcore timed libical sqlite3 util-linux"
EXTRA_OECMAKE += " -DBUILD_TESTS=OFF -DBUILD_PLUGINS=OFF -DENABLE_QT6=ON"
