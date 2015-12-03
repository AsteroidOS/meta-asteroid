SUMMARY = "Moka icon theme adapted to the needs of Lipstick"
HOMEPAGE = "https://github.com/moka-project/moka-icon-theme"
LICENSE = "CC-BY-SA-3.0"
LIC_FILES_CHKSUM = "file://LICENSE_CCBYSA;md5=47a74f3ef9a78060758f375e92a37f5a"

SRC_URI = "git://github.com/moka-project/moka-icon-theme;protocol=https \
           file://index.theme"
SRCREV = "edba1587f4b3014210ca3857bb5fbf913e9a5fd5"
PR = "r1"
PV = "+git${SRCREV}"
S = "${WORKDIR}/git"

do_install() {
    install -d ${D}/usr/share/themes/moka/meegotouch/icons/
    cp --no-dereference ${S}/Moka/256x256/apps/* ${S}/Moka/256x256/web/* ${D}/usr/share/themes/moka/meegotouch/icons/
    cp ${WORKDIR}/index.theme ${D}/usr/share/themes/moka/index.theme
}

FILES_${PN} = "/usr/share/themes/moka"
