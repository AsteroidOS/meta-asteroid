SUMMARY = "Asteroid's weather app"
HOMEPAGE = "https://github.com/AsteroidOS/asteroid-weather.git"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=84dcc94da3adb52b53ae4fa38fe49e5d"

SRC_URI = "git://github.com/AsteroidOS/asteroid-weather.git;protocol=https;branch=2.0"
SRCREV = "ce014a5400e28b4e3627113ae2859bc38cd4a588"

require asteroid-app.inc

DEPENDS += "nemo-qml-plugin-configuration"
RDEPENDS:${PN} += "nemo-qml-plugin-configuration"
