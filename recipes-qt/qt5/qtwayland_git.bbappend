FILESEXTRAPATHS:prepend := "${THISDIR}/qtwayland:"
SRC_URI += " file://0001-Forces-GLES2-the-dirty-way.patch \
             file://0002-Revert-most-of-Remove-QWaylandExtendedSurface-from-t.patch \
             file://0003-xdg-shell-Add-support-for-extended-surfaces.patch"

DEPENDS:remove = "${XKB_DEPENDS}"
