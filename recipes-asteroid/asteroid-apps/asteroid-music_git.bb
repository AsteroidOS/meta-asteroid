SUMMARY = "Asteroid's music app"
HOMEPAGE = "https://github.com/AsteroidOS/asteroid-music.git"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=84dcc94da3adb52b53ae4fa38fe49e5d"

SRC_URI = "git://github.com/AsteroidOS/asteroid-music.git;protocol=https;branch=2.0"
SRCREV = "eb4dc45fbe307cf497b75fed116538080d6f409c"

require asteroid-app.inc

DEPENDS += "qtmpris"
RDEPENDS:${PN} += "qtmpris"
