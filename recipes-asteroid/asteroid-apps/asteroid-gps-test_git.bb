SUMMARY = "Asteroid's GPS test app"
HOMEPAGE = "https://github.com/AsteroidOS/asteroid-gps-test.git"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=84dcc94da3adb52b53ae4fa38fe49e5d"

SRC_URI = "git://github.com/AsteroidOS/asteroid-gps-test.git;protocol=https;branch=2.0"
SRCREV = "5ddfedf2ab093a9986806838829bc37b8080e9f3"

REMOVE_TRANSLATIONS = "1"

require asteroid-app.inc

DEPENDS += "qtlocation"
RDEPENDS:${PN} += "qtlocation"

