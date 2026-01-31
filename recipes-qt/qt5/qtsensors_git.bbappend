inherit pkgconfig

EXTRA_QMAKEVARS_PRE = "CONFIG+=sensorfw"
DEPENDS += "sensorfw"
SRC_URI = "git://github.com/AsteroidOS/qtsensors.git;protocol=https;branch=master"
SRCREV = "d1b400561060aa1157008697400ea70db2402b6a"
