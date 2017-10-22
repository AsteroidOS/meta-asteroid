FILESEXTRAPATHS_prepend := "${THISDIR}/libhybris:"
SRC_URI += " file://0001-Disable-wifi-module.patch;striplevel=2"

DEPENDS += " wayland "
EXTRA_OECONF += " --enable-wayland --with-default-egl-platform=wayland --with-default-hybris-ld-library-path=/usr/libexec/hal-droid/system/lib:/vendor/lib:/system/lib"

COMPATIBLE_MACHINE=""
