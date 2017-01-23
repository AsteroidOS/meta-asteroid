SRC_URI = "git://github.com/libhybris/libhybris;branch=master;protocol=https"
SRCREV = "085cd7e06058708104c4d4244266881fd1757585"
DEPENDS += " wayland "
EXTRA_OECONF += " --enable-wayland --with-default-egl-platform=wayland --with-default-hybris-ld-library-path=/usr/libexec/hal-droid/system/lib:/vendor/lib:/system/lib"

COMPATIBLE_MACHINE=""

do_configure_append() {
     # Use the OE's wayland-scanner (it is in PATH before the host's version)
     sed -i "s@\$(WAYLAND_SCANNER)@wayland-scanner@" ${S}/egl/platforms/common/Makefile.am
}
