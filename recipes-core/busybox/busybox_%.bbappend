do_configure:append() {
    sed -i "/CONFIG_KLOGD/c\# CONFIG_KLOGD is not set" .config
}
