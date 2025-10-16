SUMMARY = "KCalendarCore calendar library"
HOMEPAGE = "https://github.com/sailfishos-mirror/kcalendarcore"
LICENSE = "LGPL-2.0-or-later & LGPL-3.0-or-later & BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSES/LGPL-2.0-or-later.txt;md5=6d2d9952d88b50a51a5c73dc431d06c7 \
                    file://LICENSES/LGPL-3.0-or-later.txt;md5=c51d3eef3be114124d11349ca0d7e117 \
                    file://LICENSES/BSD-3-Clause.txt;md5=954f4d71a37096249f837652a7f586c0"

SRC_URI = "git://github.com/sailfishos-mirror/kcalendarcore.git;protocol=https;branch=master"

PV = "1.0+git${SRCPV}"
SRCREV = "e511aa0e8ce270185b5fbbcb637e8ebb22360d7b"

S = "${WORKDIR}/git"

inherit cmake_qt5

DEPENDS += "qtbase libical extra-cmake-modules"

EXTRA_OECMAKE = " -DBUILD_TESTS=OFF"
FILES:${PN}-dev += "/usr/mkspecs/* \
    /usr/share/* \
    /usr/lib/cmake/* \
    /usr/include/* \
"
