SUMMARY = "Daemon that helps to launch applications faster by preloading dynamically linked libraries and caching stuff"
HOMEPAGE = "https://git.merproject.org/mer-core/mapplauncherd"
LICENSE = "LGPL-2.1+"
LIC_FILES_CHKSUM = "file://COPYING.LESSER;md5=243b725d71bb5df4a1e5920b344b86ad"

SRC_URI = "git://git.merproject.org/mer-core/mapplauncherd.git;protocol=https"
SRCREV = "45ed31bffdb2b7fac3d0ee287d194ae468a4c1cb"
PR = "r1"
PV = "+git${SRCREV}"
S = "${WORKDIR}/git"

DEPENDS += "dbus systemd"

inherit cmake
B = "${S}"

do_configure_prepend() {
    sed -i '/Target for documentation/,$d' ${S}/CMakeLists.txt
    sed -i 's@lsystemd-daemon@lsystemd@' ${S}/src/launcherlib/CMakeLists.txt
}

FILES_${PN} += "/usr/lib/systemd /usr/libexec/mapplauncherd/"
FILES_${PN}-dbg += "/usr/libexec/mapplauncherd/.debug"
