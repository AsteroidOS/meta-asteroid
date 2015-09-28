SUMMARY = "Homescreen for the Glacier UX"
HOMEPAGE = "https://github.com/nemomobile-ux/glacier-home.git"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://src/qml/AppLauncher.qml;beginline=1;endline=23;md5=b5fbcff61900379fb98b9f80f09d97a8"

SRC_URI = "git://github.com/nemomobile-ux/glacier-home.git;protocol=https \
    file://lipstick.service \
    file://default.conf"
SRCREV = "${AUTOREV}"
PR = "r1"
PV = "+git${SRCREV}"
S = "${WORKDIR}/git"
inherit qmake5

DEPENDS += "lipstick"
RDEPENDS_${PN} += "qtdeclarative-qmlplugins qtquickcontrols-qmlplugins qtquickcontrols-nemo qtwayland-plugins qtgraphicaleffects-qmlplugins nemo-qml-plugin-time nemo-qml-plugin-contextkit nemo-qml-plugin-configuration nemo-theme-glacier libconnman-qt libqofono xkeyboard-config ttf-opensans"
FILES_${PN} += "/usr/share/lipstick-glacier-home-qt5"

do_install_append() {
    install -d ${D}/var/lib/environment/compositor/
    cp ../default.conf ${D}/var/lib/environment/compositor/

    # TODO: This should definitely be run as a simple user !!
    install -d ${D}/etc/systemd/system/multi-user.target.wants/
    cp ../lipstick.service ${D}/etc/systemd/system/
    ln -s ../lipstick.service ${D}/etc/systemd/system/multi-user.target.wants/lipstick.service
}
