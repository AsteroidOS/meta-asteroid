inherit core-image
LICENSE = "GPL-2.0"

IMAGE_FEATURES += "splash package-management"

IMAGE_INSTALL += "base-files base-passwd shadow systemd tzdata coreutils bash file findutils gawk grep procps psmisc sed util-linux sudo module-init-tools less logrotate tar zlib gzip bzip2 connman bluez5 cinematicexperience asteroid-launcher"

PACKAGECONFIG_append_pn-qtmultimedia = " gstreamer010"
