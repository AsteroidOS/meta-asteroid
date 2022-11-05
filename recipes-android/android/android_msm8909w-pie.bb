SUMMARY = "Downloads the Snapdragon Wear 3100 /usr/libexec/hal-droid and /usr/include/android folders and installs them for libhybris"
LICENSE = "CLOSED"

SRC_URI = "https://dl.dropboxusercontent.com/s/2btck4hlowhronv/hybris-p-msm8909w.tar.gz"
SRC_URI[md5sum] = "cc084ae844473e074f06391033a08c46"
SRC_URI[sha256sum] = "d7d91700007795aedcdf4fffa418552edf2b3fd41a0223367401906f4f4dfed3"
PV = "msm8909w+pie"

require android.inc
