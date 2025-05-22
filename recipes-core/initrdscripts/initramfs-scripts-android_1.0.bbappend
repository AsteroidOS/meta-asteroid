FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"
S = "${WORKDIR}/sources"
UNPACKDIR = "${S}"
RDEPENDS:${PN} += "e2fsprogs-e2fsck psplash android-tools-adbd"
