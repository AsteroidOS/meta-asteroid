DESCRIPTION = "A simple second-stage bootloader which provides a clean environment for booting Linux"
HOMEPAGE = "https;//github.com/ivoszbg/uniLoader.git"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=ba925be40dd5b952d53f0414e95a491a"

SRC_URI = "git://github.com/ivoszbg/uniLoader.git;branch=master;protocol=https"
SRCREV = "831c31bac9fc93f4787d6349006766844fdeb7b2"
S = "${WORKDIR}/git"

SYSROOT_DIRS = "/uniloader"

do_configure[noexec] = "1"
do_compile[noexec] = "1"

do_install() {
    install -d "${D}/uniloader"
    cp -r "${S}"/* "${D}/uniloader"
}

FILES:${PN} = "/uniloader"
