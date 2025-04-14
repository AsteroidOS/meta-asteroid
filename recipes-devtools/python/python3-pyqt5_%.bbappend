# Only build selected PyQt modules (exclude QtWidgets)
PYQT_MODULES = "QtCore QtNetwork QtDBus QtGui QtQuick QtQml"

EXTRA_OESIPTOOLS += "--no-module QtWidgets"

# the patches below to fix errors were copied from 
# https://github.com/STMicroelectronics/meta-st-pkgrepo-updates/blob/openstlinux-ecosystem-5.0.0/recipes-python/pyqt5/python3-pyqt5_5.15.9.bb
# License: https://github.com/STMicroelectronics/meta-st-pkgrepo-updates/blob/openstlinux-ecosystem-5.0.0/COPYING.MIT
do_configure:prepend() {
    extra_args=""

    cd ${S}

    # update pyproject.toml to fix the error:
    # LONG_BIT definition appears wrong for platform (bad gcc/glibc config?).
    grep -q '\[tool.sip.project\]' pyproject.toml || echo "[tool.sip.project]" >> pyproject.toml
    sed -i -e '/py-include-dir/d' pyproject.toml
    sed -i -e '/\[tool\.sip\.project\]/a\' -e 'py-include-dir = \"${STAGING_INCDIR}/${PYTHON_DIR}${PYTHON_ABI}\"' pyproject.toml

    # update pyproject.toml to fix the error:
    # file not recognized: file format not recognized
    # (not sure the fix is taken into account: see do_compilee:prepend)
    grep -q '\[tool.sip.bindings.PyQt5\]' pyproject.toml || echo "[tool.sip.bindings.PyQt5]" >> pyproject.toml
    sed -i -e '/library-dirs/d' pyproject.toml
    sed -i -e '/\[tool\.sip\.bindings\.PyQt5\]/a\' -e 'library-dirs = [\"${STAGING_LIBDIR}\"]' pyproject.toml

    
    for i in ${DISABLED_FEATURES}; do
        extra_args="$extra_args --disabled-feature=$i"
    done

    for i in ${PYQT_MODULES}; do
        extra_args="$extra_args --enable=$i"
    done

    sip-build \
        --verbose \
        --confirm-license \
        --scripts-dir="${bindir}" \
        --build-dir="${B}" \
        --target-dir="${PYTHON_SITEPACKAGES_DIR}" \
        --qmake=${OE_QMAKE_QMAKE} \
        --no-make \
        --enable=pylupdate \
        --enable=pyrcc \
        --enable=Qt \
        --enable=QtCore \
        --no-dbus-python \
        $extra_args

    QMAKE_PROFILES=${B}/PyQt5.pro
}

do_compile:prepend() {
    # fix *.pro defining LIBS with recipe-sysroot-native hence generating the error:
    # file not recognized: file format not recognized
    find ${B} -name "*.pro" -type f -exec sed -i -E 's,^(LIBS)[[:blank:]]+\+=[[:blank:]]+(.*)/recipe-sysroot-native/(.*)$,\1 += \2/recipe-sysroot/\3,' {} \;
}
