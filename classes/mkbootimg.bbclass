#
# This class is used to create Android device compatible boot images using mkbootimg
#

MKBOOTIMG_ARGS ?= ""
MKBOOTIMG_VENDOR_ARGS ?= ""
MKBOOTIMG_DT_ARGS ?= ""
MKBOOTIMG_DTBO_ARGS ?= ""
MKBOOTIMG_HEADER_VERSION ?= "0"
MKBOOTIMG_VENDOR_BOOT ?= "false"
MKBOOTIMG_INIT_BOOT ?= "false"
MKBOOTIMG_DTBO ?= "false"
KERNEL_OUTPUT ?= "${KERNEL_OUTPUT_DIR}/${KERNEL_IMAGETYPE}"
DTB_OUTPUT ?= "${KERNEL_OUTPUT_DIR}/dts/${KERNEL_DEVICETREE}"

do_deploy[depends] += "initramfs-android-image:do_image_complete \
                       mkbootimg-tools-native:do_populate_sysroot \
                       mkdtboimg-native:do_populate_sysroot \
                       dtc-native:do_populate_sysroot"

do_deploy:append() {
    # This function takes one argument, the name of the image to deploy (e.g. vendor_boot.img)
    deploy_bootimg() {
        cp "${B}"/"${1}" "${DEPLOYDIR}"
        install -d "${D}"/"${KERNEL_IMAGEDEST}"
        install -m 0644 "${B}"/"${1}" "${D}"/"${KERNEL_IMAGEDEST}"
    }

    if [ "${MKBOOTIMG_HEADER_VERSION}" -eq 0 ] || [ "${MKBOOTIMG_HEADER_VERSION}" -eq 1 ]; then
        # Kernel and initramfs to boot.img
        mkbootimg -o "${B}"/boot.img \
                  --kernel "${KERNEL_OUTPUT}" \
                  --ramdisk "${DEPLOY_DIR_IMAGE}"/initramfs-android-image-"${MACHINE}".cpio.gz \
                  --header-version "${MKBOOTIMG_HEADER_VERSION}" \
                  ${MKBOOTIMG_ARGS}

    elif [ "${MKBOOTIMG_HEADER_VERSION}" -eq 2 ]; then
        # Add the Android-specific header to the DTB
	mkdtboimg create ${MKBOOTIMG_DT_ARGS} "${B}"/dt.dtb.android "${DTB_OUTPUT}"

        # Kernel, initramfs, and dtb to boot.img
        mkbootimg -o "${B}"/boot.img \
                  --kernel "${KERNEL_OUTPUT}" \
                  --ramdisk "${DEPLOY_DIR_IMAGE}"/initramfs-android-image-"${MACHINE}".cpio.gz \
                  --dtb "${B}"/dt.dtb.android \
                  --header_version 2 \
                  ${MKBOOTIMG_ARGS}

    elif [ "${MKBOOTIMG_HEADER_VERSION}" -eq 3 ] || [ "${MKBOOTIMG_HEADER_VERSION}" -eq 4 ]; then
        # Add the Android-specific header to the DTB
        mkdtboimg create ${MKBOOTIMG_DT_ARGS} "${B}"/dt.dtb.android "${DTB_OUTPUT}"

        # Kernel to boot.img, initramfs and dtb to vendor_boot.img
        mkbootimg -o "${B}"/boot.img \
                  --kernel "${KERNEL_OUTPUT}" \
                  --header_version "${MKBOOTIMG_HEADER_VERSION}" \
                  ${MKBOOTIMG_ARGS}

        # We might not always want to generate vendor_boot (e.g. if we're using uniLoader)
        if [ "${MKBOOTIMG_VENDOR_BOOT}" = "true" ]; then
            # Generate vendor_boot
            mkbootimg --vendor_boot "${B}"/vendor_boot.img \
                      --vendor_ramdisk "${DEPLOY_DIR_IMAGE}"/initramfs-android-image-"${MACHINE}".cpio.gz \
                      --dtb "${B}"/dt.dtb.android \
                      --header_version "${MKBOOTIMG_HEADER_VERSION}" \
                      ${MKBOOTIMG_VENDOR_ARGS}

            # Deploy vendor_boot.img
            deploy_bootimg vendor_boot.img
        fi

        # Not all devices with v3/4 boot images have init_boot
        if [ "${MKBOOTIMG_INIT_BOOT}" = "true" ]; then
            # Stub out init_boot.img
            mkbootimg -o "${B}"/init_boot.img \
                      --header_version "${MKBOOTIMG_HEADER_VERSION}"

            # Deploy init_boot.img
            deploy_bootimg init_boot.img
        fi
    else
        echo "Error: Invalid MKBOOTIMG_HEADER_VERSION specified! (Specified: \"${MKBOOTIMG_HEADER_VERSION}\", Valid: 0, 1, 2, 3, 4)"
        return 1
    fi

    # Deploy boot.img
    deploy_bootimg boot.img

    if [ "${MKBOOTIMG_DTBO}" = "true" ]; then
        # Generate a blank DTBO
        cat > "${B}"/dt.dtso << EOF
            /dts-v1/;
            / {};
EOF

        dtc -I dts -O dtb -o "${B}"/dt.dtbo "${B}"/dt.dtso

        # Add the Android-specific header to the DTBO
        mkdtboimg create ${MKBOOTIMG_DTBO_ARGS} "${B}"/dtbo.img "${B}"/dt.dtbo

        # Deploy the DTBO
        deploy_bootimg dtbo.img
    fi
}

FILES:${KERNEL_PACKAGE_NAME}-image += "/${KERNEL_IMAGEDEST}/boot.img"
FILES:${KERNEL_PACKAGE_NAME}-image += "${@'/' + d.getVar('KERNEL_IMAGEDEST') + '/vendor_boot.img' if d.getVar('MKBOOTIMG_VENDOR_BOOT') == 'true' else ''}"
FILES:${KERNEL_PACKAGE_NAME}-image += "${@'/' + d.getVar('KERNEL_IMAGEDEST') + '/init_boot.img' if d.getVar('MKBOOTIMG_INIT_BOOT') == 'true' else ''}"
FILES:${KERNEL_PACKAGE_NAME}-image += "${@'/' + d.getVar('KERNEL_IMAGEDEST') + '/dtbo.img' if d.getVar('MKBOOTIMG_DTBO') == 'true' else ''}"
