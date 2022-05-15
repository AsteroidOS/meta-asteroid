SUMMARY = "Nemomobile's sensorfw hybris HAL only plugins"
HOMEPAGE = "https://github.com/sailfishos/sensorfw"
PACKAGE_ARCH = "${MACHINE_ARCH}"

require sensorfw.inc

EXTRA_QMAKEVARS_PRE = "CONFIG+=hybris"

do_install:append() {
    # Remove sensorfw core elements.
    find ${D} ! -name "usr" -type d -mindepth 1 -maxdepth 1 -exec rm -rf '{}' +
    find ${D}/usr ! -name "lib" -type d -mindepth 1 -maxdepth 1 -exec rm -rf '{}' +
    find ${D}/usr/lib ! -name "sensord-qt5" ! -name "libhybris*" -mindepth 1 -maxdepth 1 -exec rm -rf '{}' +
    find ${D}/usr/lib/sensord-qt5 ! -name "libhybris*" -mindepth 1 -maxdepth 1 -exec rm -rf '{}' +
}

DEPENDS += "sensorfw libhybris"

FILES:${PN} += "/usr/lib/sensord-qt5/"
