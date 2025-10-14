SUMMARY = "NemoMobile's MTP Stack"
HOMEPAGE = "https://github.com/sailfishos/buteo-mtp"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://mts/mts.cpp;beginline=1;endline=30;md5=a2b2b5351d5e7a0b1f3b62af44e24404"

SRC_URI = "git://github.com/sailfishos/buteo-mtp.git;protocol=https;branch=master \
           file://0001-Remove-tests.patch \
           file://0002-fsstorageplugin-Expose-Watch-Memory-instead-of-Phone.patch \
           file://buteo-mtp \
           "
SRCREV = "2bcf6579456086c0ee8fca72d38357d8632ca755"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"
inherit qmake5 pkgconfig

do_configure:prepend() {
    sed -i 's/$$\[QT_INSTALL_LIBS\]/\/usr\/lib/g' mts/common.pri
    sed -i "s@\$\$\[QT_INSTALL_BINS\]@${OE_QMAKE_PATH_EXTERNAL_HOST_BINS}@" mts/platform/storage/fsstorageplugin/fsstorageplugin.pro
}

do_install:append() {
    mkdir -p ${D}${systemd_system_unitdir}/local-fs.target.wants
    ln -s ../dev-mtp.mount ${D}${systemd_system_unitdir}/local-fs.target.wants

    install -m 0755 -d ${D}${bindir}
    install -m 0755 ${UNPACKDIR}/buteo-mtp ${D}${bindir}
}

DEPENDS += "buteo-syncfw libqtsparql nemo-qml-plugin-systemsettings nemo-qml-plugin-dbus"

FILES:${PN} += "${systemd_system_unitdir} /usr/lib/systemd/user/ /usr/share/mtp/ /usr/lib/mtp/ /usr/lib/buteo-plugins-qt5"
B="${S}"
