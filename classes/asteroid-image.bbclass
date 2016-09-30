inherit core-image
inherit extrausers
LICENSE = "GPL-2.0"

IMAGE_FEATURES += "splash package-management"

IMAGE_INSTALL += " \
base-files base-passwd systemd busybox iproute2 connman bluez5 dropbear statefs dsme mce ngfd timed sensorfw android-init mapplauncherd-booster-qtcomponents usb-moded \
supported-languages asteroid-launcher asteroid-calculator asteroid-calendar asteroid-stopwatch asteroid-settings asteroid-timer asteroid-alarmclock asteroid-weather asteroid-music asteroid-btsyncd"

EXTRA_USERS_PARAMS = "groupadd system; \
                      groupadd statefs; \
                      useradd -p '' -G 'video,system,statefs' ceres"
