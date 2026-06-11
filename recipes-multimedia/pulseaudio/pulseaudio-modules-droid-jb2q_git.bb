SUMMARY = "Android/hybris plugin for PulseAudio (legacy <= Android 10)"
HOMEPAGE = "https://github.com/mer-hybris/pulseaudio-modules-droid-jb2q"
LICENSE = "LGPL-2.1-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=f294906e6e4eac9d917503a0bbd139b4"

SRC_URI = "git://github.com/mer-hybris/pulseaudio-modules-droid-jb2q;protocol=https;branch=master \
           file://0001-Fix-build.patch \
           "
SRCREV = "bafbe2ec91d77deb1a8bdea321f374d85bd75b01"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"
DEPENDS += "pulseaudio libhybris"
RDEPENDS:${PN} += "pulseaudio-module-keepalive"

inherit meson pkgconfig

require pulseaudio-module.inc
