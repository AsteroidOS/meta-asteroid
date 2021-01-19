inherit crosssdk

PN = "gcc8-crosssdk-${SDK_SYS}"

SYSTEMHEADERS = "${SDKPATHNATIVE}${prefix_nativesdk}/include"
SYSTEMLIBS = "${SDKPATHNATIVE}${base_libdir_nativesdk}/"
SYSTEMLIBS1 = "${SDKPATHNATIVE}${libdir_nativesdk}/"

GCCMULTILIB = "--disable-multilib"

DEPENDS = "virtual/${TARGET_PREFIX}binutils-crosssdk gettext-native ${NATIVEDEPS}"
PROVIDES = "virtual/${TARGET_PREFIX}gcc8-crosssdk virtual/${TARGET_PREFIX}g++8-crosssdk"
