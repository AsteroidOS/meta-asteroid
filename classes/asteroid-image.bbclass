inherit core-image
LICENSE = "GPL-2.0"

IMAGE_FEATURES += "splash package-management"

IMAGE_INSTALL += " \
base-files base-passwd shadow systemd tzdata coreutils bash file findutils gawk grep procps psmisc sed util-linux sudo module-init-tools less tar gzip bzip2 \
connman bluez5 pulseaudio ppp dropbear qtbase-fonts qtbase-fonts-ttf-dejavu qtbase-plugins statefs dsme mce ngfd timed sensorfw android-init \
asteroid-launcher asteroid-calculator asteroid-calendar asteroid-stopwatch"

PACKAGECONFIG_append_pn-qtmultimedia = " gstreamer010"
