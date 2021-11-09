FILESEXTRAPATHS:prepend := "${THISDIR}/files:"
DEPENDS += "gdk-pixbuf-native"
SRC_URI += "file://psplash-colors.h \
            file://psplash-bar-img.png \
            file://psplash-config.h \
            file://psplash-img-280.png \
            file://psplash-img-320.png"
SRCREV = "44afb7506d43cca15582b4c5b90ba5580344d75d"
SPLASH_IMAGES = "file://psplash-img-320.png;outsuffix=default"

PACKAGE_ARCH = "${MACHINE_ARCH}"

PACKAGECONFIG:append = " disable-progress-bar"
PACKAGECONFIG[disable-progress-bar] = ",--disable-progress-bar,"

do_configure:append () {
    cd ${S}
    cp ../psplash-config.h ./psplash-config.h
    cp ../psplash-colors.h ./psplash-colors.h
    cp ../psplash-bar-img.png ./psplash-bar.png
    ./make-image-header.sh ./psplash-bar.png BAR
}

FILES:${PN} += "/lib/systemd/system/"
