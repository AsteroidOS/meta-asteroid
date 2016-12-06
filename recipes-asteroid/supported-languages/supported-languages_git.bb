SUMMARY = "Set of config files describing the languages that are available on AsteroidOS"
HOMEPAGE = "https://github.com/AsteroidOS/supported-languages"
LICENSE = "CC0-1.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=65d3616852dbf7b1a6d4b53b00626032"

SRC_URI = "git://github.com/AsteroidOS/supported-languages.git;protocol=https \
    file://locale.conf \
    file://localeEnv.conf"
SRCREV = "3f51e809d750007e7bb8198e8308862905a4775a"
PR = "r1"
PV = "+git${SRCREV}"
S = "${WORKDIR}/git"

FILES_${PN} += "/etc/systemd/system/user@.service.d/ /usr/lib/systemd/user/ /usr/share/jolla-supported-languages/"

INSANE_SKIP_${PN} += "host-user-contaminated"

do_install_append() {
    install -d ${D}/etc/systemd/system/user@.service.d/
    cp ../localeEnv.conf ${D}/etc/systemd/system/user@.service.d/locale.conf

    install -d ${D}/var/lib/environment/ceres/
    cp ../locale.conf ${D}/var/lib/environment/ceres/locale.conf

    # TODO: Ensure this only allows asteroid-settings to write to this file, so
    # that others apps cannot set environment variables
    chown 1000:1000 ${D}/var/lib/environment/ceres/locale.conf # ceres:ceres

    install -d ${D}/usr/share/jolla-supported-languages/
    cp ${S}/*.conf ${D}/usr/share/jolla-supported-languages/
}
