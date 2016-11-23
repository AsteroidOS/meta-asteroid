SUMMARY = "Roboto fonts - TTF Version"
SECTION = "fonts"
HOMEPAGE = "https://www.google.com/fonts/specimen/Roboto"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"
PR = "r0"
# we don't need a compiler nor a c library for these fonts
INHIBIT_DEFAULT_DEPS = "1"

inherit allarch
inherit qmake5_paths

SRC_URI = "git://github.com/google/roboto.git;protocol=https"
SRCREV = "f4b08009088d112fc495cb47adb97f1aa83f1967"
S = "${WORKDIR}/git"

FONT_PACKAGES = "ttf-roboto"

do_install() {
    # Different versions of OE seems to require different places for fonts so we install in both share and lib...
    install -d ${D}/${OE_QMAKE_PATH_QT_FONTS}
    find ./ -name 'hinted/*.tt[cf]' -exec install -m 0644 {} ${D}/${OE_QMAKE_PATH_QT_FONTS} \;
}

FILES_${PN} += "${OE_QMAKE_PATH_QT_FONTS}"
