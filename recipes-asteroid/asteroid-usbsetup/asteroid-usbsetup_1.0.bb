DESCRIPTION = "This installs the usb-setup service Asteroid uses to initialize USB connection"
PR = "r0"
SRC_URI = "file://asteroid-usbsetup.sh \
    file://usb-setup.service"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

do_install() {
    install -d ${D}/usr/sbin/
    install -m 0755 ${WORKDIR}/asteroid-usbsetup.sh ${D}/usr/sbin/asteroid-usbsetup.sh

    install -d ${D}/lib/systemd/system/multi-user.target.wants/
    install -m 0644 ${WORKDIR}/usb-setup.service ${D}/lib/systemd/system/usb-setup.service
    ln -s ../usb-setup.service ${D}/lib/systemd/system/multi-user.target.wants/usb-setup.service
}

FILES_${PN} += " /lib/systemd/system/"
