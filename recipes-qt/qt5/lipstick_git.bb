SUMMARY = "Lipstick is a project aimed at offering easy to modify user experiences for varying mobile device form factors, e.g. handsets, netbooks, tablets."
HOMEPAGE = "https://github.com/nemomobile/lipstick"
LICENSE = "LGPL-2.1+"
LIC_FILES_CHKSUM = "file://LICENSE.LGPL;md5=fbc093901857fcd118f065f900982c24"

SRC_URI = "git://github.com/nemomobile/lipstick.git;protocol=https"
SRC_URI[md5sum] = "d1b7dc2ee09b51192b14083292135c69"
SRC_URI[sha256sum] = "aa8049c9d49bb035f526d19a2bfb7d8e5b78c810946b10dcbd1d02c7a88520e4"
SRCREV = "${AUTOREV}"
PR = "r1"
PV = "+git${SRCREV}"
S = "${WORKDIR}/git"

DEPENDS += " qtbase qtsensors qtquick1 qtwayland mlite dbus dbus-glib libresourceqt qtsystems libngf-qt statefs-qt mce usb-moded-qt5 systemd wayland"

inherit qmake5

do_configure_prepend() {
    sed -i "s/libsystemd-daemon/libsystemd/" ${S}/src/src.pro
    sed -i "s/tests doc/tests/" ${S}/lipstick.pro
}
