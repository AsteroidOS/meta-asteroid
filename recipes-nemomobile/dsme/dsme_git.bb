SUMMARY = "Nemomobile's DSME"
HOMEPAGE = "https://github.com/sailfishos/dsme"
LICENSE = "LGPL-2.1-or-later"
LIC_FILES_CHKSUM = "file://COPYING;md5=2d5025d4aa3495befef8f17206a5b0a1"

SRC_URI = "gitsm://github.com/sailfishos/dsme.git;protocol=https;branch=master \
           file://0002-Fix-and-improve-alarm-time-serialization.patch \
           file://dsme.service \
           "
SRCREV = "ab78f9c1945505c06beb3662878b6be9781565bd"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"

DEPENDS += "qtbase libdsme glib-2.0 libngf libiphb systemd dbus dbus-glib mce cryptsetup"
inherit autotools pkgconfig

B = "${WORKDIR}/git"
# Poweron-timer needs libcal but I can't find it
EXTRA_OECONF= " --disable-poweron-timer --disable-upstart --enable-systemd --enable-runlevel --enable-pwrkeymonitor --disable-validatorlistener --disable-static --enable-usewheel"

do_configure:prepend() {
    sed -i "s@<policy user=\"root\">@<policy user=\"ceres\">@" dsme/dsme.conf
    sed -i "s@-L/lib -lsystemd-daemon@-lsystemd@" dsme/Makefile.am
    sed -i "s@LDFLAGS \= \-pthread@LDFLAGS \= \-L${STAGING_DIR_TARGET}/usr/lib \-pthread@" modules/Makefile.am
}

do_compile() {
    oe_runmake V=1
}

do_install:append() {
    install -D -m 644 reboot-via-dsme.sh ${D}/etc/profile.d/reboot-via-dsme.sh
    install -D -m 644 ${UNPACKDIR}/dsme.service ${D}${systemd_system_unitdir}/dsme.service
    install -d ${D}${systemd_system_unitdir}/multi-user.target.wants/
    ln -s ../dsme.service ${D}${systemd_system_unitdir}/multi-user.target.wants/dsme.service
    install -d ${D}/var/lib/dsme
    [ ! -f ${D}/var/lib/dsme/alarm_queue_status ] && echo 0 > ${D}/var/lib/dsme/alarm_queue_status
}

FILES:${PN} += "${systemd_system_unitdir}"
FILES:${PN}-dbg += "/opt"
