SUMMARY = "AsteroidOS fonts set"
SECTION = "fonts"
HOMEPAGE = "https://github.com/AsteroidOS/asteroid-fonts"
LICENSE = "OFL-1.1 & Apache-2.0 & CC-BY-3.0"
LIC_FILES_CHKSUM = "file://README.md;beginline=6;endline=15;md5=f9ba0acd79b8f80c8b1efdb41a7ae34e"
PR = "r0"
INHIBIT_DEFAULT_DEPS = "1"

inherit allarch
inherit fontcache

SRC_URI = "git://github.com/AsteroidOS/asteroid-fonts.git;protocol=https"
SRCREV = "871b02849988786a76b5948857fdb541417dc94d"
S = "${WORKDIR}/git"

FONT_PACKAGES = "ttf-asteroid-fonts"

do_install() {
    install -d ${D}/usr/share/fonts/
    find ./ -name '*.[to]tf' -exec install -m 0644 {} ${D}/usr/share/fonts \;
}

FILES_${PN} += "/usr/share/fonts"
