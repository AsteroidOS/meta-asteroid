SUMMARY = "Asteroid's BLE synchronization daemon."
HOMEPAGE = "https://github.com/AsteroidOS/asteroid-btsyncd"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=84dcc94da3adb52b53ae4fa38fe49e5d"

SRC_URI = "git://github.com/AsteroidOS/asteroid-btsyncd.git;protocol=https;branch=1.0 \
    file://asteroid-btsyncd.service"
SRCREV = "bbf6d906b0c682f01ba9a2b5d5f91f49e3fc16f5"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"
inherit qmake5 gsettings

DEPENDS += "qtbase glibmm qtmpris statefs-qt timed qttools-native"
RDEPENDS_${PN} += "glibmm qtmpris"

FILES_${PN} += "/usr/bin/ /usr/lib/systemd/user/ /usr/share/glib-2.0/schemas /usr/share/translations/ /home/ceres/.config/systemd/user/default.target.wants/"

do_install_append() {
    install -d ${D}/usr/lib/systemd/user/
    install -d ${D}/home/ceres/.config/systemd/user/default.target.wants/
    cp ../asteroid-btsyncd.service ${D}/usr/lib/systemd/user/
    if [ ! -f ${D}/home/ceres/.config/systemd/user/default.target.wants/asteroid-btsyncd.service ]; then
        ln -s /usr/lib/systemd/user/asteroid-btsyncd.service ${D}/home/ceres/.config/systemd/user/default.target.wants/asteroid-btsyncd.service
    fi

    lrelease -idbased ${S}/i18n/asteroid-btsyncd.*.ts
    install -d ${D}/usr/share/translations/
    cp ${S}/i18n/asteroid-btsyncd.*.qm ${D}/usr/share/translations/
}

