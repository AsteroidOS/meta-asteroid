FILESEXTRAPATHS_prepend := "${THISDIR}/qtbase:"
SRC_URI += " file://0001-Forces-GLES2-the-dirty-way.patch \
             file://0002-qplatforminputcontextfactory-Use-qtvirtualkeyboard-b.patch"

# Remove dependencies to mesa
PACKAGECONFIG_remove = "kms"
PACKAGECONFIG_remove = "widgets"
PACKAGECONFIG_remove = "gl"
PACKAGECONFIG_append = "gles2 mtdev sql-sqlite glib fontconfig"
PACKAGECONFIG_append_qemux86 = " eglfs gbm kms"
RDEPENDS_${PN}_append_qemux86 = "vboxguestdrivers libegl-gallium libgbm-gallium"

QT_CONFIG_FLAGS += "-no-qpa-platform-guard ${@bb.utils.contains('DISTRO_FEATURES', 'ld-is-gold', '-use-gold-linker', '-no-use-gold-linker', d)}"
PACKAGECONFIG_X11 = "${@bb.utils.contains('DISTRO_FEATURES', 'x11', 'xcb xrender xinput2 glib xkb xkbcommon-evdev', 'xkbcommon-evdev', d)}"
