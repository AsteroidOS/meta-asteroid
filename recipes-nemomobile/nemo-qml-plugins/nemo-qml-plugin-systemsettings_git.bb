SUMMARY = "QML Plugin for system settings on Nemo"
HOMEPAGE = "https://git.merproject.org/mer-core/nemo-qml-plugin-systemsettings"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://src/displaysettings.cpp;beginline=1;endline=31;md5=99ff23884718e3e2c85992a9294d18df"

SRC_URI = "git://git.merproject.org/mer-core/nemo-qml-plugin-systemsettings.git;protocol=https \
    file://0001-Update-QStorageInfo-API-usage.patch \
    file://0002-languagemodel-install-languages-in-usr-share-support.patch \
    file://0003-languagemodel-don-t-require-region-names.patch"
SRCREV = "8e98f8c8069592d3dd21011743fdfb4d2efcc50a"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"
inherit qmake5

DEPENDS += "qtdeclarative profiled usb-moded-qt5 mlite mce timed qtsystems"
RDEPENDS_${PN} += "profiled"

FILES_${PN}-dbg += "/usr/lib/qml/org/nemomobile/systemsettings/.debug /opt/ /usr/share/nemo-qml-plugin-systemsettings-tests /usr/lib/nemo-qml-plugin-systemsettings-tests"
FILES_${PN} += "/usr/lib/qml/org/nemomobile/systemsettings/"
