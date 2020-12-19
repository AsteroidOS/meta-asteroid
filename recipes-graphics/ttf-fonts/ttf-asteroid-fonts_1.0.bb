SUMMARY = "AsteroidOS fonts set"
SECTION = "fonts"
HOMEPAGE = "https://github.com/AsteroidOS/asteroid-fonts"
LICENSE = "OFL-1.1 & Apache-2.0 & CC-BY-3.0"
LIC_FILES_CHKSUM = "file://README.md;beginline=6;endline=15;md5=f9ba0acd79b8f80c8b1efdb41a7ae34e"
PR = "r0"
INHIBIT_DEFAULT_DEPS = "1"

inherit allarch
inherit fontcache

SRC_URI = "git://github.com/AsteroidOS/asteroid-fonts.git;protocol=https \
    file://69-emoji.conf"
SRCREV = "${AUTOREV}"
S = "${WORKDIR}/git"

FONT_PACKAGES = "ttf-asteroid-fonts"

do_install() {
    install -d ${D}/usr/share/fonts/
    find ./ -name '*.[to]tf' -exec install -m 0644 {} ${D}/usr/share/fonts \;

    install -d ${D}/home/ceres/.config/fontconfig/conf.d/
    install -m 644 ${WORKDIR}/69-emoji.conf ${D}/home/ceres/.config/fontconfig/conf.d/
}

FILES_${PN} += "/usr/share/fonts /home/ceres/.config/fontconfig/conf.d"

# Installing files in `/home/ceres/`, owned by uid 1000, causes a host-contamination warning.
INSANE_SKIP_${PN} += "host-user-contaminated"
