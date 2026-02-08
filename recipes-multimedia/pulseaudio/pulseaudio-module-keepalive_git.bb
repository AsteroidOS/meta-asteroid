SUMMARY = "Nemo keepalive plugin for PulseAudio"
HOMEPAGE = "https://github.com/sailfishos/pulseaudio-module-keepalive"
LICENSE = "LGPL-2.1-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=f294906e6e4eac9d917503a0bbd139b4"

SRC_URI = "git://github.com/sailfishos/pulseaudio-module-keepalive.git;protocol=https;branch=master"
SRCREV = "8dc7da6ba6419dbdcb80d2518e903a9af0894d60"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"
DEPENDS += "pulseaudio libcheck"

inherit meson pkgconfig

require pulseaudio-module.inc
