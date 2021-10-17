SUMMARY = "Nemomobile's statefs-qt"
HOMEPAGE = "https://github.com/sailfishos/statefs-qt"
LICENSE = "LGPL-2.1+"
LIC_FILES_CHKSUM = "file://src/qml/plugin.cpp;beginline=1;endline=6;md5=4f9a52d865013e8cb78d481eaa0e94d7"

SRC_URI = "git://github.com/sailfishos/statefs-qt.git;protocol=https \
    file://001-Disable_doc_installation.patch"
SRCREV = "6d91f87a8887b46c1e6883d72a32f49af6171919"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"

INSANE_SKIP_${PN} += "dev-deps"
DEPENDS += " qtbase qtdeclarative cor qtaround"
inherit cmake_qt5

B = "${WORKDIR}/git"
EXTRA_OECMAKE=" -DVERSION=0.2.51 -DOE_QMAKE_PATH_EXTERNAL_HOST_BINS=${STAGING_DIR_NATIVE}/usr/bin/"

do_configure_prepend() {
    sed -i "s@DESTINATION include/qt5@DESTINATION include@" CMakeLists.txt
}

FILES_${PN} = "/usr/bin/contextkit-monitor /usr/lib/ /usr/lib/libstatefs-qt5.so /usr/lib/libcontextkit-statefs-qt5.so"
FILES_${PN}-dev = "/usr/lib/pkgconfig /usr/include/ /usr/lib/qt5/qml/Mer/State/libstatefs-declarative.so"
FILES_${PN}-dbg = "/usr/lib/qt5/qml/Mer/State/.debug/ /usr/src /usr/bin/.debug/ /usr/lib/.debug/ /opt/tests/"
