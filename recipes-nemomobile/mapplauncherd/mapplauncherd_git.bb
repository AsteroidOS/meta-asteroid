SUMMARY = "Daemon that helps to launch applications faster by preloading dynamically linked libraries and caching stuff"
HOMEPAGE = "https://github.com/sailfishos/mapplauncherd"
LICENSE = "LGPL-2.1-or-later"
LIC_FILES_CHKSUM = "file://COPYING.LESSER;md5=243b725d71bb5df4a1e5920b344b86ad"

SRC_URI = "git://github.com/sailfishos/mapplauncherd.git;protocol=https;branch=master \
           file://0001-booster-generic-Fix-path-to-tibapplauncherd.patch \
           file://0002-Fix-reference-to-host-lib.patch \
           file://0003-Fix-dynamic-opening-issues.patch \
           file://booster-generic.service \
           file://0004-invoker-Do-not-return-a-value-for-a-void-function.patch \
           "
SRCREV = "7091378e7d1de0c26cdfcf74951ee1688f029b9d"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"

DEPENDS += "dbus systemd glib-2.0"

inherit cmake pkgconfig
B = "${S}"

do_configure:prepend() {
    sed -i '/Target for documentation/,$d' ${S}/CMakeLists.txt
    sed -i 's@-L/lib -lsystemd-daemon@-lsystemd@' ${S}/src/launcherlib/CMakeLists.txt
    cp ${UNPACKDIR}/booster-generic.service ${S}/src/booster-generic/booster-generic.service
}

do_install:append() {
    install -d ${D}/usr/lib/systemd/user/default.target.wants/
    if [ ! -f ${D}/usr/lib/systemd/user/default.target.wants/booster-generic.service ]; then
        ln -s /usr/lib/systemd/user/booster-generic.service ${D}/usr/lib/systemd/user/default.target.wants/booster-generic.service
    fi
}

FILES:${PN} += "/usr/lib/systemd/user /usr/libexec/mapplauncherd/ /usr/lib/libapplauncherd.so /usr/lib/systemd/user/default.target.wants/"
FILES:${PN}-dbg += "/usr/libexec/mapplauncherd/.debug"
FILES:${PN}-dev = "/usr/include/"
