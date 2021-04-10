SUMMARY = "NemoMobile's MTP Stack"
HOMEPAGE = "https://git.merproject.org/mer-core/buteo-mtp"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://mtpserver/mtpserver.cpp;beginline=1;endline=30;md5=a2b2b5351d5e7a0b1f3b62af44e24404"

SRC_URI = "git://git.merproject.org/mer-core/buteo-mtp.git;protocol=https \
           file://0001-Remove-dependency-to-SSU-and-tests.patch \
           file://0002-fsstorageplugin-Expose-Watch-Memory-instead-of-Phone.patch"
SRCREV = "001a5aed96f751c3841447aeb8d25671f772b780"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"
inherit qmake5

EXTRA_QMAKEVARS_PRE += "QMAKE_CFLAGS_ISYSTEM="

do_install_append() {
    mkdir -p ${D}/usr/lib/systemd/system/local-fs.target.wants
    ln -s ../dev-mtp.mount ${D}/usr/lib/systemd/system/local-fs.target.wants
}

DEPENDS += "buteo-syncfw libqtsparql nemo-qml-plugin-systemsettings"

FILES_${PN} += "/usr/lib/systemd/system /usr/lib/systemd/user/ /usr/share/mtp/ /usr/lib/mtp/ /usr/lib/buteo-plugins-qt5"
B="${S}"
