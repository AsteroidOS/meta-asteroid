inherit core-image
inherit extrausers
LICENSE = "GPL-2.0-only"

# Inherit this to be able to produce OE SDKs that are fully capable of building Qt5 code
inherit populate_sdk_qt5

IMAGE_FEATURES += "package-management debug-tweaks"

IMAGE_INSTALL += " \
kernel-modules base-files base-passwd systemd busybox iproute2 connman pam-plugin-loginuid bluez5 polkit polkit-group-rule-datetime \
pulseaudio-server openssh-sshd openssh-sftp-server openssh-scp dsme mce ngfd nfcd timed sensorfw resize-rootfs mapplauncherd-booster-qtcomponents usb-moded ofono \
${@oe.utils.conditional('MACHINE_HAS_WLAN', 'true', 'iproute2 wpa-supplicant connman-client', '', d)} \
qtgraphicaleffects-qmlplugins supported-languages ttf-asteroid-fonts asteroid-launcher asteroid-calculator asteroid-calendar asteroid-stopwatch asteroid-settings asteroid-timer asteroid-alarmclock asteroid-weather asteroid-music asteroid-btsyncd asteroid-flashlight asteroid-diamonds"

EXTRA_USERS_PARAMS = "groupadd system; \
                      groupadd gps; \
                      groupadd datetime; \
                      groupadd -f -g 1024 mtp; \
                      useradd -p '' -G 'audio,video,system,wheel,gps,sailfish-datetime,datetime,mtp,users,input' ceres"

IMAGE_OVERHEAD_FACTOR = "1.0"
IMAGE_ROOTFS_EXTRA_SPACE = "131072"

EXTRA_IMAGECMD:ext4 += " -O^metadata_csum"

DEPENDS:append = " ${@oe.utils.conditional('GENERATE_SPARSE_IMAGE', 'true', 'android-simg2img-native', '', d)} "

generate_sparse_image() {
    if [ -n "${GENERATE_SPARSE_IMAGE}" ]; then
        img2simg "${IMGDEPLOYDIR}/${IMAGE_NAME}.ext4" "${IMGDEPLOYDIR}/${IMAGE_NAME}.simg"
        ln -s "${IMAGE_NAME}.simg" "${IMGDEPLOYDIR}/${IMAGE_LINK_NAME}.simg"
    fi
}

IMAGE_POSTPROCESS_COMMAND:append = " generate_sparse_image ; "
