FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"
DEPENDS += "gdk-pixbuf-native"
SRC_URI += "file://psplash-colors.h \
            file://psplash-bar-img.png \
            file://psplash-config.h \
            file://psplash-img-280-154.gif \
            file://psplash-img-320-176.gif \
            file://psplash-img-400-220.gif \
            file://psplash-img-280.png \
            file://psplash-img-320.png \
            file://0001-Add-alive-animated-GIF-support.patch"

SRCREV = "53ae74a36bf17675228552abb927d2f981940a6a"
SPLASH_IMAGES = "file://psplash-img-320.png;outsuffix=default"

PACKAGE_ARCH = "${MACHINE_ARCH}"

PACKAGECONFIG:remove = " systemd"

PACKAGECONFIG:append = " animated-gif"
PACKAGECONFIG:append = " disable-progress-bar"
PACKAGECONFIG[animated-gif] = "--enable-animated-gif,,"
PACKAGECONFIG[disable-progress-bar] = ",--disable-progress-bar,"

do_configure:append () {
    cd ${S}
    install -m 0644 ${UNPACKDIR}/psplash-config.h ${S}/psplash-config.h
    install -m 0644 ${UNPACKDIR}/psplash-colors.h ${S}/psplash-colors.h
    install -m 0644 ${UNPACKDIR}/psplash-bar-img.png ${S}/psplash-bar.png
    ./make-image-header.sh ./psplash-bar.png BAR
}

do_install:append() {
    # By default provide the animated boot logo for a 280x280 screen.
    if ${@bb.utils.contains('PACKAGECONFIG', 'animated-gif', 'true', 'false', d)}; then
        install -d ${D}/usr/share/
        install -m 0755 ${UNPACKDIR}/psplash-img-280-154.gif ${D}/usr/share/psplash.gif
    fi
}

FILES:${PN} += "${systemd_system_unitdir}"
FILES:${PN} += "${@bb.utils.contains('PACKAGECONFIG', 'animated-gif', '/usr/share/psplash.gif', '', d)}"
