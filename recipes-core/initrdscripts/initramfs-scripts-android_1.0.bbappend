FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"
S = "${UNPACKDIR}/sources"
RDEPENDS:${PN} += "e2fsprogs-e2fsck psplash android-tools-adbd"
