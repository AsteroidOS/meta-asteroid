SUMMARY = "Nemo plugin for PulseAudio"
HOMEPAGE = "https://github.com/sailfishos/pulseaudio-modules-nemo"
LICENSE = "LGPL-2.1-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=2d5025d4aa3495befef8f17206a5b0a1"

SRC_URI = "git://github.com/sailfishos/pulseaudio-modules-nemo.git;protocol=https;branch=master \
           file://0001-Fix-pulseaudio-linkage.patch \
           file://0002-mainvolume-Use-multiple-of-10-1-steps.patch \
           "
SRCREV = "00a733941e8bd56c079c1c9112bf4fbd9291ed59"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"
DEPENDS += "pulseaudio libcheck"

TARGET_LDFLAGS += "-L${STAGING_LIBDIR}/pulseaudio/modules"

inherit meson pkgconfig

require pulseaudio-module.inc
