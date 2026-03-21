SUMMARY = "QtMultimedia QML VideoOutput backend for GStreamer NemoVideoTexture interface"
HOMEPAGE = "https://github.com/sailfishos/nemo-qtmultimedia-plugins"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://src/videotexturebackend/videotexturebackend.cpp;beginline=1;endline=31;md5=b0590bae22a7fd9db4143e98fc8b855b"

SRC_URI = "git://github.com/sailfishos/nemo-qtmultimedia-plugins.git;protocol=https;branch=master \
           file://0001-Use-QGstTools-as-a-private-Qt-module-instead-of-a-li.patch"
SRCREV = "658d8834a7ef0adb61fdc9a5ea09b9ad24b78888"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"
inherit qmake5 pkgconfig

DEPENDS += "qtmultimedia nemo-gst-interfaces"

FILES:${PN} += "/usr/lib/plugins/video/declarativevideobackend/libgstnemovideotexturebackend.so"
