SUMMARY = "Asteroid's BLE synchronization daemon."
HOMEPAGE = "https://github.com/AsteroidOS/asteroid-btsyncd"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=84dcc94da3adb52b53ae4fa38fe49e5d"

SRC_URI = "git://github.com/AsteroidOS/asteroid-btsyncd.git;protocol=https \
    file://asteroid-btsyncd.service"
SRCREV = "${AUTOREV}"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"
inherit qmake5 gsettings

DEPENDS += "qtbase glibmm qtmpris statefs-qt timed"
RDEPENDS_${PN} += "glibmm qtmpris"

FILES_${PN} += "/usr/bin/ /usr/lib/systemd/user/ /usr/share/glib-2.0/schemas /usr/share/translations/"

do_install_append() {
    install -d ${D}/usr/lib/systemd/user/default.target.wants/
    cp ../asteroid-btsyncd.service ${D}/usr/lib/systemd/user/
    ln -s ../asteroid-btsyncd.service ${D}/usr/lib/systemd/user/default.target.wants/asteroid-btsyncd.service

    install -d ${D}/usr/share/translations/
    cp ${S}/i18n/asteroid-btsyncd.*.qm ${D}/usr/share/translations/
}

