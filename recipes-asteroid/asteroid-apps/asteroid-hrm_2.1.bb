SUMMARY = "Asteroid's heart rate monitor app"
HOMEPAGE = "https://github.com/AsteroidOS/asteroid-hrm.git"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=84dcc94da3adb52b53ae4fa38fe49e5d"

SRC_URI = "git://github.com/AsteroidOS/asteroid-hrm.git;protocol=https;branch=2.0"
SRCREV = "bd973a132c8ceb5a7d4d6067f42b57459f63331e"

require asteroid-app.inc

DEPENDS += "qtsensors"
