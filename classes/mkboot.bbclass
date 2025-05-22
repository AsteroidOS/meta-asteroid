#
# This class is used to create Android device compatible boot.img files with kernel and initrd using mkboot
#

KERNEL_OUTPUT ?= "${KERNEL_OUTPUT_DIR}/${KERNEL_IMAGETYPE}"

do_deploy[depends] += "initramfs-android-image:do_image_complete mkbootimg-tools-native:do_populate_sysroot"

do_deploy:append() {
    cd ${B}
    cp ${UNPACKDIR}/img_info .
    sed -i "s@%%KERNEL%%@${B}/${KERNEL_OUTPUT}@" img_info
    sed -i "s@%%KERNEL_SIZE%%@$(stat --printf="%s" ${B}/${KERNEL_OUTPUT})@" img_info
    sed -i "s@%%RAMDISK%%@${DEPLOY_DIR_IMAGE}/initramfs-android-image-${MACHINE}.cpio.gz@" img_info
    sed -i "s@%%RAMDISK_SIZE%%@$(stat --printf="%s" ${DEPLOY_DIR_IMAGE}/initramfs-android-image-${MACHINE}.cpio.gz)@" img_info
    mkboot . boot.img || { echo "mkboot failed"; exit 1; }

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
