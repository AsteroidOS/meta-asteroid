SUMMARY = "Nemomobile's MCE."
HOMEPAGE = "https://git.merproject.org/mer-core/mce"
LICENSE = "LGPL-2.1+"
LIC_FILES_CHKSUM = "file://COPYING;md5=4fbd65380cdd255951079008b364516c"

SRC_URI = "git://git.merproject.org/mer-core/mce.git;protocol=https \
    file://001-Fixes_build.patch \
    file://mce.service"
SRCREV = "ad535db76b7443febaf4f97328eb1968a3f1d8cc"
PR = "r1"
PV = "+git${SRCREV}"
S = "${WORKDIR}/git"

DEPENDS += "glib-2.0 libdsme libiphb systemd dbus-glib dbus libngf"

do_install() {
    oe_runmake install DESTDIR=${D}
    cp ../mce.service ${D}/lib/systemd/system/mce.service
}

FILES_${PN} += " /run/mce /lib/systemd/system "
FILES_${PN}-dbg += "/usr/lib/mce/modules/.debug"
