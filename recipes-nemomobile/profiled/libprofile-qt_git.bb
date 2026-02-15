SUMMARY = "Device profile handling library for Qt."
HOMEPAGE = "https://github.com/sailfishos/libprofile-qt"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://src/profile.cpp;beginline=1;endline=34;md5=1bb00ceba8c2bf23723b34ecbfbad397"

SRC_URI = "git://github.com/sailfishos/libprofile-qt.git;protocol=https;branch=master"
SRCREV = "6aeb3a0b5ec9241b557dd0e838fbaa1f61d5215d"
PR = "r1"
PV = "+git${SRCPV}"

DEPENDS += "profiled qtbase"
B = "${WORKDIR}/git" 
inherit qmake5

FILES:${PN}-dbg += "/usr/share/libprofile-qt5-tests/ /usr/lib/libprofile-qt5-tests/"
