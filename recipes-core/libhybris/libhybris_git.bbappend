SRCREV = "${AUTOREV}"
DEPENDS += " wayland "
EXTRA_OECONF += " --enable-wayland --with-default-egl-platform=wayland --enable-trace --enable-debug"
COMPATIBLE_MACHINE_dory = "(^dory$)"
