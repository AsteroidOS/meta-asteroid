FILESEXTRAPATHS:prepend := "${THISDIR}/qtvirtualkeyboard:"
SRC_URI += " file://0001-defaultStyle-Use-a-white-handwriting-trace-for-bette.patch \
    file://0002-Modify-default-virtual-keyboard-for-watch.patch"

PACKAGECONFIG = "lipi-toolkit"
