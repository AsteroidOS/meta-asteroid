FILESEXTRAPATHS_prepend := "${THISDIR}/pulseaudio:"
SRC_URI += "file://1002-build-Install-pulsecore-headers.patch \
            file://default.pa"

do_install_append() {
    cp ${WORKDIR}/default.pa ${D}/etc/pulse/default.pa
}
