#
# This class is used to compile a kernel with an older version of GCC as newer versions may introduce issues.
#

KERNEL_CC = "${CCACHE}${HOST_PREFIX}gcc-8 ${HOST_CC_KERNEL_ARCH} -fuse-ld=bfd ${DEBUG_PREFIX_MAP} -fdebug-prefix-map=${STAGING_KERNEL_DIR}=${KERNEL_SRC_PATH} -fdebug-prefix-map=${STAGING_KERNEL_BUILDDIR}=${KERNEL_SRC_PATH}"

DEPENDS += "virtual/${TARGET_PREFIX}gcc8"
DEBUG_PREFIX_MAP:remove = "-fcanon-prefix-map"