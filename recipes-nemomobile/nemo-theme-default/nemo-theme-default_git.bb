SUMMARY = "Default Theme for Nemo"
HOMEPAGE = "https://github.com/nemomobile-ux/nemo-theme-default.git"
LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://lgpl/LICENSE.LGPL;md5=9bddd653c11e4620e98b7c15dce0f89c"

SRC_URI = "git://github.com/nemomobile/nemo-theme-default.git;protocol=https"
SRCREV = "${AUTOREV}"
PR = "r1"
PV = "+git${SRCREV}"
S = "${WORKDIR}/git"
inherit qmake5

FILES_${PN} = "/usr/ /etc/"
