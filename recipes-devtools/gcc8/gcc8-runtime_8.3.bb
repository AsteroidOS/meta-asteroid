require gcc8-${PV}.inc
require gcc8-runtime.inc

# Disable ifuncs for libatomic on arm conflicts -march/-mcpu
EXTRA_OECONF:append:arm = " libat_cv_have_ifunc=no "

FILES:libgomp-dev += "\
    ${libdir}/gcc/${TARGET_SYS}/${BINV}/include/openacc.h \
"

# Building with thumb enabled on armv6t fails
ARM_INSTRUCTION_SET:armv6 = "arm"
