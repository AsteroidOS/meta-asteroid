FILESEXTRAPATHS_prepend := "${THISDIR}/openssh:"
SRC_URI += "file://0001-Deny-non-fatal-shmget-shmat-shmdt-in-preauth-privsep.patch"