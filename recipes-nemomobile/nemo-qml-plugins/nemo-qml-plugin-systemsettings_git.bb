SUMMARY = "QML Plugin for system settings on Nemo"
HOMEPAGE = "https://github.com/sailfishos/nemo-qml-plugin-systemsettings"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://src/displaysettings.cpp;beginline=1;endline=31;md5=99ff23884718e3e2c85992a9294d18df"

SRC_URI = "git://github.com/sailfishos/nemo-qml-plugin-systemsettings.git;protocol=https;branch=master \
    file://location.conf \
    file://0001-Disable-SSU-dependency.patch \
    file://0002-languagemodel-install-languages-in-usr-share-support.patch \
    file://0004-LanguageModel-Notify-asteroid-launcher-of-locale-cha.patch \
    file://0005-Remove-certificatemodel-and-developermodesettings.patch"
SRCREV = "8ee508e5370487afef1826e2ebaff0e44e604300"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"
inherit qmake5

do_install:append() {
    cp ${WORKDIR}/location.conf ${D}/etc/location/
}

DEPENDS += "qtdeclarative profiled usb-moded-qt5 mlite mce timed qtsystems libshadowutils nemo-qml-plugin-dbus nemo-qml-plugin-models libsailfishkeyprovider libconnman-qt5"
RDEPENDS:${PN} += "profiled"

FILES:${PN}-dbg += "/usr/lib/qml/org/nemomobile/systemsettings/.debug /opt/ /usr/share/nemo-qml-plugin-systemsettings-tests /usr/lib/nemo-qml-plugin-systemsettings-tests"
FILES:${PN} += "/usr/lib/qml/org/nemomobile/systemsettings/ /usr/lib/systemd"
