SUMMARY = "Nemomobile's libiodata"
HOMEPAGE = "https://github.com/nemomobile/libiodata"
LICENSE = "LGPL-2.1+"
LIC_FILES_CHKSUM = "file://COPYING;md5=4fbd65380cdd255951079008b364516c"

SRC_URI = "git://github.com/nemomobile/libiodata.git;protocol=https"
SRCREV = "${AUTOREV}"
PR = "r1"
PV = "+git${SRCREV}"
S = "${WORKDIR}/git"
inherit qmake5
B = "${S}"
DEPENDS += "qtbase"

do_configure_prepend () {
    cd tests/
    ln -s ../src/libiodata-qt5.so libiodata-qt5.so
    cd ../type-to-cxx/
    ln -s ../src/libiodata-qt5.so libiodata-qt5.so
    cd ..
}

do_install () {
    # Fix install paths for all
    find -name "Makefile*" | xargs sed -i "s,(INSTALL_ROOT)${STAGING_DIR_TARGET},(INSTALL_ROOT),g"
    oe_runmake install INSTALL_ROOT=${D}
}

BBCLASSEXTEND = "native"

FILES_${PN}-dbg += "/usr/share/iodata-qt5-tests"
FILES_${PN}-dev += "/usr/share/mkspecs"
