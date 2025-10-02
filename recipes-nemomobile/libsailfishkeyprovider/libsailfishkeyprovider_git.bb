SUMMARY = "Qt wrapper for BlueZ 5 DBus API, with partial support for BlueZ 4 backends"
HOMEPAGE = "https://github.com/sailfishos/libsailfishkeyprovider"
LICENSE = "LGPL-2.1-or-later"
LIC_FILES_CHKSUM = "file://../license.lgpl;md5=cf3f442f331daf906e35a3e770768003"

SRC_URI = "git://github.com/sailfishos/libsailfishkeyprovider.git;protocol=https;branch=master"
SRCREV = "dd00649085250bba81c56b13269dcc9d3bc7c5b7"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git/lib"
B = "${S}"

DEPENDS += "qtbase"
inherit qmake5
