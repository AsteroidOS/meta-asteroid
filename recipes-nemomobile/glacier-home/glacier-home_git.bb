SUMMARY = "Homescreen for the Glacier UX"
HOMEPAGE = "https://github.com/nemomobile-ux/glacier-home.git"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://src/qml/MainScreen.qml;beginline=1;endline=30;md5=1a053e8b1bbb35a9b0146cf1a5775e3a"

SRC_URI = "git://github.com/nemomobile-ux/glacier-home.git;protocol=https \
    file://lipstick.service \
    file://default.conf"
SRCREV = "23a384ed117fc08ef5e1d5113812055a4fb3aeac"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"
inherit qmake5

DEPENDS += "lipstick"
RDEPENDS_${PN} += "qtdeclarative-qmlplugins qtquickcontrols-qmlplugins qtquickcontrols-nemo qtwayland-plugins qtgraphicaleffects-qmlplugins nemo-qml-plugin-time nemo-qml-plugin-contextkit nemo-qml-plugin-configuration nemo-theme-glacier libconnman-qt5 libqofono xkeyboard-config ttf-opensans"
FILES_${PN} += "/usr/share/lipstick-glacier-home-qt5 /lib/systemd/system"

do_install_append() {
    install -d ${D}/var/lib/environment/compositor/
    cp ../default.conf ${D}/var/lib/environment/compositor/

    install -d ${D}/usr/lib/systemd/user/default.target.wants/
    cp ../lipstick.service ${D}/usr/lib/systemd/user/
    ln -s ../lipstick.service ${D}/usr/lib/systemd/user/default.target.wants/lipstick.service
}
