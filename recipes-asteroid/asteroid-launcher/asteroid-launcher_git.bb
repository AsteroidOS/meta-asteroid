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
RDEPENDS_${PN} += "qtdeclarative-qmlplugins qtquickcontrols-qmlplugins qtquickcontrols-nemo qtwayland-plugins qtgraphicaleffects-qmlplugins nemo-qml-plugin-time nemo-qml-plugin-contextkit nemo-qml-plugin-configuration nemo-theme-glacier libconnman-qt libqofono xkeyboard-config ttf-opensans"
FILES_${PN} += "/usr/share/asteroid-launcher/ /lib/systemd/system"

do_install_append() {
    install -d ${D}/var/lib/environment/compositor/
    cp ../default.conf ${D}/var/lib/environment/compositor/

    # TODO: This should definitely be run as a simple user !!
    install -d ${D}/lib/systemd/system/multi-user.target.wants/
    cp ../asteroid-launcher.service ${D}/lib/systemd/system/
    ln -s ../asteroid-launcher.service ${D}/lib/systemd/system/multi-user.target.wants/asteroid-launcher.service
}
