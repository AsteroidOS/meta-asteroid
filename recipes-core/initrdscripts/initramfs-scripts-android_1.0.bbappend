FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"
S = "${WORKDIR}/sources"
RDEPENDS:${PN} += "e2fsprogs-e2fsck psplash android-tools-adbd"
