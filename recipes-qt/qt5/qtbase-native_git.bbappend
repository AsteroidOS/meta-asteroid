FILESEXTRAPATHS:prepend := "${THISDIR}/qtbase:"
SRC_URI += "file://0001-xkb-fix-build-with-libxkbcommon-1.6.0-and-later.patch"

PACKAGECONFIG:append = " gui "
PACKAGECONFIG_CONFARGS:append = " -make tools "
