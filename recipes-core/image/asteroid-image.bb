inherit core-image

DESCRIPTION = "Asteroid Image."
LICENSE = "GPL-2.0"

IMAGE_INSTALL += "base-files base-passwd netbase keymaps strace ltrace procps gdb dosfstools nano bash acl coreutils e2fsprogs file findutils gawk grep makedevs mktemp ncurses net-tools psmisc sed tar time util-linux zlib iproute2 iputils iptables module-init-tools openssl ethtool gzip shadow sudo at bzip2 elfutils dbus dbus-glib less logrotate tzdata sysfsutils systemd qtbase qtbase-tools qt5-qpa-hwcomposer-plugin lipstick qt5everywheredemo"

IMAGE_FEATURES += "splash package-management"
