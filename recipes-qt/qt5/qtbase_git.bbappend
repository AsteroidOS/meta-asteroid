FILESEXTRAPATHS_prepend := "${THISDIR}/qtbase:"
SRC_URI += " file://0001-Forces-GLES2-the-dirty-way.patch"

# Remove dependencies to mesa
PACKAGECONFIG_remove = "kms"
PACKAGECONFIG_remove = "gl"
PACKAGECONFIG_append += "gles2 mtdev linuxfb accessibility icu sql-sqlite"
