SUMMARY = "Extra modules and scripts for CMake"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://COPYING-CMAKE-SCRIPTS;md5=54c7042be62e169199200bc6477f04d1"

SRC_URI = "git://invent.kde.org/frameworks/extra-cmake-modules.git;protocol=https;branch=master"
SRCREV = "a1dac86d6c848473d840b748b82694ef6916a3ca"
PV = "5.96.0"
S = "${WORKDIR}/git"

ALLOW_EMPTY:${PN} = "1"

EXTRA_OECMAKE += "-DBUILD_TESTING=off -DBUILD_HTML_DOCS=OFF -DBUILD_QTHELP_DOCS=ON"

inherit cmake

do_install:append() {
    # Uses /usr/bin/python3 which causes a file-rdeps yocto warning
    rm ${D}/usr/share/ECM/kde-modules/kde-git-commit-hooks/json-schema.py
}

FILES:${PN}-dev += "${datadir}/ECM"
