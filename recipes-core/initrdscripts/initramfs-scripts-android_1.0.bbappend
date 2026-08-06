FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"
S = "${UNPACKDIR}"
RDEPENDS:${PN} += "e2fsprogs-e2fsck psplash android-tools-adbd"
