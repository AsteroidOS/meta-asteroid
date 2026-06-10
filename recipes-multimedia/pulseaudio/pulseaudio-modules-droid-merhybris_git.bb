SUMMARY = "PulseAudio Droid HAL module (mer-hybris upstream, Android 11.x target)"
DESCRIPTION = "Builds the real mer-hybris/pulseaudio-modules-droid -- the A11.x \
target. The jb2q-derived forks (pulseaudio-modules-droid-jb2q, droidian's \
pulseaudio-modules-droid) throw std::runtime_error during port enumeration \
on Halium-13 because the A13 HAL returns device/port types their A10-era \
audio_policy parsers don't know. Halium-13 based machines need this one."

HOMEPAGE = "https://github.com/mer-hybris/pulseaudio-modules-droid"
LICENSE = "LGPL-2.1-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=f294906e6e4eac9d917503a0bbd139b4"

DEPENDS += "pulseaudio libhybris virtual/android-headers dbus udev libevdev"

PACKAGE_ARCH = "${MACHINE_ARCH}"

PV = "11.0.0+git"
SRCREV = "e9ad39c117731dcd663fca2b74baef1c7e427085"

SRC_URI = "git://github.com/mer-hybris/pulseaudio-modules-droid.git;branch=master;protocol=https \
           file://0001-Make-5-enums-optional-for-Halium-android-headers.patch \
"

S = "${WORKDIR}/git"

inherit meson pkgconfig

# Install where PA's MODULE_PATH (libdir/pulseaudio/modules) finds our
# droid card.
EXTRA_OEMESON = "-Dmodlibexecdir=${libdir}/pulseaudio/modules"

# When a machine selects this fork, it is the sole provider of
# "pulseaudio-modules-droid" in its layer set (do NOT add another recipe with
# that literal PN -- a real PN always beats RPROVIDES and would silently ship
# the wrong fork). PROVIDES satisfies build-time deps (e.g.
# pulseaudio-modules-droid-hidl), RPROVIDES the runtime dep a machine's
# pulseaudio bbappend adds.
PROVIDES += "pulseaudio-modules-droid"
RPROVIDES:${PN} += "pulseaudio-modules-droid"
RREPLACES:${PN} += "pulseaudio-modules-droid"
RCONFLICTS:${PN} += "pulseaudio-modules-droid"

FILES:${PN} += "${libdir}/pulseaudio/modules/*.so"
FILES:${PN}-dev += "${libdir}/pulseaudio/modules/*.la"
FILES:${PN}-staticdev += "${libdir}/pulseaudio/modules/*.a"

# Add pulse user to audio group so it can access audio dev nodes from Android
GROUPMEMS_PARAM:${PN} = "-a pulse -g audio -G input"
