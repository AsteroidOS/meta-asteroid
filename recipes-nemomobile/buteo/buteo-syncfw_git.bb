SUMMARY = "NemoMobile's Buteo Synchronization daemon"
HOMEPAGE = "https://git.merproject.org/mer-core/buteo-syncfw"
LICENSE = "LGPL-2.1+"
LIC_FILES_CHKSUM = "file://COPYING;md5=93ae0a8ec7ecf7709c725bd232bbafc6"

SRC_URI = "git://git.merproject.org/mer-core/buteo-syncfw.git;protocol=https \
           file://msyncd.service"
SRCREV = "dc1483848049ad028cfdbdf563a9a6ce31032c59"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"
inherit qmake5 gsettings

EXTRA_QMAKEVARS_PRE += "CONFIG+=usb-moded DEFINES+=USE_KEEPALIVE"

do_configure_prepend() {
    sed -i "/doc/d" ${S}/buteo-sync.pro
}

do_install_append() {
    cp ${WORKDIR}/msyncd.service ${D}/usr/lib/systemd/user/msyncd.service

    install -d ${D}/home/ceres/.config/systemd/user/default.target.wants/
    if [ ! -f ${D}/home/ceres/.config/systemd/user/default.target.wants/msyncd.service ]; then
        ln -s /usr/lib/systemd/user/msyncd.service ${D}/home/ceres/.config/systemd/user/default.target.wants/msyncd.service
    fi
}

DEPENDS = "libaccounts-qt5 libsignon-qt5 qtsystems nemo-keepalive"

FILES_${PN} += "/usr/share/glib-2.0/schemas /usr/share/accounts/services/ /usr/lib/systemd /home/ceres/.config/systemd/user/default.target.wants/"
FILES_${PN}-dev += "/usr/lib/libbuteosyncfw5.prl"
FILES_${PN}-dbg += "/opt/tests/"
