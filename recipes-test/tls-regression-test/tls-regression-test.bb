DESCRIPTION = "TLS regression test to check for Bionic and libc TLS area conflicts."
HOMEPAGE = "https://paste.pound-python.org/show/RXOUuQQKmuQ0bYSJHACy/"
LICENSE = "CLOSED"
PR = "r0"
SRC_URI = "https://paste.pound-python.org/raw/RXOUuQQKmuQ0bYSJHACy/;downloadfilename=tls-regression-test.c"
SRC_URI[md5sum] = "a988a6a447c8ec198d24f0125c8393e9"
SRC_URI[sha256sum] = "7ce33978b7c773c5e6c942e7d716b95cbbc22b37a4566fc52e6441cfbc9a46b7"
S = "${UNPACKDIR}/sources"
PACKAGE_DEBUG_SPLIT_STYLE = "debug-without-src"

DEPENDS = "libhybris"

do_compile() {
    ${CC} ${CFLAGS} ${LDFLAGS} ${S}/tls-regression-test.c -o ${S}/tls-regression-test -lEGL -lGLESv2
}

do_install() {
    install -m 0755 -d ${D}${bindir}
    install -m 0755 ${S}/tls-regression-test ${D}${bindir}
}

