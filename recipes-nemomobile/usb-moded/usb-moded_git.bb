SUMMARY = "This is a daemon which can hanlde setting different usb profiles with gadget drivers"
HOMEPAGE = "https://github.com/philippedeswert/usb-moded"
LICENSE = "LGPL-2.1+"
LIC_FILES_CHKSUM = "file://LICENSE;md5=5f30f0716dfdd0d91eb439ebec522ec2"

SRC_URI = "git://github.com/philippedeswert/usb-moded.git;protocol=https \
           file://usb-moded.service \
           file://com.meego.usb_moded.service \
           file://udhcp-daemon.service \
           file://buteo-session.service \
           file://usb-moded \
           file://init_ffs"
SRCREV = "b2bcc5ba8d1bf3179c73a916f01ab4e0cf0a3526"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"

inherit autotools pkgconfig

B = "${WORKDIR}/git"
EXTRA_OECONF="--enable-systemd --enable-debug --enable-app-sync --enable-connman"
DEPENDS += "dbus dbus-glib glib-2.0 udev kmod systemd buteo-mtp"
RDEPENDS_${PN} += "buteo-mtp"

do_configure_prepend() {
    sed -i "s@systemd-daemon@systemd@" configure.ac
    sed -i "s@shell@ceres@g" systemd/adbd-functionfs.sh
    sed -i "s@ adbd.service@ android-tools-adbd.service@" ${S}/systemd/adbd-prepare.service
    sed -i "s@umount adb@umount /dev/usb-ffs/adb@" ${S}/systemd/adbd-prepare.service
}

do_install_append() {
    install -m 644 -D src/usb_moded-dbus.h ${D}/usr/include/usb-moded/usb_moded-dbus.h
    install -m 644 -D src/usb_moded-modes.h ${D}/usr/include/usb-moded/usb_moded-modes.h
    install -m 644 -D src/usb_moded-appsync-dbus.h ${D}/usr/include/usb-moded/usb_moded-appsync-dbus.h
    install -m 644 -D src/com.meego.usb_moded.xml ${D}/usr/include/usb-moded/com.meego.usb_moded.xml
    install -m 644 -D usb_moded.pc ${D}/usr/lib/pkgconfig/usb_moded.pc
    install -m 644 -D debian/manpage.1 ${D}/usr/share/man/man1/usb-moded.1
    install -m 644 -D debian/usb_moded.conf ${D}/etc/dbus-1/system.d/usb_moded.conf
    install -d ${D}/etc/modprobe.d
    echo "options g_file_storage stall=0 removable=1" > ${D}/etc/modprobe.d/usb_moded.conf
    install -d ${D}/etc/usb-moded
    install -d ${D}/etc/usb-moded/run
    install -d ${D}/etc/usb-moded/dyn-modes
    install -m 644 -D ../usb-moded/usb-moded.ini ${D}/etc/usb-moded/usb-moded.ini
    install -m 644 -D ../usb-moded/run/* ${D}/etc/usb-moded/run/
    install -m 644 -D ../usb-moded/dyn-modes/* ${D}/etc/usb-moded/dyn-modes/

    touch ${D}/etc/modprobe.d/g_ether.conf
    touch ${D}/etc/udhcpd.conf

    install -m 644 -D systemd/usb-moded.conf ${D}/etc/tmpfiles.d/usb-moded.conf

    install -m 755 -D systemd/adbd-functionfs.sh ${D}/usr/sbin/adbd-functionfs.sh
    install -m 644 -D systemd/adbd-prepare.service ${D}/lib/systemd/system/adbd-prepare.service

    install -d ${D}/usr/bin/
    cp ../init_ffs ${D}/usr/bin/init_ffs

    install -d ${D}/var/lib/misc/
    touch ${D}/var/lib/misc/udhcpd.leases
}

FILES_${PN} += " /lib/systemd/system /usr/share/dbus-1/services/ /var/lib/misc/udhcpd.leases"
