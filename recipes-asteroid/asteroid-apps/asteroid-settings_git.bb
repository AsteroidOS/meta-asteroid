SUMMARY = "Asteroid's system settings app"
HOMEPAGE = "https://github.com/AsteroidOS/asteroid-settings.git"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=84dcc94da3adb52b53ae4fa38fe49e5d"

SRC_URI = "git://github.com/AsteroidOS/asteroid-settings.git;protocol=https;branch=master"
SRCREV = "7128219e39c90c9e432f9c9f4f9899945e9820e0"
PV = "2.1+40+git"

require asteroid-app.inc

inherit pkgconfig

DEPENDS += "nemo-qml-plugin-dbus polkit-ceres-rule-reboot libngf-qt mce"
RDEPENDS:${PN} += "nemo-qml-plugin-dbus qtmultimedia-qmlplugins libconnman-qt polkit-ceres-rule-reboot"
