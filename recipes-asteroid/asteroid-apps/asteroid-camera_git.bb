SUMMARY = "Asteroid's camera app"
HOMEPAGE = "https://github.com/AsteroidOS/asteroid-camera.git"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=84dcc94da3adb52b53ae4fa38fe49e5d"

SRC_URI = "git://github.com/AsteroidOS/asteroid-camera.git;protocol=https;branch=2.0"
SRCREV = "8ed63c0abb38a792582d9fc49c20f470f2369fd0"

REMOVE_TRANSLATIONS = "1"

require asteroid-app.inc

DEPENDS += "qtmultimedia"
RDEPENDS:${PN} += "qtmultimedia"
