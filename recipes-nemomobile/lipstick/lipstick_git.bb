SUMMARY = "Lipstick is a project aimed at offering easy to modify user experiences for varying mobile device form factors, e.g. handsets, netbooks, tablets."
HOMEPAGE = "https://git.merproject.org/mer-core/lipstick"
LICENSE = "LGPL-2.1+"
LIC_FILES_CHKSUM = "file://LICENSE.LGPL;md5=fbc093901857fcd118f065f900982c24"

SRC_URI = "git://github.com/AsteroidOS/lipstick.git;protocol=https \
    file://0001-Disables-tests-and-doc.patch \
    file://0002-notificationcategories-use-ion-icons.patch \
    file://0003-Disable-USB-mode-notifications-on-connect.patch \
    file://0004-ScreenshotService-Use-system-bus-to-workaround-the-s.patch \
    file://0005-BluetoothAgent-Advertise-less-hardware-capabilities-.patch \
    file://Notifications/"
SRCREV = "${AUTOREV}"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"

PACKAGE_ARCH = "${MACHINE_ARCH}"

DEPENDS += "timed qtbase qtsensors qtdeclarative qtwayland mlite dbus dbus-glib libresourceqt qtsystems libngf-qt mce usb-moded-qt5 systemd wayland nemo-keepalive qttools-native mce-qt5"
RDEPENDS_${PN} += "${PN}-locale"

inherit qmake5

do_install_append() {
    install -d ${D}/usr/share/icons/hicolor/86x86/apps/

    rm -r ${D}/usr/share/translations/source/
    cd ${S}/i18n/
    lrelease -idbased *.ts
    cp -r *.qm ${D}/usr/share/translations/

    install -d ${D}/home/ceres/.local/share/system/privileged/Notifications/
    cp -r ${WORKDIR}/Notifications/* ${D}/home/ceres/.local/share/system/privileged/Notifications/
}

FILES_${PN} += "/usr/lib/qml/org/nemomobile/lipstick/liblipstickplugin.so /usr/lib/qml/org/nemomobile/lipstick/qmldir /usr/share/icons/hicolor/86x86/apps/ /home/ceres/.local/share/system/privileged/Notifications"
FILES_${PN}-dev += "/usr/lib/liblipstick-qt5.prl"
FILES_${PN}-dbg += "/usr/lib/qml/org/nemomobile/lipstick/.debug"
FILES_${PN}-locale += "/usr/share/translations"

INSANE_SKIP_${PN} += "dev-deps host-user-contaminated"
