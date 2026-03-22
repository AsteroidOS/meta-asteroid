SUMMARY = "Asteroid's compass app"
HOMEPAGE = "https://github.com/AsteroidOS/asteroid-compass.git"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=84dcc94da3adb52b53ae4fa38fe49e5d"

SRC_URI = "git://github.com/AsteroidOS/asteroid-compass.git;protocol=https;branch=2.0"
SRCREV = "26efd5efdb524f3ff8083f0b39ef23de57bc5805"

require asteroid-app.inc

RDEPENDS:${PN} += "qtsensors qtsensors-qmlplugins qtsensors-plugins"
