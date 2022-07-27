SUMMARY = "Extra modules and scripts for CMake"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://COPYING-CMAKE-SCRIPTS;md5=54c7042be62e169199200bc6477f04d1"

SRC_URI = "git://invent.kde.org/frameworks/extra-cmake-modules.git;protocol=https;branch=master"
SRCREV = "0064cf77e96acda8a99c0eba4cc89f83768b65d3"
PV = "5.96.0"
S = "${WORKDIR}/git"

ALLOW_EMPTY:${PN} = "1"

EXTRA_OECMAKE += "-DBUILD_TESTING=off -DBUILD_HTML_DOCS=OFF -DBUILD_QTHELP_DOCS=ON"

inherit cmake

FILES:${PN}-dev += "${datadir}/ECM"
