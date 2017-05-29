inherit core-image
inherit extrausers
LICENSE = "GPL-2.0"

IMAGE_FEATURES += "splash package-management"

IMAGE_INSTALL += " \
base-files base-passwd systemd busybox iproute2 connman pam-plugin-loginuid bluez5 pulseaudio-server openssh-sshd openssh-sftp-server openssh-scp statefs dsme mce ngfd timed sensorfw android-init mapplauncherd-booster-qtcomponents asteroid-usbsetup mtp-server \
supported-languages asteroid-launcher asteroid-calculator asteroid-calendar asteroid-stopwatch asteroid-settings asteroid-timer asteroid-alarmclock asteroid-weather asteroid-music asteroid-btsyncd"

EXTRA_USERS_PARAMS = "groupadd system; \
                      groupadd statefs; \
                      groupadd -f -g 1024 mtp; \
                      useradd -p '' -G 'audio,video,system,statefs,mtp' ceres"
