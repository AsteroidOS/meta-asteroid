FILESEXTRAPATHS_prepend := "${THISDIR}/libsdl2:"
SRC_URI_append = "file://0001-wayland-Support-wayland-compositors-with-wl_seat-ver.patch"

PACKAGECONFIG_remove = "opengl"
