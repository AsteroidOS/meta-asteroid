SUMMARY = "Qt 5/6 Library for ConnMan"
HOMEPAGE = "https://github.com/sailfishos/libconnman-qt"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://libconnman-qt/clockmodel.h;endline=8;md5=ea9f724050803f15d2d900ce3c5dac88"
DEPENDS += "qtbase qtdeclarative"

VERSION = "1.3.3"
PV = "${VERSION}+git"
S = "${WORKDIR}/git"

SRCREV = "6b5ad435bbe9cb306324fc5d09a3624543e2ff63"
SRC_URI = "git://github.com/sailfishos/libconnman-qt.git;protocol=https;branch=master"

inherit pkgconfig
inherit qt6-qmake

EXTRA_QMAKEVARS_PRE = "CONFIG+=no-module-prefix VERSION=${VERSION}"

RDEPENDS:${PN} += "connman"

do_install:append() {
    if ls ${D}${libdir}/pkgconfig/connman-qt5.pc >/dev/null 2>/dev/null; then
        sed -i "s@-L${STAGING_LIBDIR}@-L\${libdir}@g" ${D}${libdir}/pkgconfig/connman-qt5.pc
    fi
}
FILES:${PN} += " \
    ${OE_QMAKE_PATH_QML}/Connman/ \
"
FILES:${PN}-dev += " \
    ${libdir}/libconnman-qt6.prl \
"
# ERROR: libconnman-qt-1.3.3+git-r0 do_package_qa: QA Issue: File /usr/lib/libconnman-qt6.prl in package libconnman-qt-dev contains reference to TMPDIR [buildpaths]
ERROR_QA:remove = "buildpaths"
WARN_QA:append = " buildpaths"
