SUMMARY = "Nemomobile's statefs-qt"
HOMEPAGE = "https://git.merproject.org/mer-core/statefs-qt"
LICENSE = "LGPL-2.1+"
LIC_FILES_CHKSUM = "file://src/qml/plugin.cpp;beginline=1;endline=6;md5=4f9a52d865013e8cb78d481eaa0e94d7"

SRC_URI = "git://git.merproject.org/mer-core/statefs-qt.git;protocol=https \
    file://001-Disable_doc_installation.patch"
SRCREV = "32db98f6eed332df9672e5d8b091d95254b5e1df"
PR = "r1"
PV = "+git${SRCREV}"
S = "${WORKDIR}/git"

INSANE_SKIP_${PN} += "dev-deps"
DEPENDS += " qtbase qtdeclarative cor qtaround"
inherit cmake_qt5

B = "${WORKDIR}/git"
EXTRA_OECMAKE=" -DVERSION=0.2.51 -DOE_QMAKE_PATH_EXTERNAL_HOST_BINS=${STAGING_DIR_NATIVE}/usr/bin/"

do_configure_prepend() {
    sed -i "s@DESTINATION include/qt5@DESTINATION include@" CMakeLists.txt
}

# Workaround for "ERROR: QA Issue: non -dev/-dbg/-nativesdk package contains symlink .so: statefs-qt path '/work/armv7a-vfp-neon-oe-linux-gnueabi/statefs-qt/+gitAUTOINC-r1/packages-split/statefs-qt/usr/lib/qt5/qml/Mer/State/libstatefs-declarative.so' [dev-so]"
do_install_append() {
    rm ${D}/usr/lib/qt5/qml/Mer/State/libstatefs-declarative.so
}

FILES_${PN} = "/usr/bin/contextkit-monitor /usr/lib/qt5/ /usr/lib/libstatefs-qt5.so /usr/lib/libcontextkit-statefs-qt5.so"
FILES_${PN}-dev = "/usr/lib/pkgconfig /usr/include/"
FILES_${PN}-dbg = "/usr/lib/qt5/qml/Mer/State/.debug/ /usr/src /usr/bin/.debug/ /usr/lib/.debug/"
