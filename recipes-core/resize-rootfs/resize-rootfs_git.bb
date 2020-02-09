SUMMARY = "Resize rootfs to fill userdata partition."

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

PACKAGE_ARCH = "${MACHINE_ARCH}"

do_install_append() {
    install -d ${D}${bindir}
    cp ${WORKDIR}/resize_rootfs ${D}${bindir}
}

pkg_postinst_ontarget_${PN}() {
    /usr/bin/resize_rootfs
}

RDEPENDS_${PN} += "e2fsprogs-resize2fs"
