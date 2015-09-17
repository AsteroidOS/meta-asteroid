SUMMARY = "Nemomobile's DSME"
HOMEPAGE = "https://github.com/nemomobile/dsme"
LICENSE = "LGPL-2.1+"
LIC_FILES_CHKSUM = "file://COPYING;md5=2d5025d4aa3495befef8f17206a5b0a1"

SRC_URI = "git://github.com/nemomobile/dsme;protocol=https \
    file://dsme.service"
SRCREV = "${AUTOREV}"
PR = "r1"
PV = "+git${SRCREV}"
S = "${WORKDIR}/git"

DEPENDS += " qtbase libdsme glib-2.0 libngf libiphb systemd dbus dbus-glib "
inherit autotools pkgconfig

B = "${WORKDIR}/git"
# Poweron-timer needs libcal but I can't find it
EXTRA_OECONF= " --disable-poweron-timer --disable-upstart --enable-systemd --enable-runlevel --enable-pwrkeymonitor --disable-static"

do_configure_prepend() {
    sed -i "s/\lsystemd-daemon/lsystemd/" dsme/Makefile.am
    sed -i "s@LDFLAGS \= \-pthread@LDFLAGS \= \-L${STAGING_DIR_TARGET}/usr/lib \-pthread@" modules/Makefile.am
}

do_compile() {
    find . -type f -print0 | xargs -0 sed -i "s/\-Werror//"
    oe_runmake V=1
}

do_install_append() {
    install -D -m 644 reboot-via-dsme.sh ${D}/etc/profile.d/reboot-via-dsme.sh
    install -D -m 644 ../dsme.service ${D}/lib/systemd/system/dsme.service
    install -d ${D}/lib/systemd/system/multi-user.target.wants/
    ln -s ../dsme.service ${D}/lib/systemd/system/multi-user.target.wants/dsme.service
    install -d ${D}/var/lib/dsme
    [ ! -f ${D}/var/lib/dsme/alarm_queue_status ] && echo 0 > ${D}/var/lib/dsme/alarm_queue_status
    rm ${D}/usr/lib/dsme/libstartup.so
}

FILES_${PN} += "/lib/systemd/"
FILES_${PN}-dbg += "/opt"
