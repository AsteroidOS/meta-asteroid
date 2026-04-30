SUMMARY = "QML Plugin for system settings on Nemo"
HOMEPAGE = "https://github.com/sailfishos/nemo-qml-plugin-systemsettings"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://src/displaysettings.cpp;beginline=1;endline=31;md5=99ff23884718e3e2c85992a9294d18df"

# TODO: use sailfishos/nemo-qml-plugin-systemsettings when Qt6 support is merged in
SRC_URI = "git://github.com/PureTryOut/nemo-qml-plugin-systemsettings.git;protocol=https;branch=qt6 \
           file://location.conf \
           file://0001-Disable-SSU-dependency.patch \
           file://0002-Remove-UserModel.patch \
           file://0003-LanguageModel-Notify-asteroid-launcher-of-locale-cha.patch \
           file://0004-languagemodel-install-languages-in-usr-share-support.patch \
           file://0005-Revert-nemo-qml-plugin-systemsettings-Remove-storage.patch \
           "
SRCREV = "7e04f61c68329d60662429cd0f386fcda33f9ee1"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"
inherit qt6-qmake pkgconfig

do_configure:prepend() {
    sed -i "s@\$\$\[QT_INSTALL_BINS\]/@@" ${S}/src/src.pro
    sed -i "s@\$\$\[QT_INSTALL_BINS\]/@@" ${S}/translations/translations.pro
}

do_install:append() {
    install -d ${D}/var/lib/location/
    install -m 0644 ${UNPACKDIR}/location.conf ${D}/var/lib/location/location.conf
}

DEPENDS += "qtdeclarative profiled usb-moded-qt6 mlite mce timed shadow nemo-qml-plugin-dbus nemo-qml-plugin-models libsailfishkeyprovider libconnman-qt qttools-native libqofono qt5compat"
RDEPENDS:${PN} += "profiled"

FILES:${PN}-dbg += "/usr/lib/qml/org/nemomobile/systemsettings/.debug /opt/ /usr/share/nemo-qml-plugin-systemsettings-tests /usr/lib/nemo-qml-plugin-systemsettings-tests"
FILES:${PN} += "/usr/lib/qml/org/nemomobile/systemsettings/ /usr/lib/systemd /usr/share/translations/"
