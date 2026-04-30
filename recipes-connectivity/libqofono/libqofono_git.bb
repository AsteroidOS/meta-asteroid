DESCRIPTION = "Qt 6 bindings for the ofono dbus API"
SECTION = "libs"
LICENSE = "LGPL-2.1-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=4fbd65380cdd255951079008b364516c"

DEPENDS += "qtbase qtdeclarative"

SRCREV = "72a6943f4f7aa6b53c91793e2a4b32093a255b61"
PV = "0.123"

SRC_URI = "git://github.com/sailfishos/libqofono.git;protocol=https;branch=master"
S = "${WORKDIR}/git"

inherit qt6-qmake

PACKAGES += "${PN}-tests"

FILES:${PN}-tests = " \
    /opt/examples/libqofono-qt6/ \
    /opt/tests/libqofono-qt6 \
    /opt/tests/libqofono-qt5 \
"
FILES:${PN} += " \
    ${OE_QMAKE_PATH_QML}/QOfono/qmldir \
    ${OE_QMAKE_PATH_QML}/QOfono/plugins.qmltypes \
    ${OE_QMAKE_PATH_QML}/QOfono/libQOfonoQtDeclarative.so \
"
FILES:${PN}-dev += " \
    ${libdir}/libqofono-qt6.prl \
    ${datadir}/qt6/mkspecs \
"

# ERROR: libqofono-0.123-r0 do_package_qa: QA Issue: File /usr/lib/libqofono-qt6.prl in package libqofono-dev contains reference to TMPDIR [buildpaths]
ERROR_QA:remove = "buildpaths"
WARN_QA:append = " buildpaths"
