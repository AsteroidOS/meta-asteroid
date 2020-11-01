PACKAGECONFIG = "geoclue"
RDEPENDS_${PN} += "geoclue"

do_install_append() {
    rm ${D}/usr/lib/plugins/position/libqtposition_geoclue2.so
}