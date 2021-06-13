SUMMARY = "Android/hybris plugin for PulseAudio"
HOMEPAGE = "https://github.com/mer-hybris/pulseaudio-modules-droid"
LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://COPYING;md5=f294906e6e4eac9d917503a0bbd139b4"

SRC_URI = "git://github.com/mer-hybris/pulseaudio-modules-droid;protocol=https \
        file://0001-Set-version-to-support-PulseAudio-14.patch"
SRCREV = "8283bbe5c932d34f6d427ce02abf455c23b3c3b1"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"
DEPENDS += "pulseaudio libhybris"
RDEPENDS_${PN} += "pulseaudio-module-keepalive"

inherit autotools pkgconfig
B = "${S}"

do_configure_prepend() {
    sed -i "/define QCOM_HARDWARE/d" src/common/droid-util-51.h
}

FILES_${PN} += "/usr/lib/pulse-14.2/modules"
FILES_${PN}-dbg += "/usr/lib/pulse-14.2/modules/.debug/"
FILES_${PN}-staticdev += "/usr/lib/pulse-14.2/modules/*.a"
