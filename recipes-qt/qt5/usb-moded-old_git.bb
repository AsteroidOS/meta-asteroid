SUMMARY = "This is a daemon which can hanlde setting different usb profiles with gadget drivers"
HOMEPAGE = "https://github.com/nemomobile/usb-moded"
LICENSE = "LGPL-2.1+"
LIC_FILES_CHKSUM = "file://LICENSE;md5=5f30f0716dfdd0d91eb439ebec522ec2"

SRC_URI = "git://github.com/nemomobile/usb-moded;protocol=https"
SRCREV = "${AUTOREV}"
PR = "r1"
PV = "+git${SRCREV}"
S = "${WORKDIR}/git"

inherit autotools pkgconfig

EXTRA_OECONF="--enable-systemd "

do_install_append() {
    install -m 644 -D src/usb_moded-dbus.h ${D}/usr/lib//usb_moded-dbus.h
    install -m 644 -D src/usb_moded-modes.h %{buildroot}/%{_includedir}/%{name}/usb_moded-modes.h
    install -m 644 -D src/usb_moded-appsync-dbus.h %{buildroot}/%{_includedir}/%{name}/usb_moded-appsync-dbus.h
    install -m 644 -D src/com.meego.usb_moded.xml %{buildroot}/%{_includedir}/%{name}/com.meego.usb_moded.xml
    install -m 644 -D usb_moded.pc %{buildroot}/%{_libdir}/pkgconfig/usb_moded.pc
    install -d %{buildroot}/%{_docdir}/%{name}/html/
    install -m 644 docs/html/* %{buildroot}/%{_docdir}/%{name}/html/
    install -m 644 docs/usb_moded-doc.txt %{buildroot}/%{_docdir}/%{name}/
    install -m 644 -D debian/manpage.1 %{buildroot}/%{_mandir}/man1/usb-moded.1
    install -m 644 -D debian/usb_moded.conf %{buildroot}/%{_sysconfdir}/dbus-1/system.d/usb_moded.conf
    install -m 644 -D %{SOURCE1} %{buildroot}/%{_sysconfdir}/modprobe.d/usb_moded.conf
    install -d %{buildroot}/%{_sysconfdir}/usb-moded
    install -d %{buildroot}/%{_sysconfdir}/usb-moded/run
    install -d %{buildroot}/%{_sysconfdir}/usb-moded/run-diag
    install -d %{buildroot}/%{_sysconfdir}/usb-moded/dyn-modes
    install -d %{buildroot}/%{_sysconfdir}/usb-moded/diag
    install -m 644 -D config/dyn-modes/* %{buildroot}/%{_sysconfdir}/usb-moded/dyn-modes/
    install -m 644 -D config/diag/* %{buildroot}/%{_sysconfdir}/usb-moded/diag/
    install -m 644 -D config/run/* %{buildroot}/%{_sysconfdir}/usb-moded/run/
    install -m 644 -D config/run-diag/* %{buildroot}/%{_sysconfdir}/usb-moded/run-diag/
    install -m 644 -D config/mass-storage-jolla.ini %{buildroot}/%{_sysconfdir}/usb-moded/

    touch %{buildroot}/%{_sysconfdir}/modprobe.d/g_ether.conf
    touch %{buildroot}/%{_sysconfdir}/udhcpd.conf
    #systemd stuff
    install -d $RPM_BUILD_ROOT/lib/systemd/system/basic.target.wants/
    install -m 644 -D systemd/%{name}.service %{buildroot}/lib/systemd/system/%{name}.service
    ln -s ../%{name}.service $RPM_BUILD_ROOT/lib/systemd/system/basic.target.wants/%{name}.service
    install -m 644 -D systemd/usb-moded-args.conf %{buildroot}/var/lib/environment/usb-moded/usb-moded-args.conf
    install -m 755 -D systemd/turn-usb-rescue-mode-off %{buildroot}/%{_bindir}/turn-usb-rescue-mode-off
    install -m 644 -D systemd/usb-rescue-mode-off.service %{buildroot}/lib/systemd/system/usb-rescue-mode-off.service
    install -m 644 -D systemd/usb-rescue-mode-off.service %{buildroot}/lib/systemd/system/graphical.target.wants/usb-rescue-mode-off.service
    install -m 644 -D systemd/usb-moded.conf %{buildroot}/%{_sysconfdir}/tmpfiles.d/usb-moded.conf
}
