SUMMARY = "Nemo plugin for PulseAudio"
HOMEPAGE = "https://git.merproject.org/mer-core/pulseaudio-modules-nemo"
LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://COPYING;md5=2d5025d4aa3495befef8f17206a5b0a1"

SRC_URI = "git://git.merproject.org/mer-core/pulseaudio-modules-nemo.git;protocol=https \
           file://0001-configure.ac-Check-hardfp-from-cross-compilation-too.patch"
SRCREV = "2e771c3d088551ba54337ee3428e075334143b51"
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

FILES_${PN} += "/usr/lib/pulse-12.2/modules"
FILES_${PN}-dbg += "/usr/lib/pulse-12.2/modules/.debug/"
FILES_${PN}-staticdev += "/usr/lib/pulse-12.2/modules/*.a"
