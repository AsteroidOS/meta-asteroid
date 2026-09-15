SUMMARY = "Asteroid's stopwatch app"
HOMEPAGE = "https://github.com/AsteroidOS/asteroid-stopwatch.git"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=84dcc94da3adb52b53ae4fa38fe49e5d"

SRC_URI = "git://github.com/AsteroidOS/asteroid-stopwatch.git;protocol=https;branch=master"
SRCREV = "a07d0a6f30bd343c48b1554fdba606873e708c8a"
PV = "2.1+9+git"

REMOVE_TRANSLATIONS = "1"

require asteroid-app.inc
