FILESEXTRAPATHS:prepend := "${THISDIR}/libhybris:"
SRCREV = "fae0a52632893cbf3bb7ce0762147b7067db176b"

DEPENDS:append = " wayland "
EXTRA_OECONF:append = " --enable-wayland --with-default-egl-platform=wayland --with-default-hybris-ld-library-path=/usr/libexec/hal-droid/system/lib:/vendor/lib:/system/lib"

COMPATIBLE_MACHINE=""

do_install:append () {
# libwayland-egl has been moved to wayland 1.15+
  rm -f ${D}${libdir}/libwayland-egl*
  rm -f ${D}${libdir}/pkgconfig/wayland-egl.pc
}
