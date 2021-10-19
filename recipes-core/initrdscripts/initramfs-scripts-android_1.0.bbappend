FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"
S = "${WORKDIR}"
RDEPENDS:${PN} += "e2fsprogs-e2fsck psplash android-tools-adbd"
