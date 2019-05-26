SUMMARY = "Android/hybris plugin for PulseAudio"
HOMEPAGE = "https://github.com/mer-hybris/pulseaudio-modules-droid"
LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://COPYING;md5=f294906e6e4eac9d917503a0bbd139b4"

SRC_URI = "git://github.com/mer-hybris/pulseaudio-modules-droid;protocol=https"
SRCREV = "96c4e2ea97bd9fa488f47e6f687ddb22e4c64dd7"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"
DEPENDS += "pulseaudio libhybris"

inherit autotools pkgconfig
B = "${S}"

do_configure_prepend() {
    sed -i "/define QCOM_HARDWARE/d" src/common/droid-util-51.h
}

FILES_${PN} += "/usr/lib/pulse-12.2/modules"
FILES_${PN}-dbg += "/usr/lib/pulse-12.2/modules/.debug/"
FILES_${PN}-staticdev += "/usr/lib/pulse-12.2/modules/*.a"
