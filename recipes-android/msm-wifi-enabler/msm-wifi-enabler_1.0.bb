DESCRIPTION = "Load the WiFi firmware and enable driver"
PR = "r0"
SRC_URI = "file://msm-wifi-enabler.service"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"
S = "${WORKDIR}/sources"
UNPACKDIR = "${S}"

inherit systemd

SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE:${PN} = "msm-wifi-enabler.service"

do_install() {
    install -d ${D}${systemd_unitdir}/system
    install -m 0644 ${UNPACKDIR}/msm-wifi-enabler.service ${D}${systemd_unitdir}/system/
}
