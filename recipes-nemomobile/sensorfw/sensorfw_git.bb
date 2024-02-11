SUMMARY = "Nemomobile's sensorfw"
HOMEPAGE = "https://github.com/sailfishos/sensorfw"

require sensorfw.inc

FILES:${PN} += "${systemd_system_unitdir} /usr/lib/sensord-qt5/"
FILES:${PN}-dbg += "/usr/share/sensorfw-tests/ /usr/lib/sensord-qt5/.debug/ /usr/lib/sensord-qt5/testing/.debug/"
FILES:${PN}-dev += "/usr/share/qt5/mkspecs/"
