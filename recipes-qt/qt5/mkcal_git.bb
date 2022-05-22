SUMMARY = "Mer's fork of KCal"
HOMEPAGE = "https://github.com/sailfishos/mkcal"
LICENSE = "LGPL-2.1"
LIC_FILES_CHKSUM = "file://src/mkcal_export.h;beginline=1;endline=20;md5=6b5a610cd22589226883c2df189ff891"

SRC_URI = "git://github.com/sailfishos/mkcal.git;protocol=https;branch=master \
           file://0001-Removes-unused-reference-to-host-include-directories.patch \
           file://0002-Fixes-an-incorrect-returned-variable.patch \
           file://0003-Disable-tests-and-docs.patch"
SRCREV = "bccf4e2f28c65006c2cfa8a36acc584a59bcf501"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"
inherit qmake5

DEPENDS += "qtbase kcalcore timed libical sqlite3 util-linux"
