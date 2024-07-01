FILESEXTRAPATHS:prepend := "${THISDIR}/libhybris:"

DEPENDS:append = " wayland "
EXTRA_OECONF:append = " --enable-wayland --with-default-egl-platform=wayland --with-default-hybris-ld-library-path=/usr/libexec/hal-droid/system/lib:/vendor/lib:/system/lib"

TARGET_CC_ARCH:remove = "-D_LARGEFILE_SOURCE -D_FILE_OFFSET_BITS=64 -D_TIME_BITS=64"
INSANE_SKIP:append:pn-${PN} = "32bit-time"

COMPATIBLE_MACHINE=""

do_configure:prepend() {
    sed -i "s@=\`\$PKG_CONFIG@=\$\{PKG_CONFIG_SYSROOT_DIR\}\`\$PKG_CONFIG@" ${S}/configure.ac
}
