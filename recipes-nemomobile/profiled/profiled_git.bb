SUMMARY = "Daemon for device profile handling."
HOMEPAGE = "https://github.com/sailfishos/profiled"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=93bc4a25d753385a799547a0560d7001"

SRC_URI = "gitsm://github.com/sailfishos/profiled.git;protocol=https;branch=master"
SRCREV = "34e886a41715ce2409c0750e71887d010280fa8f"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"

DEPENDS += "glib-2.0 dbus dbus-glib doxygen-native pkgconfig-native"
B = "${WORKDIR}/git"

do_install() {
    ROOT=${D} make install
}

FILES:${PN} += "/usr/share/dbus-1/services/com.nokia.profiled.service /usr/lib/systemd/user/profiled.service"
