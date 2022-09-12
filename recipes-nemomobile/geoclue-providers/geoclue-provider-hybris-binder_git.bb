SUMMARY = "Binder libhybris backend for GeoClue"
HOMEPAGE = "https://github.com/mer-hybris/geoclue-providers-hybris"

QMAKE_PROFILES = "${S}/binder/binderlocationbackend.pro"

require geoclue-provider-hybris.inc

DEPENDS += "libgbinder glib-2.0 libglibutil"
