# TODO: Switch to KDE upstream at https://github.com/KDE/bluez-qt after Qt6 upgrade

SUMMARY = "Qt wrapper for BlueZ 5 DBus API, with partial support for BlueZ 4 backends"
HOMEPAGE = "https://github.com/sailfishos-mirror/bluez-qt.git"
LICENSE = "LGPL-2.1-or-later"
LIC_FILES_CHKSUM = "file://LICENSES/LGPL-2.1-or-later.txt;md5=2a4f4fd2128ea2f65047ee63fbca9f68"

SRC_URI = "git://github.com/sailfishos-mirror/bluez-qt.git;protocol=https;branch=kf5 \
           file://0001-Downgrade-required-ECM-version-to-one-shipped-in-Yoc.patch \
           "
SRCREV = "668787d53f64bb2af23fa1283a8ba1f1f9d5df5c"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"

DEPENDS += "qtbase qtdeclarative extra-cmake-modules"
inherit cmake_qt5

do_install:append() {
    # Do not violate usrmerge
    # Only happens sometimes for strange reasons, hence the || true
    mv "${D}/lib/*" "${D}/usr/lib/" || true
    rm -r "${D}/lib" || true
}

FILES:${PN} += "${libdir}/qml/org/kde/bluezqt"
FILES:${PN}-dev += "/usr/share /usr/mkspecs"
