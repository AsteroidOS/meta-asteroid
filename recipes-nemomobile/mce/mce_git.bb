SUMMARY = "Nemomobile's MCE."
HOMEPAGE = "https://github.com/nemomobile/mce.git"
LICENSE = "LGPL-2.1+"
LIC_FILES_CHKSUM = "file://COPYING;md5=4fbd65380cdd255951079008b364516c"

SRC_URI = "git://github.com/nemomobile/mce.git;protocol=https \
    file://001-Fixes_build.patch"
SRCREV = "702a41228f7509f49eb3d70713fb4ed47ed06412"
PR = "r1"
PV = "+git${SRCREV}"
S = "${WORKDIR}/git"

DEPENDS += " glib-2.0 libdsme libiphb systemd dbus-glib dbus"

do_install() {
    oe_runmake install DESTDIR=${D}
}

FILES_${PN} += " /run/mce /lib/systemd/system "
FILES_${PN}-dbg += "/usr/lib/mce/modules/.debug"
