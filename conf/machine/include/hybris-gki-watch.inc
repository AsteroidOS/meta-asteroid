# Common settings for Halium/GKI-generation hybris watches: devices with a
# Generic Kernel Image era kernel (5.x+) whose Android vendor stack runs in
# an LXC container (Halium style) instead of meta-android's flat android-init
# chroot. Builds on top of the classic hybris-watch settings.
require conf/machine/include/hybris-watch.inc

# meta-virtualization (LXC) is gated on DISTRO_FEATURES=virtualization.
# Pre-GKI watches don't need LXC, so the feature is set here, not distro-wide.
DISTRO_FEATURES:append = " virtualization"

# The Android side runs as a Halium LXC container, so drop meta-asteroid's
# `android-init` and meta-android's `android-system` (both added by
# hybris-watch.inc) -- the per-device layer ships its own LXC bundle instead.
IMAGE_INSTALL:remove = "android-init android-system"

# GKI kernels must be built with clang, which pulls in meta-clang. meta-clang's
# clang-native and oe-core's llvm-native both install the full LLVM toolchain
# (binaries + headers + libs) and clash in -native recipe sysroots. The
# meta-clang README recommends making clang-native PROVIDE llvm-native and
# preferring it as the provider, so one recipe satisfies both names and
# oe-core's llvm_*.bb never builds.
PROVIDES:append:pn-clang-native = " llvm-native"
PREFERRED_PROVIDER_llvm-native = "clang-native"
