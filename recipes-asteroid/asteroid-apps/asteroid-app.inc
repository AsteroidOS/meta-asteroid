SUMMARY = "AsteroidOS apps base recipe"

PR = "r1"
PV = "+git${SRCPV}"
inherit cmake_qt5

DEPENDS += "qml-asteroid asteroid-generate-desktop-native qttools-native qtdeclarative-native"
FILES:${PN} += "/usr/share/translations/ ${libdir}/${PN}.so"

REMOVE_TRANSLATIONS ?= "0"

do_install:append() {
    if [ "${REMOVE_TRANSLATIONS}" = "1" ] ; then
        # This app only uses translations for the desktop shortcut.
        rm -rvf ${D}/usr/share/translations/
    fi
}
