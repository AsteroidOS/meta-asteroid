SUMMARY = "Asteroid's system settings app"
HOMEPAGE = "https://github.com/AsteroidOS/asteroid-settings.git"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=84dcc94da3adb52b53ae4fa38fe49e5d"

SRC_URI = "git://github.com/AsteroidOS/asteroid-settings.git;protocol=https;branch=2.0"
SRCREV = "86d61ef92d069bf48b4fd5f98e8133845e882af8"

require asteroid-app.inc

inherit pkgconfig

DEPENDS += "nemo-qml-plugin-systemsettings nemo-qml-plugin-dbus polkit-ceres-rule-reboot"
RDEPENDS:${PN} += "nemo-qml-plugin-systemsettings nemo-qml-plugin-dbus qtmultimedia-qmlplugins libconnman-qt5-qmlplugins polkit-ceres-rule-reboot"
