FILESEXTRAPATHS:prepend := "${THISDIR}/libhybris:"
SRCREV = "a108a1d30fbbdb562f7748292dab0e2d6e5250ce"

SRC_URI:remove = "file://0001-Add-EGL_OPENGL_ES3_BIT_KHR-define.patch;patchdir=.."
SRC_URI:remove = "file://0001-wayland-egl.pc.in-bump-Version-from-libhybris-s-0.1..patch;patchdir=.."
LIC_FILES_CHKSUM = "file://../LICENSE.Apache2;md5=3b83ef96387f14655fc854ddc3c6bd57"

DEPENDS:append = " wayland "
EXTRA_OECONF:append = " --enable-wayland --with-default-egl-platform=wayland --with-default-hybris-ld-library-path=/usr/libexec/hal-droid/system/lib:/vendor/lib:/system/lib"

COMPATIBLE_MACHINE=""

do_configure:prepend() {
    sed -i "s@=\`\$PKG_CONFIG@=\$\{PKG_CONFIG_SYSROOT_DIR\}\`\$PKG_CONFIG@" ${S}/configure.ac
}
