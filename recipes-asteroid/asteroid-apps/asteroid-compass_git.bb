SUMMARY = "Asteroid's compass app"
HOMEPAGE = "https://github.com/AsteroidOS/asteroid-compass.git"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=84dcc94da3adb52b53ae4fa38fe49e5d"

SRC_URI = "git://github.com/AsteroidOS/asteroid-compass.git;protocol=https;branch=master"
SRCREV = "0796293b4f4c77d252a89594b52cfa7c17684c48"
PV = "2.1+10+git"

require asteroid-app.inc

RDEPENDS:${PN} += "qtsensors qtsensors-qmlplugins qtsensors-plugins"
