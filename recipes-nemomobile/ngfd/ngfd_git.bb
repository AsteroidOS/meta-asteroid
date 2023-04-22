SUMMARY = "Nemomobile's non graphical feedback daemon"
HOMEPAGE = "https://github.com/sailfishos/ngfd"
LICENSE = "LGPL-2.1-or-later"
LIC_FILES_CHKSUM = "file://COPYING;md5=4fbd65380cdd255951079008b364516c"

SRC_URI = "gitsm://github.com/sailfishos/ngfd.git;protocol=https;branch=master \
           file://ngfd.ini \
           file://ngfd.service \
           file://events.d/ \
           file://50-ffmemless.ini \
           file://0001-ngf-Use-relative-path.patch \
           file://0002-ffmemless-Reserve-enough-space-for-sprintf.patch \
           "
SRCREV = "57ad06b6df7052a668bdba876ea3dedb8f27d4ef"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"

inherit autotools pkgconfig

B = "${S}"

DEPENDS += "pulseaudio libsndfile1 json-c zlib dbus glib-2.0 libffi libcap gstreamer1.0 dbus-glib profiled mce"

do_configure:prepend() {
    sed -i "s@src data doc tests@src data@" ${S}/Makefile.am
}

do_install:append() {
    cp ../ngfd.ini ${D}/usr/share/ngfd/ngfd.ini

    install -d ${D}/usr/lib/systemd/user/
    install -d ${D}/usr/lib/systemd/user/default.target.wants/
    cp ../ngfd.service ${D}/usr/lib/systemd/user/
    if [ ! -f ${D}/usr/lib/systemd/user/default.target.wants/ngfd.service ]; then
        ln -s /usr/lib/systemd/user/ngfd.service ${D}/usr/lib/systemd/user/default.target.wants/ngfd.service
    fi

    rm -r ${D}/usr/share/ngfd/events.d/
    cp -r ../events.d/ ${D}/usr/share/ngfd/events.d/

    cp ../50-ffmemless.ini ${D}/usr/share/ngfd/plugins.d/

    install -d ${D}/usr/share/sounds/
}

FILES:${PN}-dbg += "/usr/lib/ngf/.debug/"
FILES:${PN} += "/usr/lib/ngf /usr/share/dbus-1 /usr/lib/systemd/ /usr/share/sounds/ /usr/lib/systemd/user/default.target.wants/"
