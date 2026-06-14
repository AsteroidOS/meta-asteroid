SUMMARY = "Audiosystem Passthrough"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e9f185e65d260379da52afe6fc486efc"

DEPENDS += "libgbinder systemd libglibutil glib-2.0"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit pkgconfig

PV = "1.2.1+git"
SRCREV = "3165200ce2e6aa84274c8bb2134c839a1544153d"

SRC_URI = " \
        git://github.com/mer-hybris/audiosystem-passthrough.git;branch=master;protocol=https \
"

S = "${WORKDIR}/git"

TARGET_CC_ARCH += "${LDFLAGS}"

EXTRA_OEMAKE = "KEEP_SYMBOLS=1 CROSS_COMPILE=${TARGET_PREFIX} CC='${CC}' "
PARALLEL_MAKE = ""

do_install() {
    oe_runmake install DESTDIR=${D}
}
