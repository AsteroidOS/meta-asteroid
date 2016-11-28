SUMMARY = "Raleway fonts - TTF Version"
SECTION = "fonts"
HOMEPAGE = "https://www.google.com/fonts/specimen/Raleway"
LICENSE = "OFL-1.1"
LIC_FILES_CHKSUM = "file://LICENSE;md5=784289da8505331504090d541a8a81f6"
PR = "r0"
# we don't need a compiler nor a c library for these fonts
INHIBIT_DEFAULT_DEPS = "1"

inherit allarch
inherit qmake5_paths

SRC_URI = "git://github.com/softwaymedical/raleway.git;protocol=https"
SRCREV = "de9688124c3d7b5b611f92eab376a9d65fd56f39"
S = "${WORKDIR}/git"

FONT_PACKAGES = "ttf-raleway"

do_install() {
    # Different versions of OE seems to require different places for fonts so we install in both share and lib...
    install -d ${D}/${OE_QMAKE_PATH_QT_FONTS}
    find ./ -name '*.tt[cf]' -exec install -m 0644 {} ${D}/${OE_QMAKE_PATH_QT_FONTS} \;
}

FILES_${PN} += "${OE_QMAKE_PATH_QT_FONTS}"
