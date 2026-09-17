FILESEXTRAPATHS:prepend := "${THISDIR}/qtmultimedia:"
SRC_URI:append = " \
        file://0001-pulseaudio-Do-not-cap-the-server-side-buffer-at-1024-.patch \
"

PACKAGECONFIG:append = " gstreamer "
PACKAGECONFIG:remove = " spatialaudio_quick3d "
EXTRA_QMAKEVARS_PRE:remove = "CONFIG+=done_config_gstreamer"
RDEPENDS:${PN} += "gstreamer1.0 gstreamer1.0-plugins-base gstreamer1.0-plugins-good gstreamer1.0-plugins-bad"
