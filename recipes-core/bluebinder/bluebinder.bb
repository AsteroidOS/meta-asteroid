# Copyright (c) 2019 Christophe Chapuis <chris.chapuis@gmail.com>

DESCRIPTION = "Simple proxy for using Android binder based bluetooth through vhci."
LICENSE = "GPL-2.0-or-later"
LIC_FILES_CHKSUM = "file://bluebinder.c;beginline=1;endline=29;md5=ba064fbc04c563e801926639c469e5cc"

SRC_URI = "git://github.com/mer-hybris/bluebinder.git;branch=master;protocol=https \
           file://0001-service-fixes.patch \
"
SRCREV = "1.0.15"
PR = "r1"
PV = "+git${SRCPV}"

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
