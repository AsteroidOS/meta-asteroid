SUMMARY = "NemoMobile's MTP Stack"
HOMEPAGE = "https://github.com/sailfishos/buteo-mtp"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://mtpserver/mtpserver.cpp;beginline=1;endline=30;md5=a2b2b5351d5e7a0b1f3b62af44e24404"

SRC_URI = "git://github.com/sailfishos/buteo-mtp.git;protocol=https \
           file://0001-Remove-dependency-to-SSU-and-tests.patch \
           file://0002-Start-buteo-mtp-as-ceres-by-default.patch \
           file://0003-Fixes-some-dependencies-to-contextkit-bash-and-syste.patch \
           file://0004-fsstorageplugin-Expose-Watch-Memory-instead-of-Phone.patch \
           file://0005-mtp1descriptors-redine-htole16-htole32.-to-make-sure.patch \
           file://0006-FSStoragePlugin-Make-sure-the-inotify_event-s-flexib.patch"
SRCREV = "394df0cedd490f79b6eb2f4a22a2e2813d129432"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"
inherit qmake5

EXTRA_QMAKEVARS_PRE += "QMAKE_CFLAGS_ISYSTEM="

do_install:append() {
    mkdir -p ${D}/lib/systemd/system/local-fs.target.wants
    ln -s ../dev-mtp.mount ${D}/lib/systemd/system/local-fs.target.wants
}

DEPENDS += "buteo-syncfw statefs-qt libqtsparql"

FILES:${PN} += "/lib/systemd/system /usr/lib/systemd/user/ /usr/share/mtp/ /usr/lib/mtp/ /usr/lib/buteo-plugins-qt5"
B="${S}"
