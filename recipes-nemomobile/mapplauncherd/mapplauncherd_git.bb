SUMMARY = "Daemon that helps to launch applications faster by preloading dynamically linked libraries and caching stuff"
HOMEPAGE = "https://git.merproject.org/mer-core/mapplauncherd"
LICENSE = "LGPL-2.1+"
LIC_FILES_CHKSUM = "file://COPYING.LESSER;md5=243b725d71bb5df4a1e5920b344b86ad"

SRC_URI = "git://git.merproject.org/mer-core/mapplauncherd.git;protocol=https \
           file://0001-booster-generic-Fix-path-to-tibapplauncherd.patch"
SRCREV = "64396438670aa7ecf3de968d24c139c84b757eb2"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"

DEPENDS += "dbus systemd"

inherit cmake
B = "${S}"

do_configure_prepend() {
    sed -i '/Target for documentation/,$d' ${S}/CMakeLists.txt
    sed -i 's@-L/lib -lsystemd-daemon@-lsystemd@' ${S}/src/launcherlib/CMakeLists.txt
}

do_install_append() {
    install -d ${D}/home/ceres/.config/systemd/user/default.target.wants/
    if [ ! -f ${D}/home/ceres/.config/systemd/user/default.target.wants/booster-generic.service ]; then
        ln -s /usr/lib/systemd/user/booster-generic.service ${D}/home/ceres/.config/systemd/user/default.target.wants/booster-generic.service
    fi
}

FILES_${PN} += "/usr/lib/systemd/user /usr/libexec/mapplauncherd/ /usr/lib/libapplauncherd.so /home/ceres/.config/systemd/user/default.target.wants/"
FILES_${PN}-dbg += "/usr/libexec/mapplauncherd/.debug"
FILES_${PN}-dev = "/usr/include/"
