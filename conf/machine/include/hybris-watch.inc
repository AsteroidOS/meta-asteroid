MACHINE_FEATURES = "alsa bluetooth usbgadget usbhost ext2"

SERIAL_CONSOLE = "115200 ttyHSL0"

PREFERRED_PROVIDER_virtual/mesa = "libhybris"
PREFERRED_PROVIDER_virtual/egl = "libhybris"
PREFERRED_PROVIDER_virtual/libgles1 = "libhybris"
PREFERRED_PROVIDER_virtual/libgles2 = "libhybris"

PREFERRED_PROVIDER_virtual/android-headers = "android"
PREFERRED_PROVIDER_virtual/android-system-image = "android"

KERNEL_IMAGETYPE = "zImage-dtb"
IMAGE_FSTYPES += "ext4"
IMAGE_ROOTFS_ALIGNMENT="4"

IMAGE_INSTALL += "android-tools android-system firmwared"

DEFAULTTUNE = "armv7vehf-neon"
