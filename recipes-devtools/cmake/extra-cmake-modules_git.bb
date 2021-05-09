SUMMARY = "Extra modules and scripts for CMake"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://COPYING-CMAKE-SCRIPTS;md5=54c7042be62e169199200bc6477f04d1"

SRC_URI = "git://invent.kde.org/frameworks/extra-cmake-modules.git;protocol=https;branch=master"
SRCREV = "d88db6a1469bdcb48e64f265d35a6f7867767b54"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"

EXTRA_OECMAKE += "-DBUILD_TESTING=off -DBUILD_HTML_DOCS=OFF -DBUILD_QTHELP_DOCS=ON"

inherit cmake

FILES_${PN}-dev += "${datadir}/ECM"
