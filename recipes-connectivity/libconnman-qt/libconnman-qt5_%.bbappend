SRCREV = "1.3.2"
FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://0001-Wait-for-dbus-call-to-finish-in-NetworkTechnology.patch \
            file://0002-Register-dbus-types-in-networktechnology.patch \
            "

