inherit core-image
inherit extrausers
LICENSE = "GPL-2.0"

IMAGE_FEATURES += "splash package-management"

IMAGE_INSTALL += " \
base-files base-passwd shadow systemd tzdata coreutils bash file findutils gawk grep procps psmisc sed util-linux sudo module-init-tools less tar gzip bzip2 \
connman bluez5 pulseaudio ppp dropbear qtbase-fonts qtbase-fonts-ttf-dejavu qtbase-plugins statefs dsme mce ngfd timed sensorfw android-init mapplauncherd-booster-qtcomponents \
asteroid-launcher asteroid-calculator asteroid-calendar asteroid-stopwatch asteroid-settings"

EXTRA_USERS_PARAMS = "groupadd system; \
                      useradd -p '' -G 'video,system' ceres"

PACKAGECONFIG_append_pn-qtmultimedia = " gstreamer010"
