EXTRA_QMAKEVARS_PRE = "CONFIG+=sensorfw"
DEPENDS+="sensorfw"
SRC_URI = "git://github.com/AsteroidOS/qtsensors.git;protocol=https;branch=master"
SRCREV = "${AUTOREV}"
