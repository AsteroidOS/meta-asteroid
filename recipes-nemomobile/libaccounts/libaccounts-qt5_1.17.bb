SUMMARY = "Accounts management library for Qt applications"
HOMEPAGE = "https://gitlab.com/accounts-sso/libaccounts-qt"
LICENSE = "LGPL-2.1-or-later"
LIC_FILES_CHKSUM = "file://COPYING;md5=243b725d71bb5df4a1e5920b344b86ad"

inherit qmake5 pkgconfig

SRC_URI = "git://gitlab.com/accounts-sso/libaccounts-qt.git;protocol=https;branch=master"

SRCREV = "c8fdd05f1a1ff5886f4649d24f2ba8c5f61cfa3a"
S = "${WORKDIR}/git"

do_install:append() {
    # The build system always installs the test program into ${bindir}.
    # There is no way to prevent it from happening without patching
    # the code. To avoid patching, delete the copy from ${bindir}.
    #
    # Also, currently using this for ptest functionality is impractical,
    # since it requires a usable dbus instance for its test. Typically,
    # dbus-test-runner is used for this to sandbox the test, but that
    # component is not available in OE at this time.
    rm ${D}/${bindir}/accountstest
    rmdir ${D}/${bindir}
}

DEPENDS += "qtbase libaccounts-glib doxygen-native"

FILES:${PN}-dev += "${libdir}/cmake"
