SUMMARY = "Android/hybris plugin for PulseAudio"
HOMEPAGE = "https://github.com/mer-hybris/pulseaudio-modules-droid"
LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://COPYING;md5=f294906e6e4eac9d917503a0bbd139b4"

SRC_URI = "git://github.com/mer-hybris/pulseaudio-modules-droid;protocol=https \
           file://0001-Use-pa_card_put-and-pa_card_choose_initial_profile.patch \
           file://0002-Install-modules-to-usr-lib-pulse-9.0.patch"
SRCREV = "e28d1e22d3b0963e457e4fa45b952536ca415c9e"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"
DEPENDS += "pulseaudio libhybris"

inherit autotools pkgconfig
B = "${S}"

do_configure_prepend() {
    sed -i "/define QCOM_HARDWARE/d" src/common/droid-util-51.h
}

FILES_${PN} += "/usr/lib/pulse-9.0/modules"
FILES_${PN}-dbg += "/usr/lib/pulse-9.0/modules/.debug/"
FILES_${PN}-staticdev += "/usr/lib/pulse-9.0/modules/*.a"
