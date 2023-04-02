SUMMARY = "Downloads the Andrdoid armv7 Pie with 32-bit binder /usr/libexec/hal-droid and /usr/include/android folders and installs them for libhybris"
LICENSE = "CLOSED"

SRC_URI = "https://dl.dropboxusercontent.com/s/xhtzxu3i1rj550x/hybris-p-msm8909.tar.gz"
SRC_URI[md5sum] = "498f109103d8442ad9c0308da9109cc1"
SRC_URI[sha256sum] = "a13c40696d905076f71a5edc9810c40e628428c6eb4d4bd46d66b9c0c705db4d"
PV = "armv7+pie32"

require android.inc
