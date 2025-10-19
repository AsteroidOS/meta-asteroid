SUMMARY = "Mer's fork of KCal"
HOMEPAGE = "https://github.com/sailfishos/mkcal"
LICENSE = "LGPL-2.0-only"
LIC_FILES_CHKSUM = "file://LICENSE.LGPL2;md5=5f30f0716dfdd0d91eb439ebec522ec2"

SRC_URI = "git://github.com/sailfishos/mkcal.git;protocol=https;branch=master"
SRCREV = "46a3fb6d54b59f533cad9e10c8278c5414118cac"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"
inherit cmake_qt5 pkgconfig

DEPENDS += "extra-cmake-modules qtbase kcalendarcore timed libical sqlite3 util-linux"
EXTRA_OECMAKE += " -DBUILD_TESTS=OFF -DBUILD_PLUGINS=OFF"
