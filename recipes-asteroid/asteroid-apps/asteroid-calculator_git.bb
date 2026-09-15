SUMMARY = "Asteroid's calculator app"
HOMEPAGE = "https://github.com/AsteroidOS/asteroid-calculator.git"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=84dcc94da3adb52b53ae4fa38fe49e5d"

SRC_URI = "git://github.com/AsteroidOS/asteroid-calculator.git;protocol=https;branch=master"
SRCREV = "ca3241af839df6011b8e91d452cdef1e0c64fb98"
PV = "2.1+9+git"

REMOVE_TRANSLATIONS = "1"

require asteroid-app.inc
