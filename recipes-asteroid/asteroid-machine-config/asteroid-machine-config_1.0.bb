SUMMARY = "Generates a machine specific config file for AsteroidOS"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-3.0;md5=c79ff39f19dfec6d293b95dea7b07891"

PACKAGE_ARCH = "${MACHINE_ARCH}"

python do_generate_config () {
    machine_vars = {
        "Display": ["MACHINE_DISPLAY_FLAT_TIRE", "MACHINE_DISPLAY_BORDER_GESTURE_WIDTH", "MACHINE_DISPLAY_ROUND"],
        "Capabilities": ["MACHINE_HAS_WLAN", "MACHINE_HAS_SPEAKER"]
    }

    from configparser import ConfigParser
    config = ConfigParser()
    config.optionxform=str

    for key in machine_vars:
        config.add_section(key)
        for var in machine_vars[key]:
            v = var[len("MACHINE_"):]
            if v.startswith(key.upper() + "_"):
                v = v[len(key.upper() + "_"):]
            if d.getVar(var) is not None:
                config.set(key, v, str(d.getVar(var)))

    with open(d.getVar('WORKDIR') + "/machine.conf", "w") as machine_conf:
        config.write(machine_conf)
}

do_install_append() {
    install -d ${D}/etc/asteroid/
    install -m 644 ${WORKDIR}/machine.conf ${D}/etc/asteroid/machine.conf
}

addtask do_generate_config before do_install

FILES_${PN} += "/etc/asteroid/"
