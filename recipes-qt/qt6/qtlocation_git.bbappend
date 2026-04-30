PACKAGECONFIG = "geoclue geoservices_itemsoverlay geoservices_osm geoservices_esri"
RDEPENDS:${PN} += "geoclue"

do_install:append() {
    rm ${D}/usr/lib/plugins/position/libqtposition_geoclue2.so
    rm ${D}/usr/lib/cmake/Qt5Positioning/Qt5Positioning_QGeoPositionInfoSourceFactoryGeoclue2.cmake
}
