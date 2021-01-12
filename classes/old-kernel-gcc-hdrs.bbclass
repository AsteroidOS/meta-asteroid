#
# This class is used to create dummy headers for newer versions of GCC not supported by the kernel being compiled
#

do_configure_prepend() {
    echo "#include <linux/compiler-gcc4.h>" > ${S}/include/linux/compiler-gcc5.h
    echo "#include <linux/compiler-gcc5.h>" > ${S}/include/linux/compiler-gcc6.h
    echo "#include <linux/compiler-gcc6.h>" > ${S}/include/linux/compiler-gcc7.h
    echo "#include <linux/compiler-gcc7.h>" > ${S}/include/linux/compiler-gcc8.h
    echo "#include <linux/compiler-gcc8.h>" > ${S}/include/linux/compiler-gcc9.h
    echo "#include <linux/compiler-gcc9.h>" > ${S}/include/linux/compiler-gcc10.h
}

