SUMMARY = "Symbola Font"
SECTION = "fonts"
HOMEPAGE = "http://users.teilar.gr/~g1951d/"
LICENSE = "PD"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/PD;md5=b3597d12946881e13cb3b548d1173851"
PR = "r0"
# we don't need a compiler nor a c library for these fonts
INHIBIT_DEFAULT_DEPS = "1"

inherit allarch
inherit qmake5_paths

S = "${WORKDIR}/symbola"
SRC_URI = "https://github.com/ugjka/ttf-symbola/raw/master/Symbola.ttf;subdir=${S}"
# If the file updates in the future, it won't stop compilation, but we'll see some warnings
BB_STRICT_CHECKSUM = "0"
SRC_URI[md5sum] = "156be6c48c85484c970d103657e14601"
SRC_URI[sha256sum] = "98C20D0C96BBEE0CB8F125297BAD388210E2E901FEA89820697488AE0A57D688"

FONT_PACKAGES = "ttf-symbola"

do_install() {
    # Different versions of OE seems to require different places for fonts so we install in both share and lib...
    install -d ${D}/usr/share/fonts/
    install -m 0644 ./Symbola.ttf ${D}/usr/share/fonts/
}

FILES_${PN} += "/usr/share/fonts/"
