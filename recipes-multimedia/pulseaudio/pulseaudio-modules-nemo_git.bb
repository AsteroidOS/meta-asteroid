SUMMARY = "Nemo plugin for PulseAudio"
HOMEPAGE = "https://github.com/sailfishos/pulseaudio-modules-nemo"
LICENSE = "LGPL-2.1-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=2d5025d4aa3495befef8f17206a5b0a1"

SRC_URI = "git://github.com/sailfishos/pulseaudio-modules-nemo.git;protocol=https;branch=master \
           file://0001-Set-version-to-support-PulseAudio-15.patch \
           file://0002-Add-meson-option-to-pass-sysroot.patch \
           "
SRCREV = "b901d679f246500f3cfab6654eb3043c4cdc43c1"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"
DEPENDS += "pulseaudio libcheck"

inherit meson pkgconfig

EXTRA_OEMESON = " \
    -Doe_sysroot=${STAGING_DIR_HOST} \
"

FILES:${PN} += "/usr/lib/pulse-15.0/modules"
FILES:${PN}-dbg += "/usr/lib/pulse-15.0/modules/.debug/"
FILES:${PN}-staticdev += "/usr/lib/pulse-15.0/modules/*.a"
