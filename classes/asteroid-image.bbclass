inherit core-image
inherit extrausers
LICENSE = "GPL-2.0"

IMAGE_FEATURES += "package-management debug-tweaks"

IMAGE_INSTALL += " \
kernel-modules base-files base-passwd systemd busybox iproute2 connman pam-plugin-loginuid bluez5 pulseaudio-server openssh-sshd openssh-sftp-server openssh-scp statefs dsme mce ngfd timed sensorfw android-init resize-rootfs mapplauncherd-booster-qtcomponents usb-moded ofono \
${@oe.utils.conditional('MACHINE_HAS_WLAN', 'true', 'iproute2 wpa-supplicant connman-client', '', d)} \
qtgraphicaleffects-qmlplugins supported-languages ttf-asteroid-fonts asteroid-launcher asteroid-calculator asteroid-calendar asteroid-stopwatch asteroid-settings asteroid-timer asteroid-alarmclock asteroid-weather asteroid-music asteroid-btsyncd asteroid-flashlight"

EXTRA_USERS_PARAMS = "groupadd system; \
                      groupadd statefs; \
                      groupadd gps; \
                      groupadd -f -g 1024 mtp; \
                      useradd -p '' -G 'audio,video,system,gps,statefs,mtp' ceres"

IMAGE_OVERHEAD_FACTOR = "1.0"
IMAGE_ROOTFS_EXTRA_SPACE = "131072"
