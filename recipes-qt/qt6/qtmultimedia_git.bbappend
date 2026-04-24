PACKAGECONFIG:append = " gstreamer "
EXTRA_QMAKEVARS_PRE:remove = "CONFIG+=done_config_gstreamer"
RDEPENDS:${PN} += "gstreamer1.0 gstreamer1.0-plugins-base gstreamer1.0-plugins-good gstreamer1.0-plugins-bad"

FILESEXTRAPATHS:prepend := "${THISDIR}/qtmultimedia:"
SRC_URI += " file://0001-Allow-custom-GStreamer-elements-to-be-used-as-a-vide.patch "
