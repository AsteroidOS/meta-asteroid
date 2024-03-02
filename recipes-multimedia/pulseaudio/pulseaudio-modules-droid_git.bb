SUMMARY = "Android/hybris plugin for PulseAudio"
HOMEPAGE = "https://github.com/mer-hybris/pulseaudio-modules-droid"
LICENSE = "LGPL-2.1-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=f294906e6e4eac9d917503a0bbd139b4"

SRC_URI = "git://github.com/mer-hybris/pulseaudio-modules-droid;protocol=https;branch=master \
"
SRCREV = "8283bbe5c932d34f6d427ce02abf455c23b3c3b1"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"
DEPENDS += "pulseaudio libhybris"
RDEPENDS:${PN} += "pulseaudio-module-keepalive"

inherit autotools pkgconfig
B = "${S}"

require pulseaudio-module.inc
