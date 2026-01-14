SUMMARY = "AsteroidOS fonts set"
SECTION = "fonts"
HOMEPAGE = "https://github.com/AsteroidOS/asteroid-fonts"
LICENSE = "OFL-1.1 & Apache-2.0 & CC-BY-3.0 & CC-BY-4.0 & MIT"
LIC_FILES_CHKSUM = "file://README.md;beginline=9;endline=25;md5=ab62300cfd2695c80cf7c2aedcfd0688"
PR = "r1"
INHIBIT_DEFAULT_DEPS = "1"

inherit allarch
inherit fontcache
inherit asteroid-users

SRC_URI = "git://github.com/AsteroidOS/asteroid-fonts.git;protocol=https;branch=master \
    file://69-emoji.conf"
SRCREV = "778f8485c8cd81d736a5244e65e96df0bfa59700"
PR = "r1"
PV = "+git${SRCPV}"

FONT_PACKAGES = "ttf-asteroid-fonts"

do_install() {
    install -d ${D}/usr/share/fonts/
    find ./ -name '*.[to]tf' -exec install -m 0644 {} ${D}/usr/share/fonts \;

    install -d ${D}/home/ceres/.config/fontconfig/conf.d/
    install -m 644 ${UNPACKDIR}/69-emoji.conf ${D}/home/ceres/.config/fontconfig/conf.d/
}

FILES:${PN} += "/usr/share/fonts /home/ceres/.config/fontconfig/conf.d"
