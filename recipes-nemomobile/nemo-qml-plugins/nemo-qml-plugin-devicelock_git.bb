SUMMARY = "QML Plugin for devicelock on Nemo"
HOMEPAGE = "https://github.com/sailfishos/nemo-qml-plugin-devicelock.git"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://src/plugin/plugin.cpp;beginline=1;endline=31;md5=7abcb4ac64856fce624f8f11084f659f"

SRC_URI = "git://github.com/sailfishos/nemo-qml-plugin-devicelock.git;protocol=https \
           file://0001-Use-libsystemd-instead-of-libsystemd-daemon.patch"
SRCREV = "acc349bee2deb3ea287df8deeeff2bff17203048"
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
