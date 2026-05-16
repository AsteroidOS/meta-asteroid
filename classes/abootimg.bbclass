#
# This class is used to create Android device compatible boot.img files with kernel and initrd using abootimg
#

KERNEL_OUTPUT ?= "${KERNEL_OUTPUT_DIR}/${KERNEL_IMAGETYPE}"

ABOOTIMG_ARGS ?= ""

do_deploy[depends] += "initramfs-android-image:do_image_complete abootimg-native:do_populate_sysroot"

do_deploy:append() {
    abootimg --create ${B}/boot.img \
             -k ${B}/${KERNEL_OUTPUT} \
             -r ${DEPLOY_DIR_IMAGE}/initramfs-android-image-${MACHINE}.cpio.gz \
             ${ABOOTIMG_ARGS}

    cp ${B}/boot.img ${DEPLOYDIR}/boot.img

    install -d ${D}/${KERNEL_IMAGEDEST}
    install -m 0644 ${B}/boot.img ${D}/${KERNEL_IMAGEDEST}
}

FILES:${KERNEL_PACKAGE_NAME}-image += "/${KERNEL_IMAGEDEST}/boot.img"
