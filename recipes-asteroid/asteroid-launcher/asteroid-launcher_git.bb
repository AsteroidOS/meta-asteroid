SUMMARY = "Asteroid's launcher based on lipstick"
HOMEPAGE = "https://github.com/AsteroidOS/asteroid-launcher"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://src/qml/MainScreen.qml;beginline=1;endline=29;md5=3d250dd089f5d6221d9054029963e332"

SRC_URI = "git://github.com/AsteroidOS/asteroid-launcher.git;protocol=https;branch=master \
    file://asteroid-launcher.service \
    file://asteroid-launcher-precondition"
SRC_URI:append:hybris-machine = " file://asteroid-launcher-precondition-hybris "
SRCREV = "${AUTOREV}"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"
inherit cmake_qt5 pkgconfig

DEPENDS += "qml-asteroid lipstick qttools-native timed"
RDEPENDS:${PN} += "qtdeclarative-qmlplugins qml-asteroid mce-qt5 qtwayland-plugins nemo-qml-plugin-time nemo-qml-plugin-configuration asteroid-wallpapers asteroid-launcher-configs"
FILES:${PN} += "/usr/share/asteroid-launcher/ /usr/lib/systemd/user/ /usr/share/translations/ /usr/lib/systemd/user/default.target.wants/ /usr/bin/"

do_install:append() {
    lrelease -idbased ${S}/i18n/asteroid-launcher.*.ts
    install -d ${D}/usr/share/translations/
    cp ${S}/i18n/asteroid-launcher.*.qm ${D}/usr/share/translations/

    install -d ${D}/usr/lib/systemd/user/
    install -d ${D}/usr/lib/systemd/user/default.target.wants/
    install -d ${D}/usr/bin/
    install -m 0755 ${WORKDIR}/asteroid-launcher-precondition ${D}/usr/bin
    cp ../asteroid-launcher.service ${D}/usr/lib/systemd/user/
    if [ ! -f ${D}/usr/lib/systemd/user/default.target.wants/asteroid-launcher.service ]; then
        ln -s /usr/lib/systemd/user/asteroid-launcher.service ${D}/usr/lib/systemd/user/default.target.wants/asteroid-launcher.service
    fi
}

do_install:apppend:hybris-machine() {
    # On hybris machines, the launcher must run only after Android has started
    install -m 0755 ${WORKDIR}/asteroid-launcher-precondition-hybris ${D}/usr/bin/asteroid-launcher-precondition
}
