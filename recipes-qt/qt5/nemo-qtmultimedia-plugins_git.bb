SUMMARY = "QtMultimedia QML VideoOutput backend for GStreamer NemoVideoTexture interface"
HOMEPAGE = "https://github.com/sailfishos/nemo-qtmultimedia-plugins"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://src/videotexturebackend/videotexturebackend.cpp;beginline=1;endline=31;md5=345009371abdfb1df57032e6f41dbd26"

SRC_URI = "git://github.com/sailfishos/nemo-qtmultimedia-plugins.git;protocol=https;branch=master \
           file://0001-Use-QGstTools-as-a-private-Qt-module-instead-of-a-li.patch"
SRCREV = "3f8f24be26a65fdc002c66d93ea115ba53afbc20"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"
inherit qmake5 pkgconfig

DEPENDS += "qtmultimedia nemo-gst-interfaces"

FILES:${PN} += "/usr/lib/plugins/video/declarativevideobackend/libgstnemovideotexturebackend.so"
