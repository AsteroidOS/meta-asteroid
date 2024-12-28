FILESEXTRAPATHS:prepend := "${THISDIR}/libhybris:"

SRCREV = "9f61f26c44d9a3bf62efb67d4c32a7a0c89c21ca"
SRC_URI:remove = "file://0001-eglplatform.h-take-MESA_EGL_NO_X11_HEADERS-into-acco.patch;patchdir=.."
SRC_URI:append = " file://0001-Remove-references-to-host-path-in-package-config-fil.patch;patchdir=.."
SRC_URI:append = " file://0002-tests-workaround-Wimplicit-function-declaration-in-s.patch;patchdir=.."

DEPENDS:append = " wayland "
EXTRA_OECONF:append = " --enable-wayland --with-default-egl-platform=wayland --with-default-hybris-ld-library-path=/usr/libexec/hal-droid/system/lib:/vendor/lib:/system/lib"

TARGET_CC_ARCH:remove = "-D_LARGEFILE_SOURCE -D_FILE_OFFSET_BITS=64 -D_TIME_BITS=64"
INSANE_SKIP:append:pn-${PN} = "32bit-time"

COMPATIBLE_MACHINE=""

do_configure:prepend() {
    sed -i "s@=\`\$PKG_CONFIG@=\$\{PKG_CONFIG_SYSROOT_DIR\}\`\$PKG_CONFIG@" ${S}/configure.ac
}
