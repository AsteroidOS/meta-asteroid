SRCREV = "bd6df6a3064f50df326a4644cc7660c0a587b50e"
DEPENDS += " wayland "
EXTRA_OECONF += " --enable-wayland --with-default-egl-platform=wayland"
COMPATIBLE_MACHINE_dory = "(^dory$)"
COMPATIBLE_MACHINE_bass = "(^bass$)"

do_configure_append() {
     # Use the OE's wayland-scanner (it is in PATH before the host's version)
     sed -i "s@\$(WAYLAND_SCANNER)@wayland-scanner@" ${S}/egl/platforms/common/Makefile.am
}
