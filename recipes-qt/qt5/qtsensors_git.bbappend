EXTRA_QMAKEVARS_PRE = "CONFIG+=sensorfw"
DEPENDS+="sensorfw"

do_install_append() {
  install -d ${D}/etc/QtProject/
  mv ${D}/etc/xdg/QtProject/Sensors.conf ${D}/etc/QtProject/Sensors.conf
}
