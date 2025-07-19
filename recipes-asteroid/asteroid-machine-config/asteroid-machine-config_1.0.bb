SUMMARY = "Generates a machine specific config file for AsteroidOS"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-3.0-only;md5=c79ff39f19dfec6d293b95dea7b07891"

PACKAGE_ARCH = "${MACHINE_ARCH}"

def display_variables(d):
    return ["MACHINE_DISPLAY_FLAT_TIRE", "MACHINE_DISPLAY_BORDER_GESTURE_WIDTH", "MACHINE_DISPLAY_ROUND", "MACHINE_NEEDS_BURN_IN_PROTECTION"]

def capability_variables(d):
    return ["MACHINE_HAS_WLAN", "MACHINE_HAS_SPEAKER"]

def identity_variables(d):
    return ["MACHINE"]

python do_generate_config () {
    machine_vars = {
        "Display": display_variables(d),
        "Capabilities": capability_variables(d),
        "Identity": identity_variables(d)
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
            if not v:
                v = var
            if d.getVar(var) is not None:
                config.set(key, v, str(d.getVar(var)))
    unpackdir = d.getVar('UNPACKDIR')
    os.makedirs(unpackdir, exist_ok=True)
    with open(f"{unpackdir}/machine.conf", "w") as machine_conf:
        config.write(machine_conf)
}

do_install:append() {
    install -d ${D}/etc/asteroid/
    install -m 644 ${UNPACKDIR}/machine.conf ${D}/etc/asteroid/machine.conf
}

def machine_variables(d):
    variables = []
    variables.extend(display_variables(d))
    variables.extend(capability_variables(d))
    return " ".join(variables)

do_generate_config[vardeps] += "${@machine_variables(d)}"
addtask do_generate_config before do_install

FILES:${PN} += "/etc/asteroid/"
