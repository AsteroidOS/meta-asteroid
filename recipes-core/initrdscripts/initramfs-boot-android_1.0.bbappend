FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
S = "${WORKDIR}"
RDEPENDS_${PN} += "e2fsprogs-e2fsck psplash"
