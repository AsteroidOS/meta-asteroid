SUMMARY = "PulseAudio Droid HIDL module"
LICENSE = "LGPL-2.1-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=f294906e6e4eac9d917503a0bbd139b4"

DEPENDS += "pulseaudio libhybris virtual/android-headers dbus audiosystem-passthrough pulseaudio-modules-droid"

RDEPENDS:${PN} += "pulseaudio-module-dbus-protocol"

PACKAGE_ARCH = "${MACHINE_ARCH}"

PV = "1.4.0+git"
SRCREV = "96f02cfe157ab271646f37ba374e2f5be3cfdf55"

SRC_URI = "git://github.com/droidian/pulseaudio-modules-droid-hidl.git;branch=bookworm;protocol=https \
    file://0001-module-hidl-use-PA_MAJORMINOR-as-PA_MODULE_VERSION-.patch \
"

EXTRA_OECONF = "--with-module-dir=${libdir}/pulseaudio/modules"

S = "${WORKDIR}/git"

inherit autotools pkgconfig

FILES:${PN} += "${libdir}/pulseaudio/modules/*.so"
FILES:${PN}-dev += "${libdir}/pulseaudio/modules/*.la"
FILES:${PN}-staticdev += "${libdir}/pulseaudio/modules/*.a"

# Add pulse user to audio group so he can access audio dev nodes from Android
GROUPMEMS_PARAM:${PN} = "-a pulse -g audio -G input"
