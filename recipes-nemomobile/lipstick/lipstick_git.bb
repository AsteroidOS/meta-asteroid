SUMMARY = "Lipstick is a project aimed at offering easy to modify user experiences for varying mobile device form factors, e.g. handsets, netbooks, tablets."
HOMEPAGE = "https://git.merproject.org/mer-core/lipstick"
LICENSE = "LGPL-2.1+"
LIC_FILES_CHKSUM = "file://LICENSE.LGPL;md5=fbc093901857fcd118f065f900982c24"

SRC_URI = "git://github.com/AsteroidOS/lipstick.git;protocol=https \
    file://0001-Disables-tests-and-doc.patch \
    file://0004-notificationcategories-use-ion-icons.patch"
SRCREV = "0274da621e9a26b1386c624fc841fcae89a3f3ac"
PR = "r1"
PV = "+git${SRCREV}"
S = "${WORKDIR}/git"

PACKAGE_ARCH = "${MACHINE_ARCH}"

DEPENDS += "qtbase qtsensors qtdeclarative qtwayland mlite dbus dbus-glib libresourceqt qtsystems libngf-qt statefs-qt mce usb-moded-qt5 systemd wayland qmsystem nemo-keepalive qttools-native"
RDEPENDS_${PN} += "${PN}-locale"

inherit qmake5

do_install_append() {
    install -d ${D}/usr/share/icons/hicolor/86x86/apps/
}

FILES_${PN} += "/usr/lib/qml/org/nemomobile/lipstick/liblipstickplugin.so /usr/lib/qml/org/nemomobile/lipstick/qmldir /usr/share/icons/hicolor/86x86/apps/"
FILES_${PN}-dev += "/usr/lib/liblipstick-qt5.prl"
FILES_${PN}-dbg += "/usr/lib/qml/org/nemomobile/lipstick/.debug"
FILES_${PN}-locale += "/usr/share/translations"

INSANE_SKIP_${PN} += "dev-deps"
