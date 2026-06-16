SUMMARY = "KMSRO stub for simpledrm"
HOMEPAGE = "https://gitlab.postmarketos.org/wannjanjic/pmaports/-/blob/master/temp/mesa-dri-simpledrm"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=d2c38ad85003f450ee297d1317a96e20"

SRC_URI = "file://mesa-dri-simpledrm.c \
           file://COPYING"

S = "${UNPACKDIR}"

RDEPENDS:${PN} = "mesa"

do_compile() {
        ${CC} ${LDFLAGS} mesa-dri-simpledrm.c -shared -o simpledrm_dri.so
}

do_install() {
        install -d "${D}/usr/lib/dri"
        install -m 0755 simpledrm_dri.so "${D}/usr/lib/dri/simpledrm_dri.so"
}

FILES:${PN} = "/usr/lib/dri/simpledrm_dri.so"
