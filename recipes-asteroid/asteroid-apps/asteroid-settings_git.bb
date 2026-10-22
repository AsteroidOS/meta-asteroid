SUMMARY = "Asteroid's system settings app"
HOMEPAGE = "https://github.com/AsteroidOS/asteroid-settings.git"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=84dcc94da3adb52b53ae4fa38fe49e5d"

SRC_URI = "git://github.com/AsteroidOS/asteroid-settings.git;protocol=https;branch=master"
SRCREV = "6e257e62524001d3438d3b161cbc0693afbee189"
PV = "2.1+51+git"

require asteroid-app.inc

inherit pkgconfig

DEPENDS += "nemo-qml-plugin-dbus polkit-ceres-rule-reboot libngf-qt mce"
RDEPENDS:${PN} += "nemo-qml-plugin-dbus qtmultimedia-qmlplugins libconnman-qt polkit-ceres-rule-reboot"
