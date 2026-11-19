DESCRIPTION = "Offline the secondary CPU cores and enable low-power tunables to save energy. \
Generic across all AsteroidOS watches: every sysfs path is probed before use, so the same \
script adapts to whatever a given kernel exposes."
PR = "r0"
SRC_URI = "file://underclock.service \
           file://underclock \
           file://COPYING"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=84dcc94da3adb52b53ae4fa38fe49e5d"
S = "${WORKDIR}/sources"
UNPACKDIR = "${S}"

inherit allarch

do_install() {
    install -m 0755 -d ${D}${bindir}
    install -m 0755 underclock ${D}${bindir}

    install -d ${D}/etc/systemd/system/default.target.wants/
    cp underclock.service ${D}/etc/systemd/system/
    ln -s ../underclock.service ${D}/etc/systemd/system/default.target.wants/underclock.service
}
