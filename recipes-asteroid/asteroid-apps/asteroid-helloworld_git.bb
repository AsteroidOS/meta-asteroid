SUMMARY = "Asteroid's Hello World example app"
HOMEPAGE = "https://github.com/AsteroidOS/asteroid-helloworld.git"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=84dcc94da3adb52b53ae4fa38fe49e5d"

SRC_URI = "git://github.com/AsteroidOS/asteroid-helloworld.git;protocol=https;branch=master"
SRCREV = "5fd04b5d69ed8ca03c999bc05206f5307b7ba277"
PV = "2.1+6+git"

REMOVE_TRANSLATIONS = "1"

require asteroid-app.inc
