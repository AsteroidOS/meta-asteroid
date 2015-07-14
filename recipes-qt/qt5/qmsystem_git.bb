SUMMARY = "Nemomobile's discontinued qmsystem"
HOMEPAGE = "https://github.com/nemomobile-graveyard/qmsystem"
LICENSE = "LGPL-2.1+"
LIC_FILES_CHKSUM = "file://system/qmsystemstate.cpp;beginline=1;endline=29;md5=63b0668100f7f3c7d93090514722bceb"

SRC_URI = "git://github.com/nemomobile-graveyard/qmsystem.git;protocol=https"
SRCREV = "${AUTOREV}"
PR = "r1"
PV = "+git${SRCREV}"
S = "${WORKDIR}/git"

inherit qmake5
B = "${S}"

DEPENDS += "timed sensorfw libdsme libiphb"

FILES_${PN}-dbg += "/opt /usr/share/qmsystem-qt5-tests/"
FILES_${PN}-dev += "/usr/share/qt5/mkspecs"
