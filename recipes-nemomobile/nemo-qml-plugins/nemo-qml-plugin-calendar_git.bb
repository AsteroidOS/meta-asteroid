SUMMARY = "QML Plugin for calendar on Nemo"
HOMEPAGE = "https://github.com/sailfishos/nemo-qml-plugin-calendar"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://src/plugin.cpp;beginline=1;endline=31;md5=4f66b392565d1dd726d4c892676d96fd"

SRC_URI = "git://github.com/sailfishos/nemo-qml-plugin-calendar.git;protocol=https;branch=master"
SRCREV = "8f790f1026dee5065cdc4112a273272f28d0f4f5"
PV = "0.7.8"
S = "${WORKDIR}/git"
inherit qt6-qmake pkgconfig

DEPENDS += "qtbase qtdeclarative mkcal libaccounts-qt6 timed"

do_install:append() {
    # Drop the upstream unit-test binaries (mer /opt/tests convention). They
    # are not run on-device and their ELF embeds TMPDIR (buildpaths QA).
    rm -rf ${D}/opt
}

FILES:${PN}-dbg += "/usr/lib/qml/org/nemomobile/calendar/.debug"
FILES:${PN} += "/usr/lib/qml/org/nemomobile/calendar/ /usr/share/dbus-1/services/org.nemomobile.calendardataservice.service"
