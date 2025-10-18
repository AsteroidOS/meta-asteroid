SUMMARY = "libcommhistiry is a library for keeping track of calls and contacts."
HOMEPAGE = "https://github.com/sailfishos/libcommhistory"
LICENSE = "LGPL-2.1-or-later"
LIC_FILES_CHKSUM = "file://COPYING;md5=4fbd65380cdd255951079008b364516c"

SRC_URI = "git://github.com/sailfishos/libcommhistory.git;protocol=https;branch=master"
SRCREV = "a855aae068d8545e1f7e006b740c8a14d5e00901"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"

DEPENDS += "qtbase"
inherit qmake5

# B = "${S}"

# FILES:${PN} += "/usr/lib/systemd /usr/lib/qml/org/nemomobile/voicecall/"
