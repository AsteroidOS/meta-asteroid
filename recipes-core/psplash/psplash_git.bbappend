FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
DEPENDS += "gdk-pixbuf-native"
SRC_URI += "file://psplash-colors.h \
            file://psplash-bar-img.png \
            file://psplash-config.h \
            file://0001-Don-t-draw-progress-and-message-bar.patch \
            file://psplash-img-280.png \
            file://psplash-img-320.png"
SPLASH_IMAGES = "file://psplash-img-320.png;outsuffix=default"

PACKAGE_ARCH = "${MACHINE_ARCH}"

do_configure_append () {
    cd ${S}
    cp ../psplash-config.h ./psplash-config.h
    cp ../psplash-colors.h ./psplash-colors.h
    cp ../psplash-bar-img.png ./psplash-bar.png
    ./make-image-header.sh ./psplash-bar.png BAR
}

FILES_${PN} += "/lib/systemd/system/"
