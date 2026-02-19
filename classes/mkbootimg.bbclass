#
# This class is used to create Android device compatible boot images using mkbootimg
#

MKBOOTIMG_ARGS ?= ""
MKBOOTIMG_HEADER_VERSION ?= "0"
MKBOOTIMG_INIT_BOOT_PRESENT ?= "false"
KERNEL_OUTPUT ?= "${KERNEL_OUTPUT_DIR}/${KERNEL_IMAGETYPE}"

# NOTE: This DTB path almost certainly needs to be overridden.
# The device trees compiled in the Linux build system are missing the Android-specific
# header and need to be run through the mkdtimg script from libufdt.
DTB_OUTPUT ?= "${KERNEL_OUTPUT_DIR}/dts/${KERNEL_DEVICETREE}"

do_deploy[depends] += "initramfs-android-image:do_image_complete mkbootimg-tools-native:do_populate_sysroot"

do_deploy:append() {
    # This function takes one argument, the prefix of the image to deploy (e.g. vendor_)
    deploy_bootimg() {
        # We're probably interested only in zImage KERNEL_IMAGETYPE, but keep
        # the for loop for consistency with other bbclasses
        for type in ${KERNEL_IMAGETYPES}; do
            base_name=${1}${type}-${KERNEL_IMAGE_NAME}
            symlink_name=${1}${type}-${KERNEL_IMAGE_LINK_NAME}
            cp ${B}/${1}boot.img ${DEPLOYDIR}/${base_name}.fastboot
            ln -sf ${base_name}.fastboot ${DEPLOYDIR}/${symlink_name}.fastboot
        done

        install -d ${D}/${KERNEL_IMAGEDEST}
        install -m 0644 ${B}/${1}boot.img ${D}/${KERNEL_IMAGEDEST}
    }

    if [ ${MKBOOTIMG_HEADER_VERSION} -eq 0 ] || [ ${MKBOOTIMG_HEADER_VERSION} -eq 1 ]; then
        # Kernel and initramfs to boot.img
        mkbootimg.py -o ${B}/boot.img \
                  --kernel ${KERNEL_OUTPUT} \
                  --ramdisk ${DEPLOY_DIR_IMAGE}/initramfs-android-image-${MACHINE}.cpio.gz \
                  --header-version ${MKBOOTIMG_HEADER_VERSION} \
                  ${MKBOOTIMG_ARGS}

    elif [ ${MKBOOTIMG_HEADER_VERSION} -eq 2 ]; then
        # Kernel, initramfs, and dtb to boot.img
        mkbootimg.py -o ${B}/boot.img \
                  --kernel ${KERNEL_OUTPUT} \
                  --ramdisk ${DEPLOY_DIR_IMAGE}/initramfs-android-image-${MACHINE}.cpio.gz \
                  --dtb ${DTB_OUTPUT} \
                  --header_version 2 \
                  ${MKBOOTIMG_ARGS}

    elif [ ${MKBOOTIMG_HEADER_VERSION} -eq 3 ] || [ ${MKBOOTIMG_HEADER_VERSION} -eq 4 ]; then
        # Kernel to boot.img, initramfs and dtb to vendor_boot.img
        mkbootimg.py -o ${B}/boot.img \
                  --vendor_boot ${B}/vendor_boot.img \
                  --kernel ${KERNEL_OUTPUT} \
                  --vendor_ramdisk ${DEPLOY_DIR_IMAGE}/initramfs-android-image-${MACHINE}.cpio.gz \
                  --dtb ${DTB_OUTPUT} \
                  --header_version ${MKBOOTIMG_HEADER_VERSION} \
                  ${MKBOOTIMG_ARGS}

        # Not all devices with v3/4 boot images have init_boot
        if [ "${MKBOOTIMG_INIT_BOOT_PRESENT}" = "true" ]; then
            # Stub out init_boot.img
            mkbootimg.py -o ${B}/init_boot.img \
                      --header_version ${MKBOOTIMG_HEADER_VERSION}

            # Deploy init_boot.img
            deploy_bootimg init_
        fi

        # Deploy vendor_boot.img
        deploy_bootimg vendor_

    else
        echo "Error: Invalid MKBOOTIMG_HEADER_VERSION specified! (Specified: \"${MKBOOTIMG_HEADER_VERSION}\", Valid: 0, 1, 2, 3, 4)"
        return 1
    fi

    # Deploy boot.img
    deploy_bootimg
}

FILES:${KERNEL_PACKAGE_NAME}-image += "/${KERNEL_IMAGEDEST}/boot.img"
FILES:${KERNEL_PACKAGE_NAME}-image += "${@'/' + d.getVar('KERNEL_IMAGEDEST') + '/vendor_boot.img' if int(d.getVar('MKBOOTIMG_HEADER_VERSION')) > 2 else ''}"
FILES:${KERNEL_PACKAGE_NAME}-image += "${@'/' + d.getVar('KERNEL_IMAGEDEST') + '/init_boot.img' if d.getVar('MKBOOTIMG_INIT_BOOT_PRESENT') == 'true' else ''}"
