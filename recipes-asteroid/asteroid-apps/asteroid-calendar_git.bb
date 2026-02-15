SUMMARY = "Asteroid's calendar app"
HOMEPAGE = "https://github.com/AsteroidOS/asteroid-calendar.git"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=84dcc94da3adb52b53ae4fa38fe49e5d"

SRC_URI = "git://github.com/AsteroidOS/asteroid-calendar.git;protocol=https;branch=2.0"
SRCREV = "3c25df40d7bcdb6d38102377f11ce2fe239d541a"

require asteroid-app.inc

DEPENDS += "nemo-qml-plugin-calendar"
RDEPENDS:${PN} += "nemo-qml-plugin-calendar"
