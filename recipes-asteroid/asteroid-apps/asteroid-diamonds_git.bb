SUMMARY = "A 2048 like game for AsteroidOS"
HOMEPAGE = "https://github.com/AsteroidOS/asteroid-diamonds.git"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"

SRC_URI = "git://github.com/AsteroidOS/asteroid-diamonds.git;protocol=https;branch=master"
SRCREV = "fc80087960e8db2b0a8513b8830bdb32ec2a3872"
PV = "2.1+10+git"

require asteroid-app.inc

FILES:${PN} += "/usr/share/icons/asteroid/"
