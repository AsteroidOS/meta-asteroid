inherit pkgconfig

DEPENDS += "sensorfw"

FILESEXTRAPATHS:prepend := "${THISDIR}/qtsensors:"
SRC_URI += " \
    file://0001-Enable-sensorfw.patch \
    file://0002-Add-heart-rate-monitor-sensor-with-sensorfw-backend.patch \
    file://0003-Add-step-counter-sensor-with-sensorfw-backend.patch \
    file://0004-Add-sensorfw-backend-for-pressure-sensor.patch \
"
