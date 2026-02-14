SUMMARY = "Nemomobile's time daemon"
HOMEPAGE = "https://github.com/sailfishos/timed"
LICENSE = "LGPL-2.1-or-later"
LIC_FILES_CHKSUM = "file://COPYING;md5=4fbd65380cdd255951079008b364516c"

SRC_URI = "git://github.com/sailfishos/timed.git;protocol=https;branch=master"
SRCREV = "80ea5e63cf58db616789adbfeb9cf3bfd63dddaa"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"

inherit qmake5 asteroid-users pkgconfig

# Out-of-source build breaks install
B = "${S}"

# Code expects to be massaged first the same way it's done in RPM .spec
do_compile:prepend() {
    mkdir -p ${B}/src/h/timed-qt5
    # As B=${S} here, src/lib/qmacro.h may exist from previous builds
    rm -f ${B}/src/h/timed-qt5/qmacro.h
    cp ${B}/src/lib/qmacro.h ${B}/src/h/timed-qt5/
}

do_install:append() {
    install -d ${D}/usr/lib/systemd/user/default.target.wants/
    if [ ! -f ${D}/usr/lib/systemd/user/default.target.wants/timed.service ]; then
        ln -s /usr/lib/systemd/user/timed.service ${D}/usr/lib/systemd/user/default.target.wants/timed.service
    fi
    install -d ${D}/var/lib/timed/
    install -g sailfish-datetime -m 2775 -d ${D}/var/lib/timed/shared_settings/
    ln -s /usr/share/zoneinfo/Etc/GMT ${D}/var/lib/timed/localtime
}

pkg_postinst:${PN}() {
    setcap cap_sys_time+ep $D/usr/bin/timed
}

PACKAGE_WRITE_DEPS = "libcap-native"
DEPENDS += "pcre libpcre systemd tzdata libiodata-native libiodata qtbase sailfish-access-control"
RDEPENDS:${PN} += "libcap-bin tzdata"
FILES:${PN} += "/usr/lib/ /usr/lib/systemd/user/default.target.wants/"
FILES:${PN}-dev += "/usr/share/mkspecs"
FILES:${PN}-dbg += "/opt"
