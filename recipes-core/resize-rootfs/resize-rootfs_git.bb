SUMMARY = "Resize rootfs to fill userdata partition."

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

PACKAGE_ARCH = "${MACHINE_ARCH}"

ALLOW_EMPTY_${PN} = "1"

pkg_postinst_ontarget_${PN}() {
    root=`mount | grep "on / " | awk -F' ' '{print $1}'`
    if [[ "$root" == *"sdcard"* ]]; then
    echo "Running on temporary installation, ignoring resize of filesystem."
    else
    echo "Resizing root partition to fill userdata..."
    resize2fs "$root"
    fi
}

RDEPENDS_${PN} += "e2fsprogs-resize2fs"
