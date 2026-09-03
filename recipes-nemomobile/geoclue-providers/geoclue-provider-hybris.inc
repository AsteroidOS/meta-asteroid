SUMMARY = "Libhybris backend for GeoClue"
HOMEPAGE = "https://github.com/mer-hybris/geoclue-providers-hybris"
LICENSE = "LGPL-2.1-or-later"
LIC_FILES_CHKSUM = "file://COPYING;md5=4fbd65380cdd255951079008b364516c"

SRC_URI = "git://github.com/mer-hybris/geoclue-providers-hybris.git;protocol=https;branch=master \
    file://0001-pri-Fix-host-contamination-path-issue.patch \
    file://0002-Drop-nemo-qml-plugin-systemsettings-dependency.patch \
    file://0003-pri-Use-Qt6-pkg-config-module-names.patch \
    file://0004-dbus-Annotate-signal-args-with-QtTypeName-Out-for-Qt6.patch \
    file://0005-backends-Qualify-stream-manipulators-with-Qt-for-Qt6.patch \
    "
SRCREV = "0.2.40"
PR = "r1"
PV = "+git${SRCPV}"

DEPENDS += "geoclue libhybris libconnman-qt libqofono qofonoext"
inherit qt6-qmake pkgconfig

# Ensures that the root sources can be found.
B = "${S}"

# NOTE: this used to be setuid-root (04755). On at least one port (hoki,
# see AsteroidOS/meta-smartwatch#252) that causes glibc/D-Bus to strip
# DBUS_SESSION_BUS_ADDRESS from the environment for setuid processes (a
# real, documented security hardening behavior - real-uid != effective-uid
# triggers it), which makes QDBusConnection::sessionBus() fail to connect
# and registerObject() fail with a qFatal crash on startup. The GNSS
# binder HAL access this binary needs does not require root - confirmed
# working as a normal, unprivileged user. Dropping the setuid bit.
do_install:append() {
    chmod 0755 ${D}/usr/libexec/geoclue-hybris
}

FILES:${PN} += "/usr/share/dbus-1 /usr/share/geoclue-providers /usr/lib/systemd/user"
