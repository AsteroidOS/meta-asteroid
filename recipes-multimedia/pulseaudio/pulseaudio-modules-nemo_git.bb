SUMMARY = "Nemo plugin for PulseAudio"
HOMEPAGE = "https://git.merproject.org/mer-core/pulseaudio-modules-nemo"
LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://COPYING;md5=2d5025d4aa3495befef8f17206a5b0a1"

SRC_URI = "git://git.merproject.org/mer-core/pulseaudio-modules-nemo.git;protocol=https"
SRCREV = "f4ddfe58bcee6a6928c9cf659c02c96520b24ba9"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"
DEPENDS += "pulseaudio"

inherit autotools pkgconfig
B = "${S}"

do_configure_prepend() {
    sed -i "s@pa_config_parse(conf, NULL, items, NULL, NULL);@pa_config_parse(conf, NULL, items, NULL, false, NULL);@" src/mainvolume/module-meego-mainvolume.c
    sed -i "s@pa_tagstruct_new(NULL, 0);@pa_tagstruct_new();@" src/stream-restore-nemo/module-stream-restore-nemo.c
}

FILES_${PN} += "/usr/lib/pulse-6.0/modules"
FILES_${PN}-dbg += "/usr/lib/pulse-6.0/modules/.debug/"
FILES_${PN}-staticdev += "/usr/lib/pulse-6.0/modules/*.a"
