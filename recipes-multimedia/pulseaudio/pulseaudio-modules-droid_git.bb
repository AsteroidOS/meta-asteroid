SUMMARY = "Android/hybris plugin for PulseAudio"
HOMEPAGE = "https://github.com/mer-hybris/pulseaudio-modules-droid"
LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://COPYING;md5=f294906e6e4eac9d917503a0bbd139b4"

SRC_URI = "git://github.com/mer-hybris/pulseaudio-modules-droid;protocol=https \
        file://0001-Set-version-to-13-to-support-PulseAudio-13.patch"
SRCREV = "22be43a324fee369c488c7b6b12282b133b38b95"
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

FILES_${PN} += "/usr/lib/pulse-13.0/modules"
FILES_${PN}-dbg += "/usr/lib/pulse-13.0/modules/.debug/"
FILES_${PN}-staticdev += "/usr/lib/pulse-13.0/modules/*.a"
