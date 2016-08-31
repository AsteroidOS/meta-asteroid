SUMMARY = "OpenSans fonts - TTF Version"
SECTION = "fonts"
HOMEPAGE = "https://www.google.com/fonts/specimen/Open+Sans"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"
PR = "r0"
# we don't need a compiler nor a c library for these fonts
INHIBIT_DEFAULT_DEPS = "1"

inherit allarch fontcache

SRC_URI = "git://github.com/ppowalowski/fontface-open-sans.git;protocol=https"
SRCREV = "462165fa0e73a665d2fbc8c80ecc23ce135700da"
S = "${WORKDIR}/git"

FONT_PACKAGES = "ttf-opensans"

do_install() {
    install -d ${D}/usr/share/fonts/
    find ./ -name '*.tt[cf]' -exec install -m 0644 {} ${D}/usr/share/fonts/ \;
}

FILES_${PN} += "/usr/share/fonts/"
