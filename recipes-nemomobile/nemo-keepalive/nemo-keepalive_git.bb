SUMMARY = "Keeps the system from automatically blanking the display"
HOMEPAGE = "https://github.com/sailfishos/nemo-keepalive"
LICENSE = "LGPL-2.1-only"
LIC_FILES_CHKSUM = "file://license.lgpl;md5=4fbd65380cdd255951079008b364516c"

SRC_URI = "gitsm://github.com/sailfishos/nemo-keepalive.git;protocol=https;branch=master \
           file://0001-Disable-tests.patch \
           file://0002-Disable-building-of-broken-examples.patch \
           "
SRCREV = "c38d05b5ebc871dc36561abaf9bbf1dfb8438e83"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"
inherit qmake5 pkgconfig

# Otherwise, qdbus2cpp workaround fails
B = "${S}"

do_compile:prepend() {
    # For some reason, qmake fails to invoke it properly.
    cd "${B}/lib"
    qdbusxml2cpp -p mceiface.h:mceiface.cpp mceiface.xml
    cd - 
}

DEPENDS += "libiphb qtbase mce glib-2.0 qtdeclarative"

FILES:${PN}-dbg += "/opt /usr/share/ /usr/lib/qml/org/nemomobile/keepalive/.debug/ /usr/bin/"
FILES:${PN} += "/usr/lib/"
