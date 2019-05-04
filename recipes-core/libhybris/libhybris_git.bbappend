FILESEXTRAPATHS_prepend := "${THISDIR}/libhybris:"
SRCREV = "fae0a52632893cbf3bb7ce0762147b7067db176b"

DEPENDS += " wayland "
EXTRA_OECONF += " --enable-experimental --enable-wayland --with-default-egl-platform=wayland --with-default-hybris-ld-library-path=/usr/libexec/hal-droid/system/lib:/vendor/lib:/system/lib"

COMPATIBLE_MACHINE=""
