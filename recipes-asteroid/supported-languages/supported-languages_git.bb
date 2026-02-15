SUMMARY = "Set of config files describing the languages that are available on AsteroidOS"
HOMEPAGE = "https://github.com/AsteroidOS/supported-languages"
LICENSE = "CC0-1.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=65d3616852dbf7b1a6d4b53b00626032"

SRC_URI = "git://github.com/AsteroidOS/supported-languages.git;protocol=https;branch=2.0 \
    file://locale.conf \
    file://localeEnv.conf"
SRCREV = "1fe33027ced04a31420a1ec1ae6ba7b79343afba"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"

RDEPENDS:${PN} += "source-han-sans-cn-fonts source-han-sans-kr-fonts ttf-lohit ttf-dejavu-sans"

FILES:${PN} += "/etc/systemd/system/user@.service.d/ /usr/lib/systemd/user/ /usr/share/supported-languages/ /home/.system/var/lib/environment/1000"

inherit asteroid-users

do_install:append() {
    install -d ${D}/etc/systemd/system/user@.service.d/
    install -m 644 ${UNPACKDIR}/localeEnv.conf ${D}/etc/systemd/system/user@.service.d/locale.conf

    install -d ${D}/home/.system/var/lib/environment/${CERES_UID}/
    install -m 644 ${UNPACKDIR}/locale.conf ${D}/home/.system/var/lib/environment/${CERES_UID}/locale.conf

    # TODO: Ensure this only allows asteroid-settings to write to this file, so
    # that others apps cannot set environment variables
    chown ceres:ceres ${D}/home/.system/var/lib/environment/${CERES_UID}/locale.conf

    install -d ${D}/usr/share/supported-languages/
    cp ${S}/*.conf ${D}/usr/share/supported-languages/
}
