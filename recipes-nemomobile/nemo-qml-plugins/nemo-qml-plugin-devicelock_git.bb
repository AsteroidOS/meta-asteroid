SUMMARY = "QML Plugin for devicelock on Nemo"
HOMEPAGE = "https://git.merproject.org/mer-core/nemo-qml-plugin-devicelock.git"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://src/plugin/plugin.cpp;beginline=1;endline=31;md5=7abcb4ac64856fce624f8f11084f659f"

SRC_URI = "git://git.merproject.org/mer-core/nemo-qml-plugin-devicelock.git;protocol=https \
           file://0001-Use-libsystemd-instead-of-libsystemd-daemon.patch"
SRCREV = "5e65cdaf4f072a243d56b5ed4a54ff4ce789adb6"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"
inherit qmake5

B = "${S}"

do_compile_append() {
     sed -i "s@-L${S}/src/hostlib/../lib @@" ./src/hostlib/pkgconfig/nemodevicelock-host.pc
}

DEPENDS += "qtdeclarative nemo-keepalive nemo-qml-plugin-dbus mlite dbus"

FILES_${PN}-dbg += "/opt /usr/lib/qml/org/nemomobile/devicelock/.debug"
FILES_${PN} += "/usr/lib/qml/org/nemomobile/devicelock/ /lib/systemd/system/"
