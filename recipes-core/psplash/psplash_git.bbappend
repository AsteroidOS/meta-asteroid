FILESEXTRAPATHS:prepend := "${THISDIR}/files:"
DEPENDS += "gdk-pixbuf-native"
SRC_URI += "file://psplash-colors.h \
            file://psplash-bar-img.png \
            file://psplash-config.h \
            file://0001-Add-alive-animated-GIF-support.patch \
            file://0002-psplash-Allow-for-moving-the-named-pipe.patch \
            file://psplash-img-280-154.gif \
            file://psplash-img-320-176.gif \
            file://psplash-img-400-220.gif \
            file://psplash-img-280.png \
            file://psplash-img-320.png"
SRCREV = "44afb7506d43cca15582b4c5b90ba5580344d75d"
SPLASH_IMAGES = "file://psplash-img-320.png;outsuffix=default"

PACKAGE_ARCH = "${MACHINE_ARCH}"

PACKAGECONFIG:remove = " systemd"

PACKAGECONFIG:append = " animated-gif"
PACKAGECONFIG:append = " disable-progress-bar"
PACKAGECONFIG[animated-gif] = "--enable-animated-gif,,"
PACKAGECONFIG[disable-progress-bar] = ",--disable-progress-bar,"

do_configure:append () {
    cd ${S}
    cp ../psplash-config.h ./psplash-config.h
    cp ../psplash-colors.h ./psplash-colors.h
    cp ../psplash-bar-img.png ./psplash-bar.png
    ./make-image-header.sh ./psplash-bar.png BAR
}

do_install:append() {
    # By default provide the animated boot logo for a 280x280 screen.
    if ${@bb.utils.contains('PACKAGECONFIG', 'animated-gif', 'true', 'false', d)}; then
        install -d ${D}/usr/share/
        install -m 0755 ${WORKDIR}/psplash-img-280-154.gif ${D}/usr/share/psplash.gif
    fi
}

FILES:${PN} += "${systemd_system_unitdir}"
FILES:${PN} += "${@bb.utils.contains('PACKAGECONFIG', 'animated-gif', '/usr/share/psplash.gif', '', d)}"
