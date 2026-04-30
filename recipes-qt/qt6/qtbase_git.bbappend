FILESEXTRAPATHS:prepend := "${THISDIR}/qtbase:"
SRC_URI += " file://0001-libhybris-egl-server-Fix-build.patch "
#SRC_URI += " file://0002-qplatforminputcontextfactory-Use-qtvirtualkeyboard-b.patch"

PACKAGECONFIG:append = " gles2 mtdev sql-sqlite glib fontconfig "
PACKAGECONFIG_GL:append = " eglfs gbm kms "

# Remove dependencies to mesa on hybris-based machines
PACKAGECONFIG:remove:hybris-machine = " tests widgets gl gbm "
PACKAGECONFIG_GL:remove:hybris-machine = " eglfs gbm kms "

QT_CONFIG_FLAGS += "--no-feature-getentropy"

QT_CONFIG_FLAGS += "-no-qpa-platform-guard ${@bb.utils.contains('DISTRO_FEATURES', 'ld-is-gold', '-use-gold-linker', '-no-use-gold-linker', d)}"
PACKAGECONFIG_X11 = "${@bb.utils.contains('DISTRO_FEATURES', 'x11', 'xcb xrender xinput2 glib xkb xkbcommon', 'xkbcommon', d)}"
OPENSSL_LINKING_MODE = "-linked"

PACKAGECONFIG:remove = "gbm kms"
PACKAGECONFIG:remove:class-native = "libinput gbm"
PACKAGECONFIG:remove:class-nativesdk = "libinput gbm"
