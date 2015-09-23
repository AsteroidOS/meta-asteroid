SUMMARY = "Nemomobile's non graphical feedback daemon"
HOMEPAGE = "https://github.com/nemomobile/ngfd"
LICENSE = "LGPL-2.1+"
LIC_FILES_CHKSUM = "file://COPYING;md5=4fbd65380cdd255951079008b364516c"

SRC_URI = "git://github.com/nemomobile/ngfd.git;protocol=https"
SRCREV = "${AUTOREV}"
PR = "r1"
PV = "+git${SRCREV}"
S = "${WORKDIR}/git"
B = "${S}"

DEPENDS += "pulseaudio libsndfile1 json-c zlib dbus glib-2.0 libffi libcap gstreamer1.0 dbus-glib"

do_configure_prepend() {
    sed -i "s@src data doc tests@src data@" ${S}/Makefile.am
}

inherit autotools pkgconfig

FILES_${PN}-dbg += "/usr/lib/ngf/.debug/"
FILES_${PN} += "/usr/lib/ngf /usr/share/dbus-1"
