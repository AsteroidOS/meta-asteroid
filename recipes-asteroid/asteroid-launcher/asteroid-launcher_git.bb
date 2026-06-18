SUMMARY = "Asteroid's launcher, Wayland compositor and notification daemon"
HOMEPAGE = "https://github.com/AsteroidOS/asteroid-launcher"
LICENSE = "BSD-3-Clause & LGPL-2.1-or-later"
LIC_FILES_CHKSUM = "file://src/qml/MainScreen.qml;beginline=1;endline=29;md5=dc9980ea8441655e2d7b323a30b7172d \
                    file://lipstick/LICENSE.LGPL;md5=fbc093901857fcd118f065f900982c24"

SRC_URI = "git://github.com/AsteroidOS/asteroid-launcher.git;protocol=https;branch=master \
    file://asteroid-launcher.service \
    file://asteroid-launcher-precondition \
    file://qt6-hidpi.conf \
    file://Notifications/"
SRC_URI:append:hybris-machine = " file://asteroid-launcher-precondition-hybris "
SRCREV = "${AUTOREV}"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"
inherit qt6-cmake pkgconfig asteroid-users

DEPENDS += " \
    qml-asteroid \
    qttools-native \
    qtdeclarative \
    qtsensors \
    qtwayland \
    wayland \
    wayland-native \
    timed \
    mlite \
    dbus \
    dbus-glib \
    libngf-qt \
    mce \
    mce-qt6 \
    usb-moded-qt6 \
    systemd \
    nemo-keepalive \
    dsme \
"
RDEPENDS:${PN}:append:hybris-machine = " qt6-qpa-hwcomposer-plugin "

RDEPENDS:${PN} += "qtdeclarative-qmlplugins qml-asteroid mce-qt6 qtwayland-plugins nemo-qml-plugin-time nemo-qml-plugin-configuration asteroid-wallpapers asteroid-launcher-configs"
FILES:${PN} += "/usr/share/asteroid-launcher/ /usr/share/lipstick/ /usr/lib/systemd/user/ /usr/share/translations/ /usr/lib/systemd/user/default.target.wants/ /usr/bin/ ${localstatedir}/lib/environment/compositor/ /home/ceres/.local/share/system/privileged/Notifications"

do_install:append() {
    install -d ${D}/usr/lib/systemd/user/
    install -d ${D}/usr/lib/systemd/user/default.target.wants/
    install -d ${D}/usr/bin/
    install -m 0755 ${UNPACKDIR}/asteroid-launcher-precondition ${D}/usr/bin
    install -D -m 644 ${UNPACKDIR}/asteroid-launcher.service ${D}/usr/lib/systemd/user/
    if [ ! -f ${D}/usr/lib/systemd/user/default.target.wants/asteroid-launcher.service ]; then
        ln -s /usr/lib/systemd/user/asteroid-launcher.service ${D}/usr/lib/systemd/user/default.target.wants/asteroid-launcher.service
    fi

    install -d ${D}${localstatedir}/lib/environment/compositor
    install -m 0644 ${UNPACKDIR}/qt6-hidpi.conf ${D}${localstatedir}/lib/environment/compositor/

    install -d ${D}/home/ceres/.local/share/system/privileged/Notifications/
    cp -r ${UNPACKDIR}/Notifications/* ${D}/home/ceres/.local/share/system/privileged/Notifications/
}

do_install:append:hybris-machine() {
    # On hybris machines, the launcher must run only after Android has started
    install -m 0755 ${UNPACKDIR}/asteroid-launcher-precondition-hybris ${D}/usr/bin/asteroid-launcher-precondition
}
