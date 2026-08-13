SUMMARY = "AsteroidOS initramfs image"
DESCRIPTION = "Minimal initramfs that bootstraps AsteroidOS from a smartwatch's internal \
flash and switches root into the AsteroidOS rootfs"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

VIRTUAL-RUNTIME_android-initramfs-scripts ?= "asteroid-initramfs-scripts"

IMAGE_INSTALL = "busybox busybox-mdev base-passwd android-tools bash"
IMAGE_INSTALL += "${VIRTUAL-RUNTIME_android-initramfs-scripts}"
IMAGE_FEATURES = ""
IMAGE_ROOTFS_SIZE = "8192"
IMAGE_ROOTFS_EXTRA_SPACE = "0"
export IMAGE_BASENAME = "asteroid-initramfs"
IMAGE_NAME_SUFFIX ?= ""
IMAGE_LINGUAS = ""

BAD_RECOMMENDATIONS += "busybox-syslog"

# NOTE we must use cpio.gz here as this is what mkbootimg requires
IMAGE_FSTYPES:forcevariable = "cpio.gz"

# We don't need depmod data here
KERNELDEPMODDEPEND = ""
USE_DEPMOD = "0"

inherit core-image nopackages
