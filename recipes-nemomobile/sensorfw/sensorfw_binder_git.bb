require sensorfw_git.inc

PACKAGE = "binder"

EXTRA_QMAKEVARS_PRE = "CONFIG+=hybris CONFIG+=binder"

DEPENDS += " libhybris libgbinder glib-2.0 libglibutil"