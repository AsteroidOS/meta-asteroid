SUMMARY = "QML components for AsteroidOS"
HOMEPAGE = "https://github.com/AsteroidOS/qml-asteroid.git"
LICENSE = "LGPL-2.1"
LIC_FILES_CHKSUM = "file://COPYING;md5=1702a92c723f09e3fab3583b165a8d90"

SRC_URI = "git://github.com/AsteroidOS/qml-asteroid.git;protocol=https"
SRCREV = "${AUTOREV}"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"
inherit qmake5

PACKAGE_ARCH = "${MACHINE_ARCH}"

DEPENDS += "qtdeclarative qtsvg qtvirtualkeyboard mlite mapplauncherd-booster-qtcomponents"
RDEPENDS_${PN} += "qtsvg-plugins ttf-opensans qtvirtualkeyboard asteroid-icons-ion"

do_configure_prepend() {
    if [ ${MACHINE_DISPLAY_ROUND} = "true" ]
    then
        export EXTRA_QMAKEVARS_PRE="${EXTRA_QMAKEVARS_PRE} DEFINES+=ROUND_SCREEN"
    fi
    if [ ${MACHINE_HAS_WLAN} = "true" ]
    then
        export EXTRA_QMAKEVARS_PRE="${EXTRA_QMAKEVARS_PRE} DEFINES+=HAS_WLAN"
    fi
    if [ ${MACHINE_HAS_SPEAKER} = "true" ]
    then
        export EXTRA_QMAKEVARS_PRE="${EXTRA_QMAKEVARS_PRE} DEFINES+=HAS_SPEAKER"
    fi
}

FILES_${PN} += "/usr/lib /usr/share/icons/asteroid/"
FILES_${PN}-dbg += "/usr/lib/qml/org/asteroid/controls/.debug/ /usr/lib/qml/QtQuick/Controls/Styles/Asteroid/.debug/"
FILES_${PN}-dev += "/usr/lib/mkspecs/"
