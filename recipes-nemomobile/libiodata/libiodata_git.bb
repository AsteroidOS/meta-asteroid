SUMMARY = "Nemomobile's libiodata"
HOMEPAGE = "https://git.merproject.org/mer-core/libiodata"
LICENSE = "LGPL-2.1+"
LIC_FILES_CHKSUM = "file://COPYING;md5=4fbd65380cdd255951079008b364516c"

SRC_URI = "git://git.merproject.org/mer-core/libiodata.git;protocol=https"
SRCREV = "7c2c0274c397a19fa9d855cd0116c37ae459ec54"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"
inherit qmake5
B = "${S}"
DEPENDS += "qtbase bison-native flex-native"

do_configure_prepend () {
    export IODATA_VERSION=0.19.8
    sed -i "s@define LOG_LEVEL LOG_WARNING@define LOG_LEVEL LOG_NONE@" src/log.h
    cd src/
    ${OE_QMAKE_QMAKE} -makefile -o Makefile ${OE_QMAKE_DEBUG_OUTPUT} ${OE_QMAKE_RECURSIVE} $QMAKE_VARSUBST_PRE $AFTER $PROFILES $QMAKE_VARSUBST_POST
    oe_runmake
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
