# This enables sudo privileges for the 'wheel' group
do_install:append() {
    # remove '#' from line '%wheel ALL=(ALL:ALL) ALL'
    sed '/^# %wheel ALL=(ALL:ALL) ALL$/s/^#//' -i  ${D}/${sysconfdir}/sudoers
}
