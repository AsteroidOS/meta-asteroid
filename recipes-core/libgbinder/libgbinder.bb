# Copyright (c) 2019 Christophe Chapuis <chris.chapuis@gmail.com>

DESCRIPTION = "Library used to interact with Android's binder module."
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=24f23d12bbc59c7e5ab483c52a172555"

SRC_URI = "git://github.com/mer-hybris/libgbinder.git;branch=master;protocol=https \
           file://gbinder.conf \
"
SRCREV = "88df2edb9533fc4680fe59f3113f839d0cf9c77a"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"

DEPENDS = "glib-2.0 libglibutil"

inherit pkgconfig

EXTRA_OEMAKE = "KEEP_SYMBOLS=1"
PARALLEL_MAKE = ""

do_install() {
    make install DESTDIR=${D}
    make install-dev DESTDIR=${D}
    
    # Install libgbinder's config for Halium 9.0
    install -d ${D}${sysconfdir}
    install -m 0644 ${WORKDIR}/gbinder.conf ${D}${sysconfdir}/gbinder.conf
}

FILES:${PN} += " ${sysconfdir}"
