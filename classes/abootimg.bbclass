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

    # We're probably interested only in zImage KERNEL_IMAGETYPE, but keep
    # the for loop for consistency with other bbclasses
    for type in ${KERNEL_IMAGETYPES} ; do
        base_name=${type}-${KERNEL_IMAGE_NAME}
        symlink_name=${type}-${KERNEL_IMAGE_LINK_NAME}
        cp ${B}/boot.img ${DEPLOYDIR}/${base_name}.fastboot
        ln -sf ${base_name}.fastboot ${DEPLOYDIR}/${symlink_name}.fastboot
    done

    install -d ${D}/${KERNEL_IMAGEDEST}
    install -m 0644 ${B}/boot.img ${D}/${KERNEL_IMAGEDEST}
}

FILES:${KERNEL_PACKAGE_NAME}-image += "/${KERNEL_IMAGEDEST}/boot.img"
