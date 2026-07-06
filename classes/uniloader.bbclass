#
# This class builds the built Linux kernel, DTB, and initramfs into uniLoader
#

DEPENDS:append = " uniloader"

# Can be either uniLoader or uniLoader.gz
UNILOADER_IMAGE ?= "uniLoader"
MACHINE_DEFCONFIG ?= "${MACHINE}_defconfig"

# We are taking the place of the kernel here
KERNEL_OUTPUT = "${B}/uniloader/${UNILOADER_IMAGE}"

addtask do_prepare_uniloader after do_compile before do_deploy
do_prepare_uniloader[depends] = "uniloader:do_install initramfs-android-image:do_image_complete"

do_prepare_uniloader() {
    # Ensure the kernel image is an executable format
    if [[ ! "${KERNEL_IMAGETYPE}" =~ "^(Image|zImage|bzImage)$" ]]; then
        echo "Error: Incompatible KERNEL_IMAGETYPE specified! (Specified: \"${KERNEL_IMAGETYPE}\", Compatible: \"Image\", \"zImage\", \"bzImage\")"
        return 1
    fi

    # Copy the uniLoader source into our build directory
    cp -r "${RECIPE_SYSROOT}/uniloader" "${B}/uniloader"

    # Integrate the newly built kernel, dtb, and initramfs blobs into the source
    cp "${B}/${KERNEL_OUTPUT_DIR}/${KERNEL_IMAGETYPE}" "${B}/uniloader/blob/Image"
    cp "${B}/${KERNEL_OUTPUT_DIR}/dts/${KERNEL_DEVICETREE}" "${B}/uniloader/blob/dtb"
    cp "${DEPLOY_DIR_IMAGE}/initramfs-android-image-${MACHINE}.cpio.gz" "${B}/uniloader/blob/ramdisk"
}

addtask do_configure_uniloader after do_prepare_uniloader before do_deploy

do_configure_uniloader() {
    cd "${B}/uniloader"
    oe_runmake "${PARALLEL_MAKE}" "${MACHINE_DEFCONFIG}"
}

addtask do_compile_uniloader after do_configure_uniloader before do_deploy

do_compile_uniloader() {
    cd "${B}/uniloader"

    # The Makefile doesn't seem to be able to find libgcc on its own in this environment,
    # so we tell it where it is with LIBGCC.
    # We also clear the LDFLAGS due to them containing GCC args but being passed to LD.
    oe_runmake "${PARALLEL_MAKE}" ARCH="${TARGET_ARCH}" CROSS_COMPILE="${TARGET_PREFIX}" LDFLAGS="" \
               LIBGCC="${RECIPE_SYSROOT}/usr/lib/${TARGET_SYS}/$(${TARGET_PREFIX}gcc -dumpversion)/libgcc.a"
}
