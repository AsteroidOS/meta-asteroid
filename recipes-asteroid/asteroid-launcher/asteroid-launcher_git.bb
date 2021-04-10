SUMMARY = "Asteroid's launcher based on lipstick"
HOMEPAGE = "https://github.com/AsteroidOS/asteroid-launcher"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://qml/MainScreen.qml;beginline=1;endline=29;md5=3d250dd089f5d6221d9054029963e332"

SRC_URI = "git://github.com/AsteroidOS/asteroid-launcher.git;protocol=https \
    file://asteroid-launcher.service \
    file://default.conf"
SRC_URI_append_qemux86 = " file://qemu.conf file://kms-qemu.json"
SRCREV = "${AUTOREV}"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"
inherit qmake5

DEPENDS += "lipstick qttools-native timed"
RDEPENDS_${PN} += "qtdeclarative-qmlplugins qml-asteroid mce-qt5 qtwayland-plugins nemo-qml-plugin-time nemo-qml-plugin-configuration asteroid-wallpapers"
FILES_${PN} += "/usr/share/asteroid-launcher/ /usr/lib/systemd/user/ /usr/share/translations/ /usr/lib/systemd/user/default.target.wants/"

do_install_append() {
    lrelease -idbased ${S}/i18n/asteroid-launcher.*.ts
    install -d ${D}/usr/share/translations/
    cp ${S}/i18n/asteroid-launcher.*.qm ${D}/usr/share/translations/

    install -d ${D}/var/lib/environment/compositor/
    cp ../default.conf ${D}/var/lib/environment/compositor/
    if [ -f ../qemu.conf ] ; then
        cp ../qemu.conf ${D}/var/lib/environment/compositor/
        cp ../kms-qemu.json ${D}/var/lib/environment/compositor/
    fi

    install -d ${D}/usr/lib/systemd/user/
    install -d ${D}/usr/lib/systemd/user/default.target.wants/
    cp ../asteroid-launcher.service ${D}/usr/lib/systemd/user/
    if [ ! -f ${D}/usr/lib/systemd/user/default.target.wants/asteroid-launcher.service ]; then
        ln -s /usr/lib/systemd/user/asteroid-launcher.service ${D}/usr/lib/systemd/user/default.target.wants/asteroid-launcher.service
    fi
}
