# Copyright (c) 2019 Christophe Chapuis <chris.chapuis@gmail.com>

DESCRIPTION = "Simple proxy for using Android binder based bluetooth through vhci."
LICENSE = "GPL-2.0-or-later"
LIC_FILES_CHKSUM = "file://bluebinder.c;beginline=1;endline=27;md5=430727b8efeca344ab89eeb635b4fa79"

SRC_URI = "git://github.com/mer-hybris/bluebinder.git;branch=master;protocol=https \
           file://0001-Use-CC-as-compiler.patch \
"
SRCREV = "419ab4a36fd61f841e7b1070b92b5e23ea813b63"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"

PACKAGE_ARCH = "${MACHINE_ARCH}"

DEPENDS = "libgbinder glib-2.0 libglibutil bluez5 systemd"

inherit pkgconfig
inherit systemd

CFLAGS += "--sysroot=${RECIPE_SYSROOT} ${LDFLAGS}"

SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE:${PN} = "bluebinder.service"

do_install() {
    make install DESTDIR=${D}

    install -d ${D}${sbindir}
    install -m 0755 ${S}/bluebinder_post.sh ${D}${sbindir}/bluebinder_post.sh
    install -m 0755 ${S}/bluebinder_wait.sh ${D}${sbindir}/bluebinder_wait.sh

    install -d ${D}${systemd_unitdir}/system
    install -m 0644 ${S}/bluebinder.service ${D}${systemd_unitdir}/system/
}

FILES:${PN} += "${sbindir}/bluebinder_post.sh ${sbindir}/bluebinder_wait.sh"
