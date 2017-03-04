SUMMARY = "Device profile handling library for Qt."
HOMEPAGE = "https://git.merproject.org/mer-core/libprofile-qt"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://src/profile.cpp;beginline=1;endline=34;md5=1bb00ceba8c2bf23723b34ecbfbad397"

SRC_URI = "git://git.merproject.org/mer-core/libprofile-qt.git;protocol=https"
SRCREV = "6aeb3a0b5ec9241b557dd0e838fbaa1f61d5215d"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"

DEPENDS += "profiled qtbase"
B = "${WORKDIR}/git" 
inherit qmake5

FILES_${PN}-dbg += "/usr/share/libprofile-qt5-tests/ /usr/lib/libprofile-qt5-tests/"
