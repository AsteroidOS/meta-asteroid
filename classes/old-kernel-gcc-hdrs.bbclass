#
# This class is used to create dummy headers for newer versions of GCC not supported by the kernel being compiled
#
# Old kernels ship per-compiler headers (include/linux/compiler-gccN.h) only up
# to whatever GCC major existed at the time. Building with a newer toolchain
# needs a matching header, so we synthesise any that are missing (up to the
# actual kernel compiler's major) as thin shims chaining back to the previous
# version. Headers the kernel already provides are left untouched.
#

do_configure:prepend() {
    to="$(${KERNEL_CC} -dumpversion | cut -d. -f1)"

    for v in $(seq 4 "${to}"); do
        hdr="${S}/include/linux/compiler-gcc${v}.h"
        [ -e "${hdr}" ] || echo "#include <linux/compiler-gcc$(expr $v - 1).h>" > "${hdr}"
    done
}

do_install:prepend() {
    export HOST_EXTRACFLAGS="--std=gnu17"
}
