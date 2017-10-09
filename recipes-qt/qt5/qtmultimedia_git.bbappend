DEPENDS+="libresourceqt"
PACKAGECONFIG_append = " gstreamer "
EXTRA_QMAKEVARS_PRE_remove = "CONFIG+=done_config_gstreamer"
RDEPENDS_${PN} += "gstreamer1.0 gstreamer1.0-plugins-base gstreamer1.0-plugins-good gstreamer1.0-plugins-bad"
