# - Add nativesdk-cmake to enable CMake support in SDKs.
#   Newer Qt projects use CMake instead of qmake.
# - Add nativesdk-qtdeclarative-tools for QML content.
# - Add nativesdk-qttools-tools to allow for including
#   tools like moc and uic in the SDK.
# - Add nativesdk-qttools-dev as well, otherwise the CMake
#   Qt5LinguistTools scripts are not included in an SDK.
RDEPENDS:${PN} += " \
    nativesdk-cmake \
    nativesdk-qtdeclarative-tools \
    nativesdk-qttools-tools \
    nativesdk-qttools-dev \
"
