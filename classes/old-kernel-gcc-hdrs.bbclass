#
# This class is used to create dummy headers for newer versions of GCC not supported by the kernel being compiled
#

do_configure:prepend() {
    echo "#include <linux/compiler-gcc4.h>" > ${S}/include/linux/compiler-gcc5.h
    echo "#include <linux/compiler-gcc5.h>" > ${S}/include/linux/compiler-gcc6.h
    echo "#include <linux/compiler-gcc6.h>" > ${S}/include/linux/compiler-gcc7.h
    echo "#include <linux/compiler-gcc7.h>" > ${S}/include/linux/compiler-gcc8.h
    echo "#include <linux/compiler-gcc8.h>" > ${S}/include/linux/compiler-gcc9.h
    echo "#include <linux/compiler-gcc9.h>" > ${S}/include/linux/compiler-gcc10.h
    echo "#include <linux/compiler-gcc10.h>" > ${S}/include/linux/compiler-gcc11.h
    echo "#include <linux/compiler-gcc11.h>" > ${S}/include/linux/compiler-gcc12.h
    echo "#include <linux/compiler-gcc12.h>" > ${S}/include/linux/compiler-gcc13.h
    echo "#include <linux/compiler-gcc13.h>" > ${S}/include/linux/compiler-gcc14.h
    echo "#include <linux/compiler-gcc14.h>" > ${S}/include/linux/compiler-gcc15.h
}

