FILESEXTRAPATHS_prepend := "${THISDIR}/libsdl2:"
SRC_URI_append = "file://0001-wayland-support-wl_data_device_manager-version-3.patch"

PACKAGECONFIG_remove = "opengl"
