SUMMARY = "NemoMobile's MTP Stack"
HOMEPAGE = "https://git.merproject.org/mer-core/buteo-mtp"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://mtpserver/mtpserver.cpp;beginline=1;endline=30;md5=a2b2b5351d5e7a0b1f3b62af44e24404"

SRC_URI = "git://git.merproject.org/mer-core/buteo-mtp.git;protocol=https \
           file://0001-Remove-dependency-to-SSU.patch"
SRCREV = "dd37c4f61e96bc25dd95d9661310e5326e31b593"
PR = "r1"
PV = "+git${SRCREV}"
S = "${WORKDIR}/git"
inherit qmake5

do_configure_prepend() {
    sed -i "s@contextkit-statefs@contextkit-statefs contextsubscriber-1.0@" ${S}/mts/common.pri
    sed -i "s@buteosyncfw5@buteosyncfw5 contextsubscriber-1.0@" ${S}/service/service.pro
    sed -i "s@/bin/bash@/bin/sh@" ${S}/service/start-mtp.sh
}

DEPENDS += "buteo-syncfw statefs-qt"

FILES_${PN} += "/lib/systemd/system /usr/lib/systemd/user/ /usr/share/mtp/ /usr/lib/mtp/ /usr/lib/buteo-plugins-qt5"
B="${S}"
