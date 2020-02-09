inherit core-image
inherit extrausers
LICENSE = "GPL-2.0"

IMAGE_FEATURES += "package-management debug-tweaks"

IMAGE_INSTALL += " \
base-files base-passwd systemd busybox iproute2 connman pam-plugin-loginuid bluez5 pulseaudio-server openssh-sshd openssh-sftp-server openssh-scp statefs dsme mce ngfd timed sensorfw android-init resize-rootfs mapplauncherd-booster-qtcomponents usb-moded ofono \
supported-languages asteroid-launcher asteroid-calculator asteroid-calendar asteroid-stopwatch asteroid-settings asteroid-timer asteroid-alarmclock asteroid-weather asteroid-music asteroid-btsyncd asteroid-flashlight"

EXTRA_USERS_PARAMS = "groupadd system; \
                      groupadd statefs; \
                      groupadd gps; \
                      groupadd -f -g 1024 mtp; \
                      useradd -p '' -G 'audio,video,system,gps,statefs,mtp' ceres"

IMAGE_OVERHEAD_FACTOR = "1.0"
IMAGE_ROOTFS_EXTRA_SPACE = "262144"
