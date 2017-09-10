SUMMARY = "A port of Android's mtp server implementation to Ubuntu."
LICENSE = "GPL-3.0 & Apache-2.0"
LIC_FILES_CHKSUM = " \
    file://COPYING;md5=d32239bcb673463ab874e80d47fae504 \
    file://MODULE_LICENSE_APACHE2;md5=d41d8cd98f00b204e9800998ecf8427e \
    file://NOTICE;md5=9645f39e9db895a4aa6e02cb57294595 \
"

SRC_URI = " \
    bzr://code.launchpad.net/~phablet-team/mtp/trunk \
    file://0001-Remove-dbus-dependency.patch \
    file://mtp-server.service \
"
S = "${WORKDIR}/trunk"
SRCREV = "ci-train-bot@canonical.com-20160413060212-0qjv16umd0rhltw5"

inherit cmake gettext

DEPENDS += "boost libhybris glog"

do_configure_prepend() {
    echo -e "\ntarget_link_libraries(mtpserver pthread)" >> "${S}/CMakeLists.txt"
}

do_install_append() {
    install -m 644 -D "../mtp-server.service" ${D}/lib/systemd/system/mtp-server.service
    install -d ${D}/lib/systemd/system/multi-user.target.wants/
    ln -s ../mtp-server.service ${D}/lib/systemd/system/multi-user.target.wants/mtp-server.service
}

FILES_${PN} += " /lib/systemd/system "
