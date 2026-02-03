SUMMARY = "Libhybris backend for GeoClue"
HOMEPAGE = "https://github.com/mer-hybris/geoclue-providers-hybris"
LICENSE = "LGPL-2.1-or-later"
LIC_FILES_CHKSUM = "file://COPYING;md5=4fbd65380cdd255951079008b364516c"

SRC_URI = "git://github.com/mer-hybris/geoclue-providers-hybris.git;protocol=https;branch=master \
    file://0001-pri-Fix-host-contamination-path-issue.patch \
    "
SRCREV = "0.2.38"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"

DEPENDS += "geoclue libhybris libconnman-qt5 libqofono qofonoext nemo-qml-plugin-systemsettings"
inherit qmake5 pkgconfig

# Ensures that the root sources can be found.
B = "${S}"

do_install:append() {
    chmod 04755 ${D}/usr/libexec/geoclue-hybris
}

FILES:${PN} += "/usr/share/dbus-1 /usr/share/geoclue-providers /usr/lib/systemd/user"
