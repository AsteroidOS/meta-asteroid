#
# This class is used to create Android device compatible boot.img files with kernel and initrd using mkbootimg
#

MKBOOTIMG_ARGS ?= ""
KERNEL_OUTPUT ?= "${KERNEL_OUTPUT_DIR}/${KERNEL_IMAGETYPE}"

do_compile[depends] += "initramfs-android-image:do_image_complete"
DEPENDS += "mkbootimg-tools-native"

do_compile_append() {
    mkbootimg -o ${B}/boot.img \
              --kernel ${KERNEL_OUTPUT}  \
              --ramdisk ${DEPLOY_DIR_IMAGE}/initramfs-android-image-${MACHINE}.cpio.gz \
              ${MKBOOTIMG_ARGS}
}

do_deploy_append() {
    # We're probably interested only in zImage KERNEL_IMAGETYPE, but keep
    # the for loop for consistency with other bbclasses
    for type in ${KERNEL_IMAGETYPES} ; do
        base_name=${type}-${KERNEL_IMAGE_NAME}
        symlink_name=${type}-${KERNEL_IMAGE_LINK_NAME}
        cp ${B}/boot.img ${DEPLOYDIR}/${base_name}.fastboot
        ln -sf ${base_name}.fastboot ${DEPLOYDIR}/${symlink_name}.fastboot
    done
}

# Update mechanism

do_install_append() {
    install -d ${D}/${KERNEL_IMAGEDEST}
    install -m 0644 ${B}/boot.img ${D}/${KERNEL_IMAGEDEST}
}

pkg_postinst_ontarget_${KERNEL_PACKAGE_NAME}-image_append () {
    if [ ! -e /boot/boot.img ] ; then
        # if the boot image is not available here something went wrong and we don't
        # continue with anything that can be dangerous
        exit 1
    fi

    BOOT_PARTITION_NAMES="LNX boot KERNEL"
    for i in $BOOT_PARTITION_NAMES; do
        path=$(find /dev -name "*$i*"|grep disk| head -n 1)
        [ -n "$path" ] && break
    done

    if [ -z "$path" ] ; then
        echo "Boot partition does not exist!"
        exit 1
    fi

    echo "Flashing the new kernel /boot/boot.img to $path"
    dd if=/boot/boot.img of=$path
}

FILES_${KERNEL_PACKAGE_NAME}-image += "/${KERNEL_IMAGEDEST}/boot.img"
