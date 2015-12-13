SUMMARY = "Lipstick is a project aimed at offering easy to modify user experiences for varying mobile device form factors, e.g. handsets, netbooks, tablets."
HOMEPAGE = "https://git.merproject.org/mer-core/lipstick"
LICENSE = "LGPL-2.1+"
LIC_FILES_CHKSUM = "file://LICENSE.LGPL;md5=fbc093901857fcd118f065f900982c24"

SRC_URI = "git://git.merproject.org/mer-core/lipstick.git;protocol=https"
SRCREV = "d393a948d2d7d179dbe5dedf3ae68543e655507a"
PR = "r1"
PV = "+git${SRCREV}"
S = "${WORKDIR}/git"

DEPENDS += "qtbase qtsensors qtquick1 qtwayland mlite dbus dbus-glib libresourceqt qtsystems libngf-qt statefs-qt mce usb-moded-qt5 systemd wayland qt5-qpa-hwcomposer-plugin qmsystem nemo-keepalive qttools-native"
RDEPENDS_${PN} += "qt5-qpa-hwcomposer-plugin"
# qt5-qpa-hwcomposer-plugin isn't detected to be needed at runtime by OpenEmbedded

inherit qmake5

do_configure_prepend() {
    sed -i "s@system(qdbusxml2cpp@system(${STAGING_BINDIR_NATIVE}/qt5/qdbusxml2cpp@" ${S}/src/compositor/compositor.pri ${S}/tools/notificationtool/notificationtool.pro ${S}/src/src.pro
    sed -i "s@ lupdate@ ${STAGING_BINDIR_NATIVE}/qt5/lupdate@" ${S}/src/compositor/compositor.pri ${S}/tools/notificationtool/notificationtool.pro ${S}/src/src.pro
}

FILES_${PN} += "/usr/lib/qt5/qml/org/nemomobile/lipstick/liblipstickplugin.so /usr/lib/qt5/qml/org/nemomobile/lipstick/qmldir"
FILES_${PN}-dev += "/usr/lib/liblipstick-qt5.prl"
FILES_${PN}-dbg += "/usr/lib/qt5/qml/org/nemomobile/lipstick/.debug"
FILES_${PN}-locale += "/usr/share/translations"

INSANE_SKIP_${PN} += "dev-deps"
