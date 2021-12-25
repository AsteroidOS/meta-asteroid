SUMMARY = "Nemomobile's time daemon"
HOMEPAGE = "https://github.com/sailfishos/timed"
LICENSE = "LGPL-2.1+"
LIC_FILES_CHKSUM = "file://COPYING;md5=4fbd65380cdd255951079008b364516c"

SRC_URI = "git://github.com/sailfishos/timed.git;protocol=https \
    file://0001-Fixes-build.patch \
    file://0002-Add-wakeup-event-for-use-with-ambient-mode.patch \
    file://timed-qt5.conf \
    file://timed-qt5.service"
SRCREV = "d136e845f5d2da8bb43cdd70b283300a8b8cd3b9"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"

inherit qmake5 useradd

B = "${S}"

USERADD_PACKAGES = "${PN}"
GROUPADD_PARAM:${PN} = "sailfish-datetime"

do_configure:prepend() {
    mkdir -p src/h/timed-qt5/
    cp src/lib/qmacro.h src/h/timed-qt5/qmacro.h
    sed -i "s@<policy user=\"nemo\">@<policy user=\"ceres\">@" src/server/timed-qt5.conf tests/ut_networktime/fakeofono/org.fakeofono.conf
    cp ${WORKDIR}/timed-qt5.service ${S}/src/server/timed-qt5.service
}

do_install:append() {
    install -d ${D}/usr/lib/systemd/user/default.target.wants/
    if [ ! -f ${D}/usr/lib/systemd/user/default.target.wants/timed-qt5.service ]; then
        ln -s /usr/lib/systemd/user/timed-qt5.service ${D}/usr/lib/systemd/user/default.target.wants/timed-qt5.service
    fi
    install -d ${D}/var/lib/timed/
    install -g sailfish-datetime -m 2775 -d ${D}/var/lib/timed/shared_settings/
    ln -s /usr/share/zoneinfo/Etc/GMT ${D}/var/lib/timed/localtime
    cp ${WORKDIR}/timed-qt5.conf ${D}/etc/dbus-1/system.d/
}

pkg_postinst:${PN}() {
    setcap cap_sys_time+ep $D/usr/bin/timed-qt5
}

PACKAGE_WRITE_DEPS = "libcap-native"
DEPENDS += "pcre systemd tzdata libiodata-native libiodata qtbase sailfish-access-control"
RDEPENDS:${PN} += "libcap-bin tzdata"
FILES:${PN} += "/usr/lib/ /usr/lib/systemd/user/default.target.wants/"
FILES:${PN}-dev += "/usr/share/mkspecs"
FILES:${PN}-dbg += "/opt"
INSANE_SKIP:${PN} += "dev-deps"
