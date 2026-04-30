inherit pkgconfig

EXTRA_QMAKEVARS_PRE = "CONFIG+=sensorfw"
DEPENDS += "sensorfw"
SRC_URI = "git://github.com/qt/qtsensors.git;protocol=https;branch=6.11;nobranch=1;name=${QT_MODULE};destsuffix=${BB_GIT_DEFAULT_DESTSUFFIX}"
SRCREV = "6.11.0"
