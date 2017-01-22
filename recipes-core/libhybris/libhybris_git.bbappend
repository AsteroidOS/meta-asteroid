SRC_URI = "git://github.com/libhybris/libhybris;branch=master;protocol=https"
SRCREV = "d4741e6675582c248228a41f4c1616fbf39fd3e6"
DEPENDS += " wayland "
EXTRA_OECONF += " --enable-wayland --with-default-egl-platform=wayland --with-default-hybris-ld-library-path=/usr/libexec/hal-droid/system/lib:/vendor/lib:/system/lib"

COMPATIBLE_MACHINE=""

do_configure_append() {
     # Use the OE's wayland-scanner (it is in PATH before the host's version)
     sed -i "s@\$(WAYLAND_SCANNER)@wayland-scanner@" ${S}/egl/platforms/common/Makefile.am
}
