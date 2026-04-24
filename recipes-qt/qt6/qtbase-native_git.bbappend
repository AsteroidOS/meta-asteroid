FILESEXTRAPATHS:prepend := "${THISDIR}/qtbase:"

PACKAGECONFIG:append = " gui "
PACKAGECONFIG_CONFARGS:append = " -make tools "
