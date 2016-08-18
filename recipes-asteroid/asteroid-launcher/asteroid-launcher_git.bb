SUMMARY = "Asteroid's launcher based on lipstick"
HOMEPAGE = "https://github.com/AsteroidOS/asteroid-launcher"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://qml/MainScreen.qml;beginline=1;endline=29;md5=3d250dd089f5d6221d9054029963e332"

SRC_URI = "git://github.com/AsteroidOS/asteroid-launcher.git;protocol=https \
    file://asteroid-launcher.service \
    file://default.conf"
SRCREV = "${AUTOREV}"
PR = "r1"
PV = "+git${SRCREV}"
S = "${WORKDIR}/git"
inherit qmake5

DEPENDS += "lipstick"
RDEPENDS_${PN} += "qtscenegraph-adaptation qtbase-fonts qtbase-fonts-ttf-dejavu qtbase-plugins qtdeclarative-qmlplugins qml-asteroid qtwayland-plugins qtgraphicaleffects-qmlplugins nemo-qml-plugin-time nemo-qml-plugin-contextkit nemo-qml-plugin-configuration libconnman-qt5 xkeyboard-config asteroid-wallpapers"
FILES_${PN} += "/usr/share/asteroid-launcher/ /usr/lib/systemd/user/ /usr/share/translations/watchfaces/"

do_install_append() {
    install -d ${D}/var/lib/environment/compositor/
    cp ../default.conf ${D}/var/lib/environment/compositor/

    install -d ${D}/usr/lib/systemd/user/default.target.wants/
    cp ../asteroid-launcher.service ${D}/usr/lib/systemd/user/
    ln -s ../asteroid-launcher.service ${D}/usr/lib/systemd/user/default.target.wants/asteroid-launcher.service

    lrelease ${S}/watchfaces/*.ts
    install -d ${D}/usr/share/translations/watchfaces/
    cp ${S}/watchfaces/*.ts ${D}/usr/share/translations/watchfaces/
}
