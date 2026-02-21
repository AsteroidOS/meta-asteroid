SUMMARY = "Mer's fork of KCal"
HOMEPAGE = "https://github.com/sailfishos/mkcal"
LICENSE = "LGPL-2.1-only"
LIC_FILES_CHKSUM = "file://src/mkcal_export.h;beginline=1;endline=20;md5=6b5a610cd22589226883c2df189ff891"

SRC_URI = "git://github.com/sailfishos/mkcal.git;protocol=https;branch=master"
SRCREV = "dd6e56a0c7394125b5eef2182c507e28174c5049"
PR = "r1"
PV = "+git${SRCPV}"
inherit cmake_qt5 pkgconfig

DEPENDS += "extra-cmake-modules qtbase kcalendarcore timed libical sqlite3 util-linux"
EXTRA_OECMAKE += " -DBUILD_TESTS=OFF -DBUILD_PLUGINS=OFF"
