SUMMARY = "Nemo keepalive plugin for PulseAudio"
HOMEPAGE = "https://git.sailfishos.org/mer-core/pulseaudio-module-keepalive"
LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://COPYING;md5=f294906e6e4eac9d917503a0bbd139b4"

SRC_URI = "git://git.sailfishos.org/mer-core/pulseaudio-module-keepalive.git;protocol=https \
    file://0001-Set-version-to-13-to-support-PulseAudio-13.patch"
SRCREV = "3102ee5d92e7b8fb5adb6ea01aa8a47a9c7ce886"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"
DEPENDS += "pulseaudio libcheck"

inherit autotools pkgconfig
B = "${S}"

FILES_${PN} += "/usr/lib/pulse-13.0/modules"
FILES_${PN}-dbg += "/usr/lib/pulse-13.0/modules/.debug/"
FILES_${PN}-staticdev += "/usr/lib/pulse-13.0/modules/*.a"
