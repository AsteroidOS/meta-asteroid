do_install:prepend() {
    install -d ${D}${datadir}/zoneinfo

    (cd ${S}; oe_runmake tzdata.zi)
    cp -pP "${S}/tzdata.zi" ${D}${datadir}/zoneinfo
}

FILES:tzdata-core += "${datadir}/zoneinfo/tzdata.zi"
