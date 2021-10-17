SUMMARY = "Daemon that helps to launch applications faster by preloading dynamically linked libraries and caching stuff"
HOMEPAGE = "https://github.com/sailfishos/mapplauncherd"
LICENSE = "LGPL-2.1+"
LIC_FILES_CHKSUM = "file://COPYING.LESSER;md5=243b725d71bb5df4a1e5920b344b86ad"

SRC_URI = "git://github.com/sailfishos/mapplauncherd.git;protocol=https \
           file://0001-booster-generic-Fix-path-to-tibapplauncherd.patch \
           file://0002-Fix-reference-to-host-lib.patch \
           file://0003-Fix-dynamic-opening-issues.patch \
           file://booster-generic.service"
SRCREV = "7091378e7d1de0c26cdfcf74951ee1688f029b9d"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"

DEPENDS += "dbus systemd"

inherit cmake
B = "${S}"

do_configure_prepend() {
    sed -i '/Target for documentation/,$d' ${S}/CMakeLists.txt
    sed -i 's@-L/lib -lsystemd-daemon@-lsystemd@' ${S}/src/launcherlib/CMakeLists.txt
    cp ${WORKDIR}/booster-generic.service ${S}/src/booster-generic/booster-generic.service
}

do_install_append() {
    install -d ${D}/usr/lib/systemd/user/default.target.wants/
    if [ ! -f ${D}/usr/lib/systemd/user/default.target.wants/booster-generic.service ]; then
        ln -s /usr/lib/systemd/user/booster-generic.service ${D}/usr/lib/systemd/user/default.target.wants/booster-generic.service
    fi
}

FILES_${PN} += "/usr/lib/systemd/user /usr/libexec/mapplauncherd/ /usr/lib/libapplauncherd.so /usr/lib/systemd/user/default.target.wants/"
FILES_${PN}-dbg += "/usr/libexec/mapplauncherd/.debug"
FILES_${PN}-dev = "/usr/include/"
