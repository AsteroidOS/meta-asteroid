SUMMARY = "Asteroid's music app"
HOMEPAGE = "https://github.com/AsteroidOS/asteroid-music.git"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=84dcc94da3adb52b53ae4fa38fe49e5d"

SRC_URI = "git://github.com/AsteroidOS/asteroid-music.git;protocol=https;branch=master"
SRCREV = "1087453140957314ef7ce20bb79250dd2509dd35"
PV = "2.1+11+git"

require asteroid-app.inc

DEPENDS += "amber-mpris"
RDEPENDS:${PN} += "amber-mpris"
