SUMMARY = "Mer's fork of KCal"
HOMEPAGE = "https://github.com/sailfishos/mkcal"
LICENSE = "LGPL-2.0-only"
LIC_FILES_CHKSUM = "file://LICENSE.LGPL2;md5=5f30f0716dfdd0d91eb439ebec522ec2"

# TODO: use sailfishos/mkcal when https://github.com/sailfishos/mkcal/pull/75 is merged
SRC_URI = "git://github.com/gber/mkcal.git;protocol=https;branch=qt6"
SRCREV = "eee1a9460a27c8d10cd6f1871bb3c61acb6b6a2f"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"
inherit qt6-cmake pkgconfig

DEPENDS += "extra-cmake-modules qtbase kcalendarcore timed libical sqlite3 util-linux"
EXTRA_OECMAKE += " -DBUILD_TESTS=OFF -DBUILD_PLUGINS=OFF -DENABLE_QT6=ON"
