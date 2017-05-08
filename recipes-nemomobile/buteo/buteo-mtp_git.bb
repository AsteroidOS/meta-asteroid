SUMMARY = "NemoMobile's MTP Stack"
HOMEPAGE = "https://git.merproject.org/mer-core/buteo-mtp"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://mtpserver/mtpserver.cpp;beginline=1;endline=30;md5=a2b2b5351d5e7a0b1f3b62af44e24404"

SRC_URI = "git://git.merproject.org/mer-core/buteo-mtp.git;protocol=https \
           file://0001-Remove-dependency-to-SSU-and-tests.patch \
           file://0002-Start-buteo-mtp-as-ceres-by-default.patch \
           file://0003-Fixes-some-dependencies-to-contextkit-bash-and-syste.patch \
           file://0004-fsstorageplugin-Expose-Watch-Memory-instead-of-Phone.patch"
SRCREV = "dd37c4f61e96bc25dd95d9661310e5326e31b593"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"
inherit qmake5

EXTRA_QMAKEVARS_PRE += "QMAKE_CFLAGS_ISYSTEM="

do_install_append() {
    mkdir -p ${D}/lib/systemd/system/local-fs.target.wants
    ln -s ../dev-mtp.mount ${D}/lib/systemd/system/local-fs.target.wants
}

DEPENDS += "buteo-syncfw statefs-qt libqtsparql"

FILES_${PN} += "/lib/systemd/system /usr/lib/systemd/user/ /usr/share/mtp/ /usr/lib/mtp/ /usr/lib/buteo-plugins-qt5"
B="${S}"
