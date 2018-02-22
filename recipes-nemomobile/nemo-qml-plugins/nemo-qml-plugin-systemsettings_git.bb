SUMMARY = "QML Plugin for system settings on Nemo"
HOMEPAGE = "https://git.merproject.org/mer-core/nemo-qml-plugin-systemsettings"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://src/displaysettings.cpp;beginline=1;endline=31;md5=99ff23884718e3e2c85992a9294d18df"

SRC_URI = "git://git.merproject.org/mer-core/nemo-qml-plugin-systemsettings.git;protocol=https \
    file://0001-Disable-SSU-dependency.patch \
    file://0002-languagemodel-install-languages-in-usr-share-support.patch \
    file://0004-LanguageModel-Notify-asteroid-launcher-of-locale-cha.patch"
SRCREV = "0c3034612fabce0cca18366f6ac04020296428cf"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"
inherit qmake5

DEPENDS += "qtdeclarative profiled usb-moded-qt5 mlite mce timed qtsystems libshadowutils nemo-qml-plugin-models libsailfishkeyprovider libconnman-qt5"
RDEPENDS_${PN} += "profiled"

FILES_${PN}-dbg += "/usr/lib/qml/org/nemomobile/systemsettings/.debug /opt/ /usr/share/nemo-qml-plugin-systemsettings-tests /usr/lib/nemo-qml-plugin-systemsettings-tests"
FILES_${PN} += "/usr/lib/qml/org/nemomobile/systemsettings/ /usr/lib/systemd"
