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
RDEPENDS_${PN} += "qtdeclarative-qmlplugins qml-asteroid qtwayland-plugins qtgraphicaleffects-qmlplugins nemo-qml-plugin-time nemo-qml-plugin-contextkit nemo-qml-plugin-configuration asteroid-wallpapers"
FILES_${PN} += "/usr/share/asteroid-launcher/ /usr/lib/systemd/user/"

do_install_append() {
    install -d ${D}/var/lib/environment/compositor/
    cp ../default.conf ${D}/var/lib/environment/compositor/

    install -d ${D}/usr/lib/systemd/user/default.target.wants/
    cp ../asteroid-launcher.service ${D}/usr/lib/systemd/user/
    if [ ! -f ${D}/usr/lib/systemd/user/default.target.wants/asteroid-launcher.service ]; then
        ln -s ../asteroid-launcher.service ${D}/usr/lib/systemd/user/default.target.wants/asteroid-launcher.service
    fi
}
