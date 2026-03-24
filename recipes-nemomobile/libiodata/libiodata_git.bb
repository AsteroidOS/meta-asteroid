SUMMARY = "Nemomobile's libiodata"
HOMEPAGE = "https://github.com/sailfishos/libiodata"
LICENSE = "LGPL-2.1-or-later"
LIC_FILES_CHKSUM = "file://COPYING;md5=4fbd65380cdd255951079008b364516c"

SRC_URI = "git://github.com/sailfishos/libiodata.git;protocol=https;branch=master"
SRCREV = "85517a9f2103e461cbb69dc195335df73b7a8b7e"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"
inherit qmake5
DEPENDS += "qtbase bison-native flex-native"
B = "${S}"

BBCLASSEXTEND = "native"

do_install:append:class-target() {
    rm "${D}/usr/bin/iodata-qt5-type-to-c++"
}

do_install:append:class-native() {
    # Unsure why the build systemd doesn't do it by itself in this case,
    # even though it does it for the target build (where we need to remove it)
    install -d "${D}/${bindir}"
    install -m 755 "${S}/type-to-cxx/iodata-qt5-type-to-c++" "${D}/${bindir}/"
}

FILES:${PN}:class-native += "/usr/bin/iodata-qt5-type-to-c++"
FILES:${PN}-dbg += "/usr/share/iodata-qt5-tests /usr/bin/iodata-qt5-test"
FILES:${PN}-dev += "/usr/lib/mkspecs"
