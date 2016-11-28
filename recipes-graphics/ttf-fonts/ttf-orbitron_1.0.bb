SUMMARY = "Orbitron fonts - TTF Version"
SECTION = "fonts"
HOMEPAGE = "https://www.google.com/fonts/specimen/Orbitron"
LICENSE = "OFL-1.1"
LIC_FILES_CHKSUM = "file://Open%20Font%20License.markdown;md5=b94d2318897b36cfe9a9431eba1e1354"
PR = "r0"
# we don't need a compiler nor a c library for these fonts
INHIBIT_DEFAULT_DEPS = "1"

inherit allarch
inherit qmake5_paths

SRC_URI = "git://github.com/theleagueof/orbitron.git;protocol=https"
SRCREV = "13e6a5222aa6818d81c9acd27edd701a2d744152"
S = "${WORKDIR}/git"

FONT_PACKAGES = "ttf-orbitron"

do_install() {
    # Different versions of OE seems to require different places for fonts so we install in both share and lib...
    install -d ${D}/${OE_QMAKE_PATH_QT_FONTS}
    find ./ -name '*.tt[cf]' -exec install -m 0644 {} ${D}/${OE_QMAKE_PATH_QT_FONTS} \;
}

FILES_${PN} += "${OE_QMAKE_PATH_QT_FONTS}"
