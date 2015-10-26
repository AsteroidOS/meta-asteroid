SRCREV = "bd6df6a3064f50df326a4644cc7660c0a587b50e"
DEPENDS += " wayland "
EXTRA_OECONF += " --enable-wayland --with-default-egl-platform=wayland --enable-trace --enable-debug"
COMPATIBLE_MACHINE_dory = "(^dory$)"
