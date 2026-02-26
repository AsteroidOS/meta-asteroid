SUMMARY = "Android/hybris plugin for PulseAudio"
HOMEPAGE = "https://github.com/mer-hybris/pulseaudio-modules-droid"
LICENSE = "LGPL-2.1-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=f294906e6e4eac9d917503a0bbd139b4"

SRC_URI = "git://github.com/mer-hybris/pulseaudio-modules-droid;protocol=https;branch=master \
           file://0002-Remove-audio-sources-that-don-t-exist-for-some-reaso.patch \
           file://0001-Fix-build.patch \
           "
SRCREV = "ab05b2e592b8308585814d7180d1e7c88d3ca4bb"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"
DEPENDS += "pulseaudio libhybris"
RDEPENDS:${PN} += "pulseaudio-module-keepalive"

inherit meson pkgconfig
#B = "${S}"

require pulseaudio-module.inc
