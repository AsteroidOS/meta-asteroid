SUMMARY = "Libhybris backend for GeoClue"
HOMEPAGE = "https://github.com/mer-hybris/geoclue-providers-hybris"
LICENSE = "LGPL-2.1+"
LIC_FILES_CHKSUM = "file://COPYING;md5=4fbd65380cdd255951079008b364516c"

SRC_URI = "git://github.com/mer-hybris/geoclue-providers-hybris.git;protocol=https \
           file://0001-DeviceControl-Power-the-device-on-by-default-tempora.patch"
SRCREV = "29ec9933d09beefcc7ef24b83ef046f0150ec31e"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"

DEPENDS += "geoclue libhybris libconnman-qt5 libqofono qofonoext"
inherit qmake5

do_install:append() {
    chmod 04755 ${D}/usr/libexec/geoclue-hybris
}

FILES:${PN} += "/usr/share/dbus-1 /usr/share/geoclue-providers"
