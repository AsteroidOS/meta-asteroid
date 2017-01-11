
USE_RUBY = " \
    qtquick1-dev \
    qttranslations-qtquick1 \
    qtwebkit-dev \
    qtwebkit-mkspecs \
    ${@bb.utils.contains('DISTRO_FEATURES', 'opengl', 'qtwebkit-qmlplugins', '', d)} \
"

RDEPENDS_${PN}_remove = "qtmultimedia-plugins"
RDEPENDS_${PN}_remove = "qttools-mkspecs"
RDEPENDS_${PN}_remove = "qttools-staticdev"

RDEPENDS_${PN} += " \
    mapplauncherd-qt \
    qtquick1 \
"
