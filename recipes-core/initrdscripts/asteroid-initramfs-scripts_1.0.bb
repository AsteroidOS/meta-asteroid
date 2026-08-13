DESCRIPTION = "AsteroidOS initramfs init script. Mounts the sdcard/system/vendor/firmware \
partitions (per machine.conf) and switches root into the AsteroidOS rootfs"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

PACKAGE_ARCH = "${MACHINE_ARCH}"
PACKAGES = "${PN}"

SRC_URI = " \
  file://init.sh \
  file://machine.conf"

FILES:${PN} = "/init /machine.conf"

RDEPENDS:${PN} = "e2fsprogs-e2fsck e2fsprogs-resize2fs"
RDEPENDS:${PN} += "psplash android-tools-adbd"

S = "${WORKDIR}/sources"
UNPACKDIR = "${S}"

do_install() {
    install -m 0755 ${UNPACKDIR}/init.sh ${D}/init
    install -m 0644 ${UNPACKDIR}/machine.conf ${D}/machine.conf
}
