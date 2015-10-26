SUMMARY = "Nemomobile's time daemon"
HOMEPAGE = "https://git.merproject.org/mer-core/timed"
LICENSE = "LGPL-2.1+"
LIC_FILES_CHKSUM = "file://COPYING;md5=4fbd65380cdd255951079008b364516c"

SRC_URI = "git://git.merproject.org/mer-core/timed.git;protocol=https \
    file://0001-Fixes-build.patch"
SRCREV = "${AUTOREV}"
PR = "r1"
PV = "+git${SRCREV}"
S = "${WORKDIR}/git"

inherit qmake5

B = "${S}"

do_configure_prepend() {
    mkdir -p src/h/timed-qt5/
    cp src/lib/qmacro.h src/h/timed-qt5/qmacro.h
}

DEPENDS += "pcre systemd tzdata libiodata-native libiodata statefs-qt qtbase"
FILES_${PN} += "/usr/lib/ /usr/share/contextkit"
FILES_${PN} += "/usr/share/mkspecs"
FILES_${PN}-dbg += "/opt"
INSANE_SKIP_${PN} += "dev-deps"
