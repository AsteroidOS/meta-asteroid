SUMMARY = "A SQLite-based backend for QtContacts."
HOMEPAGE = "https://github.com/sailfishos/qtcontacts-sqlite"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE.BSD;md5=caa037e0975ee5862b72644673e7590c"

SRC_URI = "git://github.com/sailfishos/qtcontacts-sqlite.git;protocol=https;branch=master"
SRCREV = "a7b7978948067f1c9e57a45fa0acafb34bd26ccd"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"

DEPENDS += "qtbase qtpim mlite sqlite3"
inherit qmake5 pkgconfig

# B = "${S}"

# FILES:${PN} += "/usr/lib/systemd /usr/lib/qml/org/nemomobile/voicecall/"
