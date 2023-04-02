SUMMARY = "Downloads the Andrdoid armv7 Oreo with hwcomposer patches for the Snapdragon Wear 2100/3100 platform /usr/libexec/hal-droid and /usr/include/android folders and installs them for libhybris"
LICENSE = "CLOSED"

SRC_URI = "https://dl.dropboxusercontent.com/s/4d8pkmd62rxl464/hybris-o-msm8909.tar.gz"
SRC_URI[md5sum] = "039a387a3e4ccd09d28b05195280d162"
SRC_URI[sha256sum] = "ddc725dd280d8c5f546ff47f727b67ea99def9a4883edeebfe0edfdc5a61a636"
PV = "armv7+oreo"

require android.inc
