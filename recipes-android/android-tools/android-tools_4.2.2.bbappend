do_configure_append() {
    sed -i "s@/system/bin/sh@/bin/sh@g" core/adbd/services.c
}
