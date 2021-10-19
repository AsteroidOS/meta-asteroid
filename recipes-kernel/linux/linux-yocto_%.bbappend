FILESEXTRAPATHS:prepend := "${THISDIR}/linux-yocto:"
SRC_URI += " file://drm-virtio-gpu.cfg "

KERNEL_CONFIG_FRAGMENTS:append:qemux86 = " ${WORKDIR}/drm-virtio-gpu.cfg"
