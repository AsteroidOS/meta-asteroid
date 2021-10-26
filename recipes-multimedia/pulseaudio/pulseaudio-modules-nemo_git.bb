SUMMARY = "Nemo plugin for PulseAudio"
HOMEPAGE = "https://github.com/sailfishos/pulseaudio-modules-nemo"
LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://COPYING;md5=2d5025d4aa3495befef8f17206a5b0a1"

SRC_URI = "git://github.com/sailfishos/pulseaudio-modules-nemo.git;protocol=https \
           file://0001-configure.ac-Check-hardfp-from-cross-compilation-too.patch \
           file://0002-Set-version-to-support-PulseAudio-15.patch"
SRCREV = "d0dfdc3f895680f0c8839809f13f950090a77369"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"
DEPENDS += "pulseaudio libcheck"

inherit autotools pkgconfig
B = "${S}"

do_configure:prepend() {
    sed -i "s@pa_config_parse(conf, NULL, items, NULL, NULL);@pa_config_parse(conf, NULL, items, NULL, false, NULL);@" src/mainvolume/module-meego-mainvolume.c
    sed -i "s@pa_tagstruct_new(NULL, 0);@pa_tagstruct_new();@" src/stream-restore-nemo/module-stream-restore-nemo.c
}

FILES:${PN} += "/usr/lib/pulse-15.0/modules"
FILES:${PN}-dbg += "/usr/lib/pulse-15.0/modules/.debug/"
FILES:${PN}-staticdev += "/usr/lib/pulse-15.0/modules/*.a"
