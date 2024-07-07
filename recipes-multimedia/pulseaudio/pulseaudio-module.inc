PULSEAUDIO_VERSION = "17.0"
EXTRA_OECONF += "--with-module-dir=/usr/lib/pulseaudio/modules"

do_configure:prepend() {
    echo "${PULSEAUDIO_VERSION}" > "${S}/.tarball-version"
}

FILES:${PN} += "/usr/lib/pulseaudio/modules"
FILES:${PN}-dbg += "/usr/lib/pulseaudio/modules/.debug/"
FILES:${PN}-staticdev += "/usr/lib/pulseaudio/modules/*.a"
