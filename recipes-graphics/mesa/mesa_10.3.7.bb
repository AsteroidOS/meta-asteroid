require recipes-graphics/mesa/${BPN}.inc

# different license.html than 12.* version used in oe-core
LIC_FILES_CHKSUM = "file://docs/license.html;md5=6a23445982a7a972ac198e93cc1cb3de"

SRC_URI = "ftp://ftp.freedesktop.org/pub/mesa/older-versions/10.x/${PV}/MesaLib-${PV}.tar.bz2 \
    file://0001-Revert-egl-Check-for-NULL-native_window-in-eglCreate.patch \
    file://0001-loader-include-sys-stat.h-for-non-sysfs-builds.patch \
"

SRC_URI[md5sum] = "8c540465ed7700a24dab7746d400326b"
SRC_URI[sha256sum] = "43c6ced15e237cbb21b3082d7c0b42777c50c1f731d0d4b5efb5231063fb6a5b"

DEPENDS += "udev"

S = "${WORKDIR}/Mesa-${PV}"

# This version doesn't have --with-sha option
PACKAGECONFIG_remove = "${MESA_CRYPTO}"

PACKAGECONFIG[gallium-egl]  = "--enable-gallium-egl, --disable-gallium-egl"
PACKAGECONFIG[gallium-gbm]  = "--enable-gallium-gbm, --disable-gallium-gbm"

PACKAGES =+ "libegl-gallium libgbm-gallium"
FILES_libegl-gallium = "${libdir}/egl/egl_gallium.so*"
FILES_libgbm-gallium = "${libdir}/gbm/gbm_gallium_drm.so*"

# We want the fbdev platform as well
EGL_PLATFORMS_append = ",fbdev"

PACKAGECONFIG_append = " gallium-egl gallium-gbm gallium"

#because we cannot rely on the fact that all apps will use pkgconfig,
#make eglplatform.h independent of MESA_EGL_NO_X11_HEADER
do_install_append() {
    if ${@bb.utils.contains('PACKAGECONFIG', 'egl', 'true', 'false', d)}; then
        sed -i -e 's/^#ifdef MESA_EGL_NO_X11_HEADERS$/#if defined(MESA_EGL_NO_X11_HEADERS) || ${@bb.utils.contains('PACKAGECONFIG', 'x11', '0', '1', d)}/' ${D}${includedir}/EGL/eglplatform.h
    fi
}
