SUMMARY = "Lipstick is a project aimed at offering easy to modify user experiences for varying mobile device form factors, e.g. handsets, netbooks, tablets."
HOMEPAGE = "https://github.com/sailfishos/lipstick"
LICENSE = "LGPL-2.1-or-later"
LIC_FILES_CHKSUM = "file://LICENSE.LGPL;md5=fbc093901857fcd118f065f900982c24"

SRC_URI = "git://github.com/AsteroidOS/lipstick.git;protocol=https;branch=master \
           file://Notifications/ \
           "
SRCREV = "${AUTOREV}"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"

PACKAGE_ARCH = "${MACHINE_ARCH}"

DEPENDS += "timed qtbase qtsensors qtdeclarative qtwayland mlite dbus dbus-glib libngf-qt mce usb-moded-qt6 systemd wayland nemo-keepalive qttools-native mce-qt5"
RDEPENDS:${PN} += "${PN}-locale"

inherit qt6-qmake pkgconfig asteroid-users

do_install:append() {
    install -d ${D}/usr/share/icons/hicolor/86x86/apps/

    rm -r ${D}/usr/share/translations/source/
    cd ${S}/i18n/
    lrelease -idbased *.ts
    cp -r *.qm ${D}/usr/share/translations/

    install -d ${D}/home/ceres/.local/share/system/privileged/Notifications/
    cp -r ${UNPACKDIR}/Notifications/* ${D}/home/ceres/.local/share/system/privileged/Notifications/
}

FILES:${PN} += "/usr/lib/qml/org/nemomobile/lipstick/liblipstickplugin.so /usr/lib/qml/org/nemomobile/lipstick/qmldir /usr/share/icons/hicolor/86x86/apps/ /home/ceres/.local/share/system/privileged/Notifications"
FILES:${PN}-dev += "/usr/lib/liblipstick-qt6.prl"
FILES:${PN}-dbg += "/usr/lib/qml/org/nemomobile/lipstick/.debug"
FILES:${PN}-locale += "/usr/share/translations"
