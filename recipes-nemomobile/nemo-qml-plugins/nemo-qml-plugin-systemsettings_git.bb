SUMMARY = "QML Plugin for system settings on Nemo"
HOMEPAGE = "https://github.com/sailfishos/nemo-qml-plugin-systemsettings"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://src/displaysettings.cpp;beginline=1;endline=31;md5=99ff23884718e3e2c85992a9294d18df"

SRC_URI = "git://github.com/sailfishos/nemo-qml-plugin-systemsettings.git;protocol=https;branch=master \
    file://location.conf \
    file://0001-Disable-SSU-dependency.patch \
    file://0002-Remove-developermodesettings.patch \
    file://0003-Remove-UserModel.patch \
    file://0004-LanguageModel-Notify-asteroid-launcher-of-locale-cha.patch \
    file://0005-languagemodel-install-languages-in-usr-share-support.patch \
    file://0006-Revert-nemo-qml-plugin-systemsettings-Remove-storage.patch \
    "
SRCREV = "0.8.1"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"
inherit qmake5 pkgconfig

do_configure:prepend() {
    sed -i "s@\$\$\[QT_INSTALL_BINS\]@${OE_QMAKE_PATH_EXTERNAL_HOST_BINS}@" ${S}/src/src.pro
    sed -i "s@\$\$\[QT_INSTALL_BINS\]@${OE_QMAKE_PATH_EXTERNAL_HOST_BINS}@" ${S}/translations/translations.pro
}

do_install:append() {
    install -d ${D}/var/lib/location/
    install -m 0644 ${UNPACKDIR}/location.conf ${D}/var/lib/location/location.conf
}

DEPENDS += "qtdeclarative profiled usb-moded-qt5 mlite mce timed qtsystems shadow nemo-qml-plugin-dbus nemo-qml-plugin-models libsailfishkeyprovider libconnman-qt5 qttools-native libqofono"
RDEPENDS:${PN} += "profiled"

FILES:${PN}-dbg += "/usr/lib/qml/org/nemomobile/systemsettings/.debug /opt/ /usr/share/nemo-qml-plugin-systemsettings-tests /usr/lib/nemo-qml-plugin-systemsettings-tests"
FILES:${PN} += "/usr/lib/qml/org/nemomobile/systemsettings/ /usr/lib/systemd /usr/share/translations/"
