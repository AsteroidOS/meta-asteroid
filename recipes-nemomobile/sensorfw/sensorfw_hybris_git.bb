require sensorfw_git.inc

PACKAGE = "hybris"

EXTRA_QMAKEVARS_PRE = "CONFIG+=autohybris"

DEPENDS += " libhybris"