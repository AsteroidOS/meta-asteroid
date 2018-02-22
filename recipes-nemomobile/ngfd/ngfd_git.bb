SUMMARY = "Nemomobile's non graphical feedback daemon"
HOMEPAGE = "https://git.merproject.org/mer-core/ngfd"
LICENSE = "LGPL-2.1+"
LIC_FILES_CHKSUM = "file://COPYING;md5=4fbd65380cdd255951079008b364516c"

SRC_URI = "git://git.merproject.org/mer-core/ngfd.git;protocol=https \
           file://ngfd.ini \
           file://ngfd.service \
           file://events.d/ \
           file://50-ffmemless.ini \
           file://0002-ffmemless-Reserve-enough-space-for-sprintf.patch"
SRCREV = "f400b0ade5ca13af7d7cca8d360117ca0b60f112"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"
B = "${S}"

DEPENDS += "pulseaudio libsndfile1 json-c zlib dbus glib-2.0 libffi libcap gstreamer1.0 dbus-glib profiled mce"

do_configure_prepend() {
    sed -i "s@src data doc tests@src data@" ${S}/Makefile.am
}

do_install_append() {
    cp ../ngfd.ini ${D}/usr/share/ngfd/ngfd.ini

    install -d ${D}/usr/lib/systemd/user/
    install -d ${D}/home/ceres/.config/systemd/user/default.target.wants/
    cp ../ngfd.service ${D}/usr/lib/systemd/user/
    if [ ! -f ${D}/home/ceres/.config/systemd/user/default.target.wants/ngfd.service ]; then
        ln -s /usr/lib/systemd/user/ngfd.service ${D}/home/ceres/.config/systemd/user/default.target.wants/ngfd.service
    fi

    rm -r ${D}/usr/share/ngfd/events.d/
    cp -r ../events.d/ ${D}/usr/share/ngfd/events.d/

    cp ../50-ffmemless.ini ${D}/usr/share/ngfd/plugins.d/

    install -d ${D}/usr/share/sounds/
}

inherit autotools pkgconfig

FILES_${PN}-dbg += "/usr/lib/ngf/.debug/"
FILES_${PN} += "/usr/lib/ngf /usr/share/dbus-1 /usr/lib/systemd/ /usr/share/sounds/ /home/ceres/.config/systemd/user/default.target.wants/"
