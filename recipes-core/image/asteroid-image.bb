inherit core-image

DESCRIPTION = "Asteroid Image."
LICENSE = "GPL-2.0"

IMAGE_INSTALL += "base-files base-passwd netbase keymaps strace ltrace procps gdb dosfstools nano bash acl coreutils e2fsprogs file findutils gawk grep makedevs mktemp ncurses net-tools psmisc sed tar time util-linux zlib iproute2 iputils iptables module-init-tools openssl ethtool gzip shadow sudo at bzip2 elfutils dbus dbus-glib less logrotate tzdata sysfsutils systemd qtbase qtbase-tools lipstick cinematicexperience"

PACKAGECONFIG_append_pn-qtmultimedia = " gstreamer010"
IMAGE_FEATURES += "splash package-management"
