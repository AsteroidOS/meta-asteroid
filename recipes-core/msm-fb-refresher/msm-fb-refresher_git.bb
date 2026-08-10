DESCRIPTION = "Some qualcomm devices need a refresher ioctl to show something on screen. This is a simple soft that does that on boot."
PR = "r0"
SRC_URI = "git://github.com/AsteroidOS/msm-fb-refresher.git;protocol=https;branch=master \
    file://msm-fb-refresher.service"
SRCREV = "b89cca860f9c37e71b3fbd5ae53c4e8d521e1de8"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://refresher.c;beginline=1;endline=16;md5=3d0eae401b24b819f25959dcfcc3194f"
PACKAGE_DEBUG_SPLIT_STYLE = "debug-without-src"

do_compile() {
    ${CC} ${CFLAGS} ${LDFLAGS} ${S}/refresher.c -o ${S}/msm-fb-refresher
}

do_install() {
    install -m 0755 -d ${D}${bindir}
    install -m 0755 ${S}/msm-fb-refresher ${D}${bindir}

    install -d ${D}/etc/systemd/system/multi-user.target.wants/
    install -m 0644 ${UNPACKDIR}/msm-fb-refresher.service ${D}/etc/systemd/system/
    ln -s ../msm-fb-refresher.service ${D}/etc/systemd/system/multi-user.target.wants/msm-fb-refresher.service
}

