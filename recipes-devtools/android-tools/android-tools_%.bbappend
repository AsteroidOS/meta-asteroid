FILESEXTRAPATHS:prepend := "${THISDIR}/android-tools:"

SRC_URI:append = " file://core/0001-adb_services-Use-syscall-for-reboot.patch;patchdir=system/core "