# Copyright (c) 2019 Christophe Chapuis <chris.chapuis@gmail.com>

DESCRIPTION = "Library used to interact with Android's binder module."
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=620d0a3463dc6d04eedd10422a20926c"

SRC_URI = "git://github.com/mer-hybris/libgbinder.git;branch=master;protocol=https \
           file://gbinder.conf \
"
SRCREV = "1.1.43"
PR = "r1"
PV = "+git${SRCPV}"

DEPENDS = "glib-2.0 libglibutil"

inherit pkgconfig

EXTRA_OEMAKE = "KEEP_SYMBOLS=1"
PARALLEL_MAKE = ""

do_install() {
    make install DESTDIR=${D}
    make install-dev DESTDIR=${D}
    
    # Install libgbinder's config for Halium 9.0
    install -d ${D}${sysconfdir}
    install -m 0644 ${UNPACKDIR}/gbinder.conf ${D}${sysconfdir}/gbinder.conf
}

FILES:${PN} += " ${sysconfdir}"
