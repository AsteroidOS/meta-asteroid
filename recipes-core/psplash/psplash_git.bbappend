FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
DEPENDS += "gdk-pixbuf-native"
SRC_URI += "file://psplash-colors.h \
file://psplash-bar-img.png \
file://0001-Don-t-draw-progress-and-message-bar.patch \
"
SPLASH_IMAGES = "file://psplash-poky-img.png;outsuffix=default"

do_configure_append () {
    cd ${S}
    cp ../psplash-colors.h ./
    cp ../psplash-bar-img.png ./psplash-bar.png
    ./make-image-header.sh ./psplash-bar.png BAR
}

# Erase psplash's pkg_postinst which masks psplash from systemd
pkg_postinst_${PN} () {
}
