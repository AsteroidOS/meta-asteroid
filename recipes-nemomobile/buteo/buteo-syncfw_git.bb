SUMMARY = "NemoMobile's Buteo Synchronization daemon"
HOMEPAGE = "https://github.com/sailfishos/buteo-syncfw"
LICENSE = "LGPL-2.1-or-later"
LIC_FILES_CHKSUM = "file://COPYING;md5=93ae0a8ec7ecf7709c725bd232bbafc6"

SRC_URI = "git://github.com/sailfishos/buteo-syncfw.git;protocol=https;branch=master"
SRCREV = "0529c7338212d41bf04c28b6c163479aa9ea1551"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"
inherit qmake5 gsettings pkgconfig

EXTRA_QMAKEVARS_PRE += "CONFIG+=usb-moded DEFINES+=USE_KEEPALIVE"

do_configure:prepend() {
    # Avoid doxygen dependency
    sed -i "/doc/d" ${S}/buteo-sync.pro
}

do_install:append() {
    install -d ${D}/usr/lib/systemd/user/default.target.wants/
    if [ ! -f ${D}/usr/lib/systemd/user/default.target.wants/msyncd.service ]; then
        ln -s /usr/lib/systemd/user/msyncd.service ${D}/usr/lib/systemd/user/default.target.wants/msyncd.service
    fi
}

DEPENDS = "libaccounts-qt5 libsignon-qt5 qtsystems nemo-keepalive"

FILES:${PN} += "/usr/lib/qml /usr/share/glib-2.0/schemas /usr/share/accounts/services/ /usr/lib/systemd /usr/lib/systemd/user/default.target.wants/"
FILES:${PN}-dev += "/usr/lib/libbuteosyncfw5.prl"
FILES:${PN}-dbg += "/opt/tests/"
