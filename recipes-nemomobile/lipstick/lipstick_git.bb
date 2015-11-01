SUMMARY = "Lipstick is a project aimed at offering easy to modify user experiences for varying mobile device form factors, e.g. handsets, netbooks, tablets."
HOMEPAGE = "https://git.merproject.org/mer-core/lipstick"
LICENSE = "LGPL-2.1+"
LIC_FILES_CHKSUM = "file://LICENSE.LGPL;md5=fbc093901857fcd118f065f900982c24"

SRC_URI = "git://git.merproject.org/mer-core/lipstick.git;protocol=https \
    file://0001-Disables-tests-and-doc-and-fixes-build.patch"
SRC_URI[md5sum] = "d1b7dc2ee09b51192b14083292135c69"
SRC_URI[sha256sum] = "aa8049c9d49bb035f526d19a2bfb7d8e5b78c810946b10dcbd1d02c7a88520e4"
SRCREV = "d62073e39be884350d81977da1beaceaafb46164"
PR = "r1"
PV = "+git${SRCREV}"
S = "${WORKDIR}/git"

DEPENDS += "qtbase qtsensors qtquick1 qtwayland mlite dbus dbus-glib libresourceqt qtsystems libngf-qt statefs-qt mce usb-moded-qt5 systemd wayland qt5-qpa-hwcomposer-plugin qmsystem"
RDEPENDS_${PN} += "qt5-qpa-hwcomposer-plugin"
# qt5-qpa-hwcomposer-plugin isn't detected to be needed at runtime by OpenEmbedded

inherit qmake5

do_configure_prepend() {
    sed -i "s@system(qdbusxml2cpp@system(${STAGING_BINDIR_NATIVE}/qt5/qdbusxml2cpp@" ${S}/src/compositor/compositor.pri ${S}/tools/notificationtool/notificationtool.pro ${S}/src/src.pro
}

FILES_${PN} += "/usr/lib/qt5/qml/org/nemomobile/lipstick/liblipstickplugin.so /usr/lib/qt5/qml/org/nemomobile/lipstick/qmldir"
FILES_${PN}-dev += "/usr/lib/liblipstick-qt5.prl"
FILES_${PN}-dbg += "/usr/lib/qt5/qml/org/nemomobile/lipstick/.debug"
FILES_${PN}-locale += "/usr/share/translations"

INSANE_SKIP_${PN} += "dev-deps"
