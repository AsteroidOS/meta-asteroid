FILESEXTRAPATHS:prepend := "${THISDIR}/qtbase:"
SRC_URI += " file://0002-qplatforminputcontextfactory-Use-qtvirtualkeyboard-b.patch"

# Remove dependencies to mesa
PACKAGECONFIG:remove = "tests"
PACKAGECONFIG:remove = "widgets"
PACKAGECONFIG:remove = "gl"
PACKAGECONFIG:append = "gles2 mtdev sql-sqlite glib fontconfig gif"
PACKAGECONFIG_GL:append:qemux86 = " eglfs gbm kms"

QT_CONFIG_FLAGS += "--no-feature-getentropy"

QT_CONFIG_FLAGS += "-no-qpa-platform-guard ${@bb.utils.contains('DISTRO_FEATURES', 'ld-is-gold', '-use-gold-linker', '-no-use-gold-linker', d)}"
PACKAGECONFIG_X11 = "${@bb.utils.contains('DISTRO_FEATURES', 'x11', 'xcb xrender xinput2 glib xkb xkbcommon', 'xkbcommon', d)}"
OPENSSL_LINKING_MODE = "-linked"

DEPENDS += "gstreamer1.0 gstreamer1.0-plugins-base gstreamer1.0-plugins-bad"
