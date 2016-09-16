FILESEXTRAPATHS_prepend := "${THISDIR}/qtwayland:"
SRC_URI += " file://0001-Forces-GLES2-the-dirty-way.patch \
             file://0002-Revert-Support-EGLStream-in-wayland-egl.patch \
             file://0003-Fix-build-with-no-accessibility.patch"

DEPENDS_remove = "${XKB_DEPENDS}"
