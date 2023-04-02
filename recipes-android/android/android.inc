SUMMARY = "Installs precompiled patched Android libraries for use with libhybris"

inherit gettext

PACKAGE_ARCH = "${MACHINE_ARCH}"
INHIBIT_PACKAGE_STRIP = "1"
INSANE_SKIP:${PN} = "already-stripped"
S = "${WORKDIR}"
B = "${S}"

PROVIDES += "virtual/android-system-image"
PROVIDES += "virtual/android-headers"

do_install() {
    install -d ${D}/usr/
    cp -r usr/* ${D}/usr/

    install -d ${D}${includedir}/android
    cp -r include/* ${D}${includedir}/android/

    install -d ${D}${libdir}/pkgconfig
    install -m 0644 ${D}${includedir}/android/android-headers.pc ${D}${libdir}/pkgconfig
    rm ${D}${includedir}/android/android-headers.pc
}

# Precompiled libraries, INSANE_SKIP all.
do_package_qa() {
}

# Allow empty main package since the -dev package depends on it
ALLOW_EMPTY:${PN} = "1"

PACKAGES =+ "android-system android-headers"
FILES:android-system = "/usr"
FILES:android-headers = "${libdir}/pkgconfig ${includedir}/android"
EXCLUDE_FROM_SHLIBS = "1"
