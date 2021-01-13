SUMMARY = "Nemo plugin for PulseAudio"
HOMEPAGE = "https://git.merproject.org/mer-core/pulseaudio-modules-nemo"
LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://COPYING;md5=2d5025d4aa3495befef8f17206a5b0a1"

SRC_URI = "git://git.merproject.org/rinigus/pulseaudio-modules-nemo.git;branch=pack;protocol=https \
           file://0001-configure.ac-Check-hardfp-from-cross-compilation-too.patch \
           file://0002-Don-t-use-host-libdir.patch \
           file://0003-Set-version-to-13-to-support-PulseAudio-13.patch"
SRCREV = "c2a7a7174831dcbb0d36457b272f2b0e10553ff9"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"
DEPENDS += "pulseaudio libcheck"

inherit autotools pkgconfig
B = "${S}"

do_configure_prepend() {
    sed -i "s@pa_config_parse(conf, NULL, items, NULL, NULL);@pa_config_parse(conf, NULL, items, NULL, false, NULL);@" src/mainvolume/module-meego-mainvolume.c
    sed -i "s@pa_tagstruct_new(NULL, 0);@pa_tagstruct_new();@" src/stream-restore-nemo/module-stream-restore-nemo.c
}

FILES_${PN} += "/usr/lib/pulse-13.0/modules"
FILES_${PN}-dbg += "/usr/lib/pulse-13.0/modules/.debug/"
FILES_${PN}-staticdev += "/usr/lib/pulse-13.0/modules/*.a"
