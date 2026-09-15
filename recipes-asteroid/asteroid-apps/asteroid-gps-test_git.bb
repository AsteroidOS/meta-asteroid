SUMMARY = "Asteroid's GPS test app"
HOMEPAGE = "https://github.com/AsteroidOS/asteroid-gps-test.git"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=84dcc94da3adb52b53ae4fa38fe49e5d"

SRC_URI = "git://github.com/AsteroidOS/asteroid-gps-test.git;protocol=https;branch=master"
SRCREV = "991329e453854593094cea018f6412f7e2e654bd"

REMOVE_TRANSLATIONS = "1"

require asteroid-app.inc

DEPENDS += "qtlocation"
RDEPENDS:${PN} += "qtlocation"

