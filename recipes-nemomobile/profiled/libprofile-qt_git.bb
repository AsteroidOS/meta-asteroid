SUMMARY = "Device profile handling library for Qt."
HOMEPAGE = "https://github.com/sailfishos/libprofile-qt"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://src/profile.cpp;beginline=1;endline=34;md5=1bb00ceba8c2bf23723b34ecbfbad397"

SRC_URI = "git://github.com/sailfishos/libprofile-qt.git;protocol=https;branch=master"
SRCREV = "8f500ea1d5328e84615a68ff72597fd33194666b"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"

DEPENDS += "profiled qtbase"
B = "${WORKDIR}/git" 
inherit qmake5

FILES:${PN}-dbg += "/usr/share/libprofile-qt5-tests/ /usr/lib/libprofile-qt5-tests/"
