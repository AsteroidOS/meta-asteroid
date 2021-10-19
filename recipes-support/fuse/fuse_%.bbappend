do_install:append() {
    # Remove /etc/modules-load.d/fuse.conf which makes the systemd-modules-load.service fail
    if ${@bb.utils.contains('DISTRO_FEATURES', 'systemd', 'true', 'false', d)}; then
        rm -r ${D}${sysconfdir}/modules-load.d
    fi

    echo "user_allow_other" >> ${D}${sysconfdir}/fuse.conf
}
