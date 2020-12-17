SUMMARY = "Google noto emoji font pack"
SECTION = "fonts"
HOMEPAGE = "https://github.com/googlefonts/noto-emoji"
LICENSE = "OFL-1.1"
LIC_FILES_CHKSUM = "file://fonts/LICENSE;md5=55719faa0112708e946b820b24b14097"
INHIBIT_DEFAULT_DEPS = "1"

inherit allarch fontcache

SRC_URI = "git://github.com/googlefonts/noto-emoji;protocol=https \
    file://69-emoji.conf"
SRCREV = "833a43d03246a9325e748a2d783006454d76ff66"

PACKAGES = "${PN}-color ${PN}-regular"
FONT_PACKAGES = "${PN}-color ${PN}-regular"

S = "${WORKDIR}/git"

FILES_${PN}-color += "/home/ceres/.config/fontconfig/conf.d"
FILES_${PN}-regular += "/home/ceres/.config/fontconfig/conf.d"
FILES_${PN}-color += "/usr/share/fonts/NotoColorEmoji.ttf"
FILES_${PN}-regular += "/usr/share/fonts/NotoEmoji-Regular.ttf"

do_install() {
    install -d ${D}/usr/share/fonts/
    find ./ -name '*.[to]tf' -exec install -m 0644 {} ${D}/usr/share/fonts \;

    install -d ${D}/home/ceres/.config/fontconfig/conf.d/
    install -m 644 ../69-emoji.conf ${D}/home/ceres/.config/fontconfig/conf.d/
}

do_compile[noexec] = "1"

INSANE_SKIP_${PN}-color += "host-user-contaminated"
INSANE_SKIP_${PN}-regular += "host-user-contaminated"