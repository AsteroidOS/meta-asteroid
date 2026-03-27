DESCRIPTION = "This QPA plugin allows rendering on top of libhybris-based hwcomposer EGL \
platforms. The hwcomposer API is specific to a given Droid release, and \
sometimes also SoC type (generic, qcom, exynos4, ...)."
LICENSE = "LGPL-2.1-only"
LIC_FILES_CHKSUM = "file://hwcomposer_backend.cpp;beginline=1;endline=40;md5=09c08382077db2dbc01b1b5536ec6665"

PV = "5.15.0+gitr${SRCPV}"

DEPENDS = "qtbase qtsensors libhybris mtdev glib-2.0 udev qtwayland virtual/android-headers "
RDEPENDS:${PN} += " qtscenegraph-adaptation "

# We need to be ${MACHINE_ARCH} as we need to compile the source against a specific
# Android version we select per machine
PACKAGE_ARCH = "${MACHINE_ARCH}"

SRC_URI = "git://github.com/mer-hybris/qt5-qpa-hwcomposer-plugin;protocol=https;branch=master \
        file://0001-Add-ambient-mode-display-support.patch;striplevel=2 "
S = "${UNPACKDIR}/${BB_GIT_DEFAULT_DESTSUFFIX}/hwcomposer"
SRCREV = "f1d9aef9693bb5ed5f586f3e7c07ac6ee756e21f"

inherit qmake5 pkgconfig

# WARNING: The recipe qt5-qpa-hwcomposer-plugin is trying to install files into a shared area when those files already exist. Those files and their manifest location are:
#   /OE/build/owpb/webos-ports/tmp-eglibc/sysroots/tenderloin/usr/lib/cmake/Qt5Gui/Qt5Gui_QEglFSIntegrationPlugin.cmake
#   Matched in manifest-tenderloin-qtbase.populate_sysroot
#   Please verify which package should provide the above files.
do_install:append() {
    rm -vf ${D}${libdir}/cmake/Qt5Gui/Qt5Gui_QEglFSIntegrationPlugin.cmake
}

FILES:${PN} += "${libdir}/plugins/platforms/libhwcomposer.so"
FILES:${PN}-dbg += "${libdir}/plugins/platforms/.debug/libhwcomposer.so"
FILES:${PN}-dev += "${libdir}/cmake"
